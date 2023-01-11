package com.hg.microservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

            String output;
            // tratar la lista de objetos JSON
            while ((output = br.readLine()) != null) {
                System.out.println(output.toString());
                JsonParser parser = new JsonParser();
                Object obj = parser.parse(output);
                JsonArray json = (JsonArray) obj;
                for (int i = 0; i < json.size(); i++) {

                    JsonObject object = (JsonObject) json.get(i);

                    // hay que parsear uno a uno los atributos del objeto Teacher y añadirlo a una
                    // lista
                    System.out.println(object.get("id"));

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