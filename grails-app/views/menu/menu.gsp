<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  
  <ul>
 
<sec:ifLoggedIn>
				<li><g:link controller="logout">sign out</g:link></li>
</sec:ifLoggedIn>
				
				<sec:ifAllGranted roles="ROLE_ADMIN">
				<li>Soy admin</li>
				<li>ABM Libros</li>
				<li>ABM Usuarios</li>
			    <li>Listado Libros</li>
			    <li>Registrar prestamo</li>
			    <li>Registrar retorno</li>
				
				</sec:ifAllGranted>
				
				<sec:ifAllGranted roles="ROLE_USER">
				<li>Soy User</li>
				<li>Consulta libro</li>
				
				</sec:ifAllGranted>
  </ul>
  
  </div>
</body>
</html>