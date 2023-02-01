package com.hg.microservices.models.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hg.microservices.models.Course;
import com.hg.microservices.models.Teacher;

public class TeacherDto {

	public static List<Teacher> obtenerDTO_list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = "/api/colegio/profesores";

        String url1 = "http://localhost:8082/api/colegio/profesores";
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
            
            		
            String output;

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
                    	JsonObject cJson = (JsonObject) coursesJson.get(i);
                    	Course c = new Course();
                    	c.setName(String.valueOf(cJson.get("name")));
                    	String fIn = String.valueOf(cJson.get("start_date"));
                    	String fFin = String.valueOf(cJson.get("ending_date"));
                    	c.setStart_date(Date.valueOf(fIn.substring(1, fIn.length() - 1)).toLocalDate());
                    	c.setEnding_date(Date.valueOf(fFin.substring(1, fIn.length() - 1)).toLocalDate());
                    	courseList.add(c);                    	
                    }
                    
                    teacher.setCourses(courseList);
                    l.add(teacher);
                    //System.out.println(teacher);
                    //System.out.println(object.get("id"));
                    //System.out.println(object.get("name"));
                    
                }

            }
            System.out.println(l);
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
