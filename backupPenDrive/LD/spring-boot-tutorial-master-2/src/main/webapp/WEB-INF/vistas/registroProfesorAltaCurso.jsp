<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,com.hg.microservices.models.*, java.util.*, java.io.*" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Dar alta profesores modificado</title>
</head>
<body>
<h1>FORM desde JSP</h1>
<form th:object="${profesor}" action="/api/colegio/profesor" method="post">
        Grado: <input th:field="*{degree}" type="text" name="degree"><br>
        Salario: <input th:field="*{salary}" type="text" name="salary"><br>
        ID: <input th:field="*{id}" type="text" name="id"><br>
        Nombre: <input th:field="*{name}" type="text" name="name"><br>
        Género:<input th:field="*{gender}" type="text" name="gender"><br>
        Email:<input th:field="*{email}" type="text" name="email"><br>
        Cursos:<br> <input type="checkbox" value="LD"> Libre distribución<br>
        <input type="checkbox" name="curso" value="DIU" checked> Diseño de interfaces de usuario<br>
        <input type="checkbox" name="curso" value="AD"> Acceso a datos<br>
        <input type="checkbox" name="curso" value="EIE"> Empresa e iniciativa emprendedora<br>
        <input type="checkbox" name="curso" value="SGE"> Sistema de gestión empresarial<br>
        <input type="checkbox" name="curso" value="PMDM"> Programación multimedia y dispositivos móviles<br>
        <input type="submit" value="Confirmar">
        
        
        
         <button type="button" onclick="prueba()">prueba</button> 
        
        
</form>
</body>
</html>