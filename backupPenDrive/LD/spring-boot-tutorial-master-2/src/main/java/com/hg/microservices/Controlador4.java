package com.hg.microservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hg.microservices.models.Course;
import com.hg.microservices.models.Teacher;
import com.hg.microservices.models.dto.TeacherDto;

@Controller
public class Controlador4 {

    @GetMapping(value = "/listadoJSPTeacher")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri2 = "/WEB-INF/vistas/index.jsp";
        List<Teacher> l = TeacherDto.obtenerDTO_list(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("lp", l);
        RequestDispatcher dispatcher = request.getRequestDispatcher(uri2);
        if (dispatcher != null){
        	dispatcher.forward(request, response);
        }
        
    }

}