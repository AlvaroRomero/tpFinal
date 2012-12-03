import ar.edu.unlam.tallerweb2.biblioteca.Libro
import ar.edu.unlam.tallerweb2.biblioteca.LibroLector
import ar.edu.unlam.tallerweb2.biblioteca.Role
import ar.edu.unlam.tallerweb2.biblioteca.User
import ar.edu.unlam.tallerweb2.biblioteca.UserRole


class BootStrap {

   def init = { servletContext ->

      def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
      def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
	  
	
	  
	  

      def User = new User(username: 'Seba', enabled: true, password: '1234')
      User.save(flush: true)

      UserRole.create User, adminRole, true
	  
	  User = new User(username: 'Alvaro', enabled: true, password: '1234')
	  User.save(flush: true)

	  UserRole.create User, adminRole, true

	  User = new User(username: 'Diego', enabled: true, password: '1234')
	  User.save(flush: true)

	  UserRole.create User, userRole, true
	  
	  User = new User(username: 'Nico', enabled: true, password: '1234')
	  User.save(flush: true)

	  UserRole.create User, userRole, true
	  
	  User = new User(username: 'pepe', enabled: true, password: 'pepe')
	  User.save(flush: true)

	  UserRole.create User, userRole, true
	  
	  def libro = new Libro(
		  titulo:'El simbolo Perdido',
	      autor:'Dan Brown',
	      estado:'Disponible',
	      genero:'Ficcion')
	      libro.save(flush: true)
		  
		  libro = new Libro(
			  titulo:'La conspiracion',
			  autor:'Dan Brown',
			  estado:'Disponible',
			  genero:'Ficcion')
			  libro.save(flush: true)
			  
		  libro = new Libro(
				  titulo:'Heridas por arma de fuego',
				  autor:'Di Maio',
				  estado:'No disponible',
				  genero:'Manual')
				  libro.save(flush: true)
		  
		  libro = new Libro(
			  titulo:'Sociedades secretas',
			  autor:'Hugo Ariel Macchiavelli',
			  estado:'Disponible',
			  genero:'Manual')
			  libro.save(flush: true)
			  
			  
		  libro = new Libro(
			  titulo:'SDiccionario americano',
			  autor:'Varios',
			  estado:'Disponible',
			  genero:'Diccionario Ingles-Castellano')
			  libro.save(flush: true)
				  
					  
		  libro = new Libro(
			  titulo:'El psicoanalista',
			  autor:'John Katzenbach',
			  estado:'Disponible',
			  genero:'Ficcion')
			  libro.save(flush: true)
						  
		  libro = new Libro(
			  titulo:'Danza de dragones',
			  autor:'R.R.Martin',
			  estado:'Disponible',
			  genero:'Ficcion')
			  libro.save(flush: true)
							  
		  libro = new Libro(
			  titulo:'Orientacion a objetos con Java',
			  autor:'Carlos Fontela',
			  estado:'Disponible',
			  genero:'Tecnico')
			  libro.save(flush: true)
								  
		  libro = new Libro(
			  titulo:'Fundamentos de algoritmos y programacion',
			  autor:'Frank',
			  estado:'Disponible',
			  genero:'Tecnico')
			  libro.save(flush: true)
			  
		  libro = new Libro(
			  titulo:'Ubuntu',
			  autor:'Benchimol',
			  estado:'Disponible',
			  genero:'Tecnico')
			  libro.save(flush: true)
										  
		  libro = new Libro(
			  titulo:'202 Secretos de Linux',
			  autor:'Arena',
			  estado:'Disponible',
			  genero:'Tecnico')
			  libro.save(flush: true)
											  
		  libro = new Libro(
			  titulo:'Administracion de Windows',
			  autor:'Holm',
			  estado:'Disponible',
			  genero:'Tecnico')
			  libro.save(flush: true)
			  
		  libro = new Libro(
			  titulo:'Cocina sin excusas',
			  autor:'Massey',
			  estado:'Disponible',
			  genero:'Cocina')
			  libro.save(flush: true)
			  
			  
		 def librolector = new LibroLector(
				  lector:'Diego',
				  libro:'Cocina sin excusas',
				  fecha: new Date() )				  
				  librolector.save(flush: true)
				  
		  librolector = new LibroLector(
			  lector:'Diego',
			  libro:'Danza de dragones',
			  fecha: new Date() )
			  librolector.save(flush: true)
					  
		  librolector = new LibroLector(
			  lector:'Diego',
			  libro:'Administracion de Windows',
			  fecha: new Date() )
			  librolector.save(flush: true)
						  
		  librolector = new LibroLector(
			  lector:'Seba',
			  libro:'La conspiracion',
			  fecha: new Date() )
			  librolector.save(flush: true)
							  
		  librolector = new LibroLector(
			  lector:'Seba',
			  libro:'Orientacion a objetos con Java',
			  fecha: new Date() )
			  librolector.save(flush: true)
			  
   }
   
   
}