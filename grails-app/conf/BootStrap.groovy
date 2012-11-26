import ar.edu.unlam.tallerweb2.biblioteca.Libro
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

	  UserRole.create User, userRole, true

	  def libro = new Libro(
		  titulo:'El simbolo Perdido',
	      autor:'Dan Brown',
	      estado:'Disponible',
	      genero:'Ficcion',
		  prestadoa:'')
	      libro.save(flush: true)
		  
		  libro = new Libro(
			  titulo:'La conspiracion',
			  autor:'Dan Brown',
			  estado:'Disponible',
			  genero:'Ficcion',
			  prestadoa:'')
			  libro.save(flush: true)
			  
		  libro = new Libro(
				  titulo:'Heridas por arma de fuego',
				  autor:'Di Maio',
				  estado:'No disponible',
				  genero:'Manual',
				  prestadoa:'Seba')
				  libro.save(flush: true)
		  
   }
   
   
}