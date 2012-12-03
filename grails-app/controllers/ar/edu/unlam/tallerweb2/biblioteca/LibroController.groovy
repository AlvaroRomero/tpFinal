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

@Secured(['IS_AUTHENTICATED_REMEMBERED'])

class LibroController {
	
	def springSecurityService
	def buscaService
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

   	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[libroInstanceList: Libro.list(params), libroInstanceTotal: Libro.count()]
	}
	   
	   

    def create() {
        [libroInstance: new Libro(params)]
    }

    def save() {
        def libroInstance = new Libro(params)
        if (!libroInstance.save(flush: true)) {
            render(view: "create", model: [libroInstance: libroInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'libro.label', default: 'Libro'), libroInstance.id])
        redirect(action: "show", id: libroInstance.id)
    }

    def show(Long id) {
        def libroInstance = Libro.get(id)
        if (!libroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
            return
        }

        [libroInstance: libroInstance]
    }

    def edit(Long id) {
        def libroInstance = Libro.get(id)
        if (!libroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
            return
        }

        [libroInstance: libroInstance]
    }

    def update(Long id, Long version) {
        def libroInstance = Libro.get(id)
        if (!libroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (libroInstance.version > version) {
                libroInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'libro.label', default: 'Libro')] as Object[],
                          "Another user has updated this Libro while you were editing")
                render(view: "edit", model: [libroInstance: libroInstance])
                return
            }
        }

        libroInstance.properties = params

        if (!libroInstance.save(flush: true)) {
            render(view: "edit", model: [libroInstance: libroInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'libro.label', default: 'Libro'), libroInstance.id])
        redirect(action: "show", id: libroInstance.id)
    }

    def delete(Long id) {
        def libroInstance = Libro.get(id)
        if (!libroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
            return
        }

        try {
            libroInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'libro.label', default: 'Libro'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def registroprestamo() {
		def b = Libro.get(params.id)
		b.estado = "No Disponible"
		b.save()

		// redirect to a scaffolded action
		redirect(action: "list")
	}
	
	def registrodevolucion() {
		def b = Libro.get(params.id)
		b.estado = "Disponible"
		b.save()

		// redirect to a scaffolded action
		redirect(action: "list")
	}
	
	def buscaPorTitulo(Integer max) {
		
	params.max = Math.min(max ?: 10, 100)
	buscaService.buscaPorTitulo(params)
	}

	def buscaPorAutor(Integer max) {
			
	params.max = Math.min(max ?: 10, 100)
	buscaService.buscaPorAutor(params)
	}
	
}
