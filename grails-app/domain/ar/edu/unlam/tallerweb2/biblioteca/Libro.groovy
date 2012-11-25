package ar.edu.unlam.tallerweb2.biblioteca

class Libro {
	
	
	String titulo
	String autor
	String estado
	String genero
	String prestadoa

    static constraints = {
		
		titulo blank: false
		autor blank: false
		estado blank: false
		genero blank: false
		prestadoa blank: true
    }
}
