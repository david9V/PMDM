package com.hg.microservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hg.microservices.models.Course;
import com.hg.microservices.models.Teacher;

@Controller
public class Controlador3 {
	
	@RequestMapping(value = "/listadoJSPCourse")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri2 = "/WEB-INF/vistas/index.jsp";
        List<Course> l = obtenerDTO_list(request, response);
        Iterator<Course> it = l.listIterator();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Listado de cursos</title></head>");
/*
        while (it.hasNext()) {
            out.println("<h2>" + ((Teacher) it.next()).getEmail() + "</h2><br>");
        }

*/
        out.println("</body></html>");
        /*
         * RequestDispatcher dispatcher = request.getRequestDispatcher(uri2); if
         * (dispatcher != null){ dispatcher.forward(request, response); }
         */
    }

    protected List<Course> obtenerDTO_list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = "/api/colegio/cursos";

        String url1 = "http://localhost:8081/api/colegio/cursos";
        List<Course> l = new LinkedList<Course>();
        Course c;
        try {
            URL url = new URL(url1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            
            		
            String output;
            List<Course> list = new ArrayList();

            // tratar la lista de objetos JSON
            while ((output = br.readLine()) != null) {
                //System.out.println(output.toString());
                JsonParser parser = new JsonParser();
                Object obj = parser.parse(output);
                JsonArray json = (JsonArray) obj;
                for (int i = 0; i < json.size(); i++) {
                    JsonObject object = (JsonObject) json.get(i);
                    c = new Course();
                    
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
