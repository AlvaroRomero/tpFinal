package ar.edu.unlam.tallerweb2.biblioteca

class Role {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
