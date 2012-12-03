package ar.edu.unlam.tallerweb2.biblioteca
import ar.edu.unlam.tallerweb2.biblioteca.LibroLector
import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured

import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.core.context.SecurityContextHolder as SCH
import org.springframework.security.web.WebAttributes
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class RegistraLecturaService {
	static transactional = false
	def springSecurityService

    def registroLectura(params) {
		
		def usuario = springSecurityService.getPrincipal().getUsername()
		def b = new LibroLector()
		b.lector = usuario
		b.libro = params.id
		b.fecha=new Date()
		b.save()
		
		
    }
}
