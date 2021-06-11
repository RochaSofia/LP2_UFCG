package agenda;

import java.util.Arrays;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 * @author Sofia Rocha 
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;
	
	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos;
	}

	/**
	 * Acessa os dados de um contato específico.O usuario entra com posições de 1 a 100 , e na memoria é guardado a partir de 0 
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return this.contatos[posicao-1];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefones Um array de 3 telefones que poderam ser cadastrados.
	 * @param telefonesPrioritarios Identificar qual dos telefones é o prioritario , podendo ser 1,2,3 ou nenhum
	 * @param whatszapp Identifica qual dos telefones é o whatszapp , podendo ser nenhum também
	 * 	 */
	public void cadastraContato(int posicao,String nome,String sobrenome,String[] telefones,String telefonesPrioritarios , String whatszapp) {
		Contato contato = new Contato( nome ,sobrenome,telefones , telefonesPrioritarios , whatszapp );
		this.contatos[posicao-1] = contato;
	}
	/***
	 * Retorna em forma de String os contatos e os dados desses contatos 
	 * @return   Os dados dos contatos que estão na agenda 
	 */
	@Override
	public String toString() {
		return "Agenda [contatos=" + Arrays.toString(contatos) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
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
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}
	
	

}
