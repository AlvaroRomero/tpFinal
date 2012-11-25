
<%@ page import="ar.edu.unlam.tallerweb2.biblioteca.Libro" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'libro.label', default: 'Libro')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-libro" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-libro" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list libro">
			
				<g:if test="${libroInstance?.titulo}">
				<li class="fieldcontain">
					<span id="titulo-label" class="property-label"><g:message code="libro.titulo.label" default="Titulo" /></span>
					
						<span class="property-value" aria-labelledby="titulo-label"><g:fieldValue bean="${libroInstance}" field="titulo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${libroInstance?.autor}">
				<li class="fieldcontain">
					<span id="autor-label" class="property-label"><g:message code="libro.autor.label" default="Autor" /></span>
					
						<span class="property-value" aria-labelledby="autor-label"><g:fieldValue bean="${libroInstance}" field="autor"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${libroInstance?.estado}">
				<li class="fieldcontain">
					<span id="estado-label" class="property-label"><g:message code="libro.estado.label" default="Estado" /></span>
					
						<span class="property-value" aria-labelledby="estado-label"><g:fieldValue bean="${libroInstance}" field="estado"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${libroInstance?.genero}">
				<li class="fieldcontain">
					<span id="genero-label" class="property-label"><g:message code="libro.genero.label" default="Genero" /></span>
					
						<span class="property-value" aria-labelledby="genero-label"><g:fieldValue bean="${libroInstance}" field="genero"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${libroInstance?.prestadoa}">
				<li class="fieldcontain">
					<span id="prestadoa-label" class="property-label"><g:message code="libro.prestadoa.label" default="Prestadoa" /></span>
					
						<span class="property-value" aria-labelledby="prestadoa-label"><g:fieldValue bean="${libroInstance}" field="prestadoa"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${libroInstance?.id}" />
					<g:link class="edit" action="edit" id="${libroInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
