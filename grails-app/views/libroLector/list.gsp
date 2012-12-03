
<%@ page import="ar.edu.unlam.tallerweb2.biblioteca.LibroLector" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'libroLector.label', default: 'LibroLector')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-libroLector" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				
			</ul>
		</div>
		<div id="list-libroLector" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="fecha" title="${message(code: 'libroLector.fecha.label', default: 'Fecha')}" />
					
						
					
						<g:sortableColumn property="libro" title="${message(code: 'libroLector.libro.label', default: 'Libro')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${libroLectorInstanceList}" status="i" var="libroLectorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${libroLectorInstance.id}">${fieldValue(bean: libroLectorInstance, field: "fecha")}</g:link></td>
					
						
					
						<td>${fieldValue(bean: libroLectorInstance, field: "libro")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${libroLectorInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
