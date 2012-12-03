package ar.edu.unlam.tallerweb2.biblioteca

class BuscaService {
	static transactional = false
	
    def buscaPorTitulo(params) {
		def a=params.a
		[libroInstanceList: Libro.findAllByTituloIlike(a), libroInstanceTotal: 1]

		
				}
	
	def buscaPorAutor(params) {
		def a=params.a
		[libroInstanceList: Libro.findAllByAutorIlike(a), libroInstanceTotal: 1]

		
				}
	
	
	
	
}
