package com.hg.microservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hg.microservices.models.Course;
import com.hg.microservices.models.Teacher;

@Controller
public class Controlador4 {

    @RequestMapping(value = "/listadoJSP2")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri2 = "/WEB-INF/vistas/index.jsp";
        List<Teacher> l = obtenerDTO_list(request, response);
        Iterator<Teacher> it = l.listIterator();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Listado de profesores</title></head>");

        while (it.hasNext()) {
            out.println("<h2>" + ((Teacher) it.next()).getEmail() + "</h2><br>");
        }

        out.println("</body></html>");
        /*
         * RequestDispatcher dispatcher = request.getRequestDispatcher(uri2); if
         * (dispatcher != null){ dispatcher.forward(request, response); }
         */
    }

    protected List<Teacher> obtenerDTO_list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = "/api/colegio/profesores";

        String url1 = "http://localhost:8081/api/colegio/profesores";
        List<Teacher> l = new LinkedList<Teacher>();
        Teacher t;
        try {
            URL url = new URL(url1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            
        	Gson gson = new Gson();
            Teacher tich = gson.fromJson(br, Teacher.class); 
            		
            String output;
            List<Teacher> list = new ArrayList();

            // tratar la lista de objetos JSON
            while ((output = br.readLine()) != null) {
                //System.out.println(output.toString());
                JsonParser parser = new JsonParser();
                Object obj = parser.parse(output);
                JsonArray json = (JsonArray) obj;
                for (int i = 0; i < json.size(); i++) {

                    JsonObject object = (JsonObject) json.get(i);
                    
                    // hay que parsear uno a uno los atributos del objeto Teacher y añadirlo a una
                    // lista
                    Teacher teacher = new Teacher();
                    teacher.setId(String.valueOf(object.get("id")));
                    teacher.setDegree(String.valueOf(object.get("degree")));
                    teacher.setSalary(Double.valueOf(String.valueOf(object.get("salary"))));
                    teacher.setName(String.valueOf(object.get("name")));
                    teacher.setGender(String.valueOf(object.get("gender")));
                    teacher.setEmail(String.valueOf(object.get("email")));
                    JsonArray coursesJson = object.getAsJsonArray("courses");
                    List<Course> courseList = new LinkedList();
                    
                    for (int j = 0; j < coursesJson.size(); j++) {
                    	JsonElement cEl = coursesJson.get(i);
                    	System.out.println(gson.toJson(cEl));
                    	/*
                    	JsonObject cJson = cEl.getAsJsonObject();
                    	Course c = new Course();
                    	c.setName(String.valueOf(cJson.get("name")));
                    	c.setStart_date(Date.valueOf(String.valueOf(cJson.get("start_date"))).toLocalDate());
                    	c.setEnding_date(Date.valueOf(String.valueOf(cJson.get("ending_date"))).toLocalDate());
                    	courseList.add(c);
                    	System.out.println(c);
                    	*/
                    }
                    
                    teacher.setCourses(courseList);
                    
                    
                    System.out.println(teacher);
                    //System.out.println(object.get("id"));
                    //System.out.println(object.get("name"));
                    
                }

            }
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;

    }

}