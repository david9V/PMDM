package com.hg.microservices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

	@RequestMapping (value="/saludo")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse respone)
	throws ServletException, IOException{
		
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		/*
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Tutorías</title></head>");
		out.println("<body>hola</body></html>");
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/vistas/index.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}
	
}
