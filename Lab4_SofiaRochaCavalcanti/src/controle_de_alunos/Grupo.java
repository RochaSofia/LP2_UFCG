package controle_de_alunos;
/**Classe responsavel pelas informações sobre o grupo
 * 
 * @author Sofia Rocha*/

import java.util.HashSet;

public class Grupo {
	private String nomedoGrupo;
	private HashSet<Aluno> integrantes = new HashSet<>();
	
	/**
	 * Constroi um grupo a partir do seu nome 
	 * @param nome O nome do grupo**/
	public Grupo(String nome) {
		if (nomedoGrupo.equals("")) {
			throw new IllegalArgumentException("Entrada inválida");
		}
		this.nomedoGrupo = nome;
		
	}
	/**
	 * Adiciona um integrante ao grupo
	 * @param integrantes O aluno que irá ser alocado para esse grupo*/
	public void adicionaIntegrante(Aluno integrantes) {
		this.integrantes.add(integrantes);
	}
	/**
	 * Imprime os integrantes dos grupos
	 * @return saida A lista de integrantes e suas informações no formato :
	 * posiçao. matricula - nome - curso*/
	
	
	public String imprimeGrupo() {
		String saida= "";
		
		for (Aluno integrante: this.integrantes) {
			saida += integrante.imprimeGrupo();
		}
		return saida;
	}
	
	/**
	 * Informações sobre o nome e integrantes do grupo em forma de String*/
	@Override
	public String toString() {
		return "Grupo [nomedoGrupo=" + nomedoGrupo + ", integrantes=" + integrantes + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((integrantes == null) ? 0 : integrantes.hashCode());
		result = prime * result + ((nomedoGrupo == null) ? 0 : nomedoGrupo.hashCode());
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
		Grupo other = (Grupo) obj;
		if (integrantes == null) {
			if (other.integrantes != null)
				return false;
		} else if (!integrantes.equals(other.integrantes))
			return false;
		if (nomedoGrupo == null) {
			if (other.nomedoGrupo != null)
				return false;
		} else if (!nomedoGrupo.equals(other.nomedoGrupo))
			return false;
		return true;
	}
	
	
	
	
}
