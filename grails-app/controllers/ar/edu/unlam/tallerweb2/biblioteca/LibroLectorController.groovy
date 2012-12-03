package ar.edu.unlam.tallerweb2.biblioteca

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured

import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException
import org.springframework.security.core.context.SecurityContextHolder as SCH
import org.springframework.security.web.WebAttributes
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter



class LibroLectorController {

	def springSecurityService
	def registraLecturaService
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
		def usuario = springSecurityService.getPrincipal().getUsername()
        [libroLectorInstanceList: LibroLector.findAllByLector(usuario), libroLectorInstanceTotal: LibroLector.count()]
    }

    def create() {
        [libroLectorInstance: new LibroLector(params)]
    }

    def save() {
        def libroLectorInstance = new LibroLector(params)
        if (!libroLectorInstance.save(flush: true)) {
            render(view: "create", model: [libroLectorInstance: libroLectorInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'libroLector.label', default: 'LibroLector'), libroLectorInstance.id])
        redirect(action: "show", id: libroLectorInstance.id)
    }

    def show(Long id) {
        def libroLectorInstance = LibroLector.get(id)
        if (!libroLectorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libroLector.label', default: 'LibroLector'), id])
            redirect(action: "list")
            return
        }

        [libroLectorInstance: libroLectorInstance]
    }

    def edit(Long id) {
        def libroLectorInstance = LibroLector.get(id)
        if (!libroLectorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libroLector.label', default: 'LibroLector'), id])
            redirect(action: "list")
            return
        }

        [libroLectorInstance: libroLectorInstance]
    }

    def update(Long id, Long version) {
        def libroLectorInstance = LibroLector.get(id)
        if (!libroLectorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libroLector.label', default: 'LibroLector'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (libroLectorInstance.version > version) {
                libroLectorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'libroLector.label', default: 'LibroLector')] as Object[],
                          "Another user has updated this LibroLector while you were editing")
                render(view: "edit", model: [libroLectorInstance: libroLectorInstance])
                return
            }
        }

        libroLectorInstance.properties = params

        if (!libroLectorInstance.save(flush: true)) {
            render(view: "edit", model: [libroLectorInstance: libroLectorInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'libroLector.label', default: 'LibroLector'), libroLectorInstance.id])
        redirect(action: "show", id: libroLectorInstance.id)
    }

    def delete(Long id) {
        def libroLectorInstance = LibroLector.get(id)
        if (!libroLectorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libroLector.label', default: 'LibroLector'), id])
            redirect(action: "list")
            return
        }

        try {
            libroLectorInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'libroLector.label', default: 'LibroLector'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'libroLector.label', default: 'LibroLector'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def registrolectura() {
				
		def usuario = springSecurityService.getPrincipal().getUsername()
		if (LibroLector.findAllByLectorAndLibro(usuario,params.id))
		{flash.message = "Ya esta en tu lista"
			redirect(action: "list")
		}
		else{
		registraLecturaService.registroLectura(params)
		redirect(action: "list")
		}
				
		}
}
