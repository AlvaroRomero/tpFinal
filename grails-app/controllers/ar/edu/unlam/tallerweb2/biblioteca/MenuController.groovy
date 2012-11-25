package ar.edu.unlam.tallerweb2.biblioteca

import grails.plugins.springsecurity.Secured

class MenuController {
	
	@Secured(['IS_AUTHENTICATED_REMEMBERED'])
	
	def index = {
	   render (view:"Menu")
	   
	}
	   
 }