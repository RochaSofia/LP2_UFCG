/** Representação do Lab-Extra-02 , da aluna Sofia Rocha Cavalcanti (matricula 119210421), 
 * da disciplina de Programação 2 da Universidade Federal de Campina Grande -UFCG.
 * @author Sofia Rocha
 * */
package lab2;


	public class Saude {
		private String valorMental="";
		private String valorFisica = "";
		private String resultado;
	/**
	 * Constroi uma saúde , onde tem valor incial como boa, e os demais atributos como vazios */
			
		public Saude() {
			
			this.valorMental = " ";
			this.valorFisica = " ";
			this.resultado = "boa";
		}
		/**
		 * Recebe o estado da saude mental em string
		 * @param valorMental o estado da saude mental(boa ou fraca) em string*/

		public void defineSaudeMental(String valorMental) {
			this.valorMental = valorMental;
			
		}
		/**
		 * Recebe o estadi da saúde fisica em string
		 * @param valorFisica o estado da saude fisica(boa ou fraca) em string*/
		
		public void defineSaudeFisica(String valorFisica) {
			this.valorFisica = valorFisica;
		
		}
		/**
		 * Compara os valores de saúde mental e saúde fisica
		 * Quando a saúde fisica e mental estão boas ,então o status geral é boa;
		 * quando a saúde fisica esta boa e mental fraca , ou vice-versa , o status geral é ok;
		 * quando a saúde fisica e mental estão fracas , o status geral é fraco.
		 * @return resultado o resultado em string da comparação dos estados da saúde mental e fisica 
		 * */
		public String getStatusGeral() {
			
			if ( valorFisica.equals("boa") && valorMental.equals("boa")) {
				resultado = "boa";
			}
			if (valorFisica.equals("boa") && valorMental.equals("fraca") || valorFisica.equals("fraca") && valorMental.equals("boa") ){
				resultado = "ok";
				}
			if (valorFisica.equals("fraca") && valorMental.equals("fraca")) {
				resultado = "fraca";
			}
			return resultado;
			
		}

	}
