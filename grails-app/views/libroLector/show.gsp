
<%@ page import="ar.edu.unlam.tallerweb2.biblioteca.LibroLector" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'libroLector.label', default: 'LibroLector')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-libroLector" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				
			</ul>
		</div>
		<div id="show-libroLector" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list libroLector">
			
				<g:if test="${libroLectorInstance?.fecha}">
				<li class="fieldcontain">
					<span id="fecha-label" class="property-label"><g:message code="libroLector.fecha.label" default="Fecha" /></span>
					
						<span class="property-value" aria-labelledby="fecha-label"><g:formatDate date="${libroLectorInstance?.fecha}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${libroLectorInstance?.lector}">
				<li class="fieldcontain">
					<span id="lector-label" class="property-label"><g:message code="libroLector.lector.label" default="Lector" /></span>
					
						<span class="property-value" aria-labelledby="lector-label"><g:fieldValue bean="${libroLectorInstance}" field="lector"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${libroLectorInstance?.libro}">
				<li class="fieldcontain">
					<span id="libro-label" class="property-label"><g:message code="libroLector.libro.label" default="Libro" /></span>
					
						<span class="property-value" aria-labelledby="libro-label"><g:fieldValue bean="${libroLectorInstance}" field="libro"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${libroLectorInstance?.id}" />
					
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
