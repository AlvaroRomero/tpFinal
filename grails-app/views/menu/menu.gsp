<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<sm:inlinePlayer/>
<resource:carousel />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Biblos Menu</title>
</head>
<body>
  <div class="body">
  <div class="miMenu">
  
  <div id="miMusica"><a href="media/1.mp3">Musica para relajarse mientras lees</a></div>
  
  <richui:carousel direction="horizontal" carouselStyle="height: 300px;" itemsStyle="height: 300px;">

    <richui:carouselItem>
        <img src="images/libros/libro1.png" alt="Uno"/><br/><g:link controller="libro" action="show" id="14">Deadly Hallows</g:link>
    </richui:carouselItem>

    <richui:carouselItem>
        <img src="images/libros/libro2.png" alt="Two"/><br/><g:link controller="libro" action="show" id="20">Viscount Breckenridge</g:link>
    </richui:carouselItem>

    <richui:carouselItem>
        <img src="images/libros/libro3.png" alt="Three"/><br/><g:link controller="libro" action="show" id="19">Best of me</g:link>
    </richui:carouselItem>

    <richui:carouselItem>
        <img src="images/libros/libro4.png" alt="Four"/><br/><g:link controller="libro" action="show" id="18">Before I go to Sleep</g:link>
    </richui:carouselItem>
    
    <richui:carouselItem>
        <img src="images/libros/libro5.png" alt="Four"/><br/><g:link controller="libro" action="show" id="17">Sarah Key</g:link>
    </richui:carouselItem>
    
    <richui:carouselItem>
        <img src="images/libros/libro6.png" alt="Four"/><br/><g:link controller="libro" action="show" id="16">Things Fall Apart</g:link>
    </richui:carouselItem>
    
    <richui:carouselItem>
        <img src="images/libros/libro7.png" alt="Four"/><br/><g:link controller="libro" action="show" id="15">Bossy Pants</g:link>
    </richui:carouselItem>

</richui:carousel>
<div class='ddsmoothmenu' id='smoothmenu1'>

				
				
				<ul>			
				
				<sec:ifLoggedIn>
				<li><g:link controller="logout">Cerrar Sesion</g:link></li>
				</sec:ifLoggedIn>
				
				<sec:ifAllGranted roles="ROLE_ADMIN">
				<li>Administrador</li>
				<br/><br/><br/><br/>
				<li><g:link controller="Libro" >Libros</g:link></li>
				<li><g:link controller="user" >Usuarios</g:link></li>
				<li><g:link controller="LibroLector" >Mis lecturas</g:link></li>
				</sec:ifAllGranted>
				
				<sec:ifAllGranted roles="ROLE_USER">
				<li>Usuario</li>
				<br/><br/><br/><br/>
				<li><g:link controller="Libro" >Libros</g:link></li>
				<li><g:link controller="LibroLector" >Mis lecturas</g:link></li>				
				</sec:ifAllGranted>
				
				
				
				</ul>
				</div>	
 
  </div>
  </div>
</body>
</html>