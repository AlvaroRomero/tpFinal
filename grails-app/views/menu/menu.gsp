<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<sm:inlinePlayer/>
<resource:carousel />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Insert title here</title>
</head>
<body>
  <div class="body">
  <richui:carousel direction="horizontal" carouselStyle="height: 300px;" itemsStyle="height: 300px;">

    <richui:carouselItem>
        <img src="images/1.jpg" alt="One"/><br/>One
    </richui:carouselItem>

    <richui:carouselItem>
        <img src="images/2.jpg" alt="Two"/><br/>Two
    </richui:carouselItem>

    <richui:carouselItem>
        <img src="images/3.jpg" alt="Three"/><br/>Three
    </richui:carouselItem>

    <richui:carouselItem>
        <img src="images/4.jpg" alt="Four"/><br/>Four
    </richui:carouselItem>

</richui:carousel>
  
  <ul>
 
<sec:ifLoggedIn>
				<li><g:link controller="logout">sign out</g:link></li>
</sec:ifLoggedIn>
				<li><a href="media/1.mp3">Musica para relajarse mientras lees</a></li>
				<sec:ifAllGranted roles="ROLE_ADMIN">
				<li>Soy admin</li>
				<li><g:link controller="Libro" >Libros</g:link></li>
				<li><g:link controller="user" >Usuarios</g:link></li>
				<li><g:link controller="LibroLector" >Mis lecturas</g:link></li>
			    				
				</sec:ifAllGranted>
				
				<sec:ifAllGranted roles="ROLE_USER">
				<li>Soy User</li>
				<li><g:link controller="Libro" >Libros</g:link></li>
				<li><g:link controller="LibroLector" >Mis lecturas</g:link></li>
				
				</sec:ifAllGranted>
  </ul>
  
  </div>
</body>
</html>