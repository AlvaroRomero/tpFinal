package ar.edu.unlam.tallerweb2.biblioteca

class Libro {
	
	
	String titulo
	String autor
	String estado
	String genero
	

    static constraints = {
		
		titulo blank: false
		autor blank: false
		estado blank: false
		genero blank: false
		
    }
}
