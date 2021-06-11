package controle_de_alunos;
/**
 * @author Sofia Rocha 
 * Classe responsavel pelas caracteristicas do objeto Aluno*/
	public class Aluno {
		private String matricula;
		private String nome;
		private String curso;
	
	/**
	 * Constroi um aluno a partir de sua matricula ,nome e curso
	 * @param matricula A matricula do aluno 
	 * @param nome O nome do aluno
	 * @param curso O curso do aluno*/
		
	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Entrada inválida");
		}
		if (matricula.equals("") || nome.equals("") || curso.equals("")) {
			throw new IllegalArgumentException("Entrada inválida");
		}
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	/**
	 * Imprime o aluno no formato : Aluno: matricula - nome - curso
	 * @return Returno informações do aluno em string */
	
	public String exibirAluno() {
		return "Aluno: " + this.matricula + " - "+ this.nome+ " - " + this.curso;

	}
	/**
	 * Imprime os integrantes do grupo de estudos, no formato : * matricula - nome - curso
	 * @return Retorna uma lista de integrantes do grupo*/
	public String imprimeGrupo() {
		return "* " + this.matricula + " - " + this.nome + " - " + this.curso + "\n";
	}
	/**
	 * Retorna em String informações so aluno como matricula , curso e nome
	 * @return Informações do aluno , formato : Matricula - nome - curso*/

	@Override
	public String toString() {
		return this.matricula + " - "+ this.nome+ " - " + this.curso +"\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	  
}
