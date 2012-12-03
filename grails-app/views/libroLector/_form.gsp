<%@ page import="ar.edu.unlam.tallerweb2.biblioteca.LibroLector" %>



<div class="fieldcontain ${hasErrors(bean: libroLectorInstance, field: 'fecha', 'error')} required">
	<label for="fecha">
		<g:message code="libroLector.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fecha" precision="day"  value="${libroLectorInstance?.fecha}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: libroLectorInstance, field: 'lector', 'error')} ">
	<label for="lector">
		<g:message code="libroLector.lector.label" default="Lector" />
		
	</label>
	<g:textField name="lector" value="${libroLectorInstance?.lector}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: libroLectorInstance, field: 'libro', 'error')} ">
	<label for="libro">
		<g:message code="libroLector.libro.label" default="Libro" />
		
	</label>
	<g:textField name="libro" value="${libroLectorInstance?.libro}"/>
</div>

