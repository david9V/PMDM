<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,com.hg.microservices.models.Teacher, java.util.Iterator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<title>Listado de profesores</title>
	</head>
	
	<body>
	<%
	List<Teacher> lista = (List<Teacher>) request.getAttribute("lp");
	Iterator it = lista.iterator();	
	
	out.println("<h1> Profesores </h1>");
	int i = 1;
	
	while (it.hasNext()){
		Teacher t = (Teacher) it.next();
		out.println("<h2> Profesor " + i + " :  </h2>");
		out.println("<b> Nombre: </b>" + t.getName().substring(1, t.getName().length() - 1));
		out.println("<b> Salario: </b>" + t.getSalary() + "€");
		out.println("<b> Cursos impartidos: </b>");
		out.println(t.getCourses());
		out.println("<br>");
		i++;

	}
	%>


	</body>

</html>


