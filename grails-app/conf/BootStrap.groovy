import ar.edu.unlam.tallerweb2.biblioteca.Role
import ar.edu.unlam.tallerweb2.biblioteca.User
import ar.edu.unlam.tallerweb2.biblioteca.UserRole


class BootStrap {

   def init = { servletContext ->

      def adminRole = new Role(authority: 'ADMIN').save(flush: true)
      def userRole = new Role(authority: 'USER').save(flush: true)

      def User = new User(username: 'Seba', enabled: true, password: '1234')
      testUser.save(flush: true)

      UserRole.create testUser, adminRole, true
	  
	  User = new User(username: 'Alvaro', enabled: true, password: '1234')
	  testUser.save(flush: true)

	  UserRole.create testUser, adminRole, true

     
   }
}