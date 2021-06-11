package agenda;

import java.util.Arrays;
/**
 * Uma classe que representa os dados de um contato na agenda 
 * 
 * @author nazareno
 * @author Sofia Rocha 
 *
 */

public class Contato {

	private String nome;
	private String sobrenome;
	private String[] telefones;
	private String telefonesPrioritarios;
	private String whatszapp;
	private int telPrioritario;
	private int contatosWhatszapp;
	private String nomeCompleto;
	
	/**
	 * Cria um contato a partir de seu nome , sobrenome , um array de 3 telefones, um telefone prioritario e um telefone referente ao whatszapp
	 * @param nome O medo do contato
	 * @param sobrenome O sobrenome do contato
	 * @param telefones[] Um array que contém três numeros de telefone
	 * @param telefonesPrioritarios A identificação em qual dos telefones cadastrados é o prioritario
	 * @param whatszapp A identificação em qual dos telefones cadastrados é o whatszapp*/
	
	
	


		public Contato(String nome, String sobrenome, String[] telefones, String telefonesPrioritarios, String whatszapp) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefones = telefones;
		this.telPrioritario = Integer.parseInt(telefonesPrioritarios);
		this.contatosWhatszapp = Integer.parseInt(whatszapp);
	}

	/**
	 * Verifica se há e em qual posição esta o telefone prioritario 
	 * @return telefonesPrioritarios retorna a posição desse telefone prioritario ou se este não existe*/


		public String getTelefonesPrioritarios() {
			
			if (telPrioritario == -1) {
				this.telefonesPrioritarios = "Não tem";
			}else {
				this.telefonesPrioritarios = this.telefones[telPrioritario -1 ];
			}
			return this.telefonesPrioritarios;
			}
		
		/**
		 * Verifica se há e em qual posição esta o whatszapp
		 * @return whatszapp retorna a posição do whatszapp ou se este não existe*/


		public String getWhatszapp() {
			
			if (contatosWhatszapp == -1) {
				this.whatszapp = "Não tem ";
			}else {
				this.whatszapp = this.telefones[contatosWhatszapp -1];
			}
			return this.whatszapp;
		}
			
		/**
		 * Comcatena o nome e sobrenome referente ao contato
		 * @return    nome e sobrenome referente ao contato*/


		public String getNomeCompleto() {
			return  this.nome + " " + this.sobrenome;
		}
		/**
		 * Retorna a String referente aos dados do contato
		 * @return    Uma concatenação do nome completo, qual é o telefone prioritario e whatszapp*/
		
		@Override
		public String toString() {
			return getNomeCompleto()+ "\n"
					+ this.getTelefonesPrioritarios() + " (prioritarios)\n" + this.getWhatszapp()+" (whatszapp)";
		}




		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + contatosWhatszapp;
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			result = prime * result + ((nomeCompleto == null) ? 0 : nomeCompleto.hashCode());
			result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
			result = prime * result + telPrioritario;
			result = prime * result + Arrays.hashCode(telefones);
			result = prime * result + ((telefonesPrioritarios == null) ? 0 : telefonesPrioritarios.hashCode());
			result = prime * result + ((whatszapp == null) ? 0 : whatszapp.hashCode());
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
			Contato other = (Contato) obj;
			if (contatosWhatszapp != other.contatosWhatszapp)
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (nomeCompleto == null) {
				if (other.nomeCompleto != null)
					return false;
			} else if (!nomeCompleto.equals(other.nomeCompleto))
				return false;
			if (sobrenome == null) {
				if (other.sobrenome != null)
					return false;
			} else if (!sobrenome.equals(other.sobrenome))
				return false;
			if (telPrioritario != other.telPrioritario)
				return false;
			if (!Arrays.equals(telefones, other.telefones))
				return false;
			if (telefonesPrioritarios == null) {
				if (other.telefonesPrioritarios != null)
					return false;
			} else if (!telefonesPrioritarios.equals(other.telefonesPrioritarios))
				return false;
			if (whatszapp == null) {
				if (other.whatszapp != null)
					return false;
			} else if (!whatszapp.equals(other.whatszapp))
				return false;
			return true;
		}




	


	
	

	
	
	
}
