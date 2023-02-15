package com.hg.microservices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hg.microservices.models.Course;

@Controller
public class Controlador3 {
	
	@GetMapping("/darAltaProfesor2")
	protected void doGet2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri2 = "/WEB-INF/vistas/registroProfesorAltaCurso.jsp";
        response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri2);
		request.setAttribute("curso", new Course());
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
