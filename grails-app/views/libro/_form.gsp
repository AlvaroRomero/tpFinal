<%@ page import="ar.edu.unlam.tallerweb2.biblioteca.Libro" %>



<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'titulo', 'error')} required">
	<label for="titulo">
		<g:message code="libro.titulo.label" default="Titulo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titulo" required="" value="${libroInstance?.titulo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'autor', 'error')} required">
	<label for="autor">
		<g:message code="libro.autor.label" default="Autor" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="autor" required="" value="${libroInstance?.autor}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'estado', 'error')} required">
	<label for="estado">
		<g:message code="libro.estado.label" default="Estado" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="estado" required="" value="${libroInstance?.estado}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'genero', 'error')} required">
	<label for="genero">
		<g:message code="libro.genero.label" default="Genero" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="genero" required="" value="${libroInstance?.genero}"/>
</div>



