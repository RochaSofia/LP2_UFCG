/** Representação do Lab-Extra-02 , da aluna Sofia Rocha Cavalcanti (matricula 119210421), 
 * da disciplina de Programação 2 da Universidade Federal de Campina Grande -UFCG.
 * @author Sofia Rocha
 * */

package lab2;

public class ContaLaboratorio {
	private String nomedoLaboratorio;
	private int cota;
	private int armazenamento;
	
	
	
	/**
	 * Constroi um laborario , a partir do nome do laboratorio , 
	 * onde tem como cota (limite de armazenamento ) inicializado por padrão de 2000 mb e armazenamento (o quanto esta sendo utilizado da memoria)
	 *  inicializado com 0
	 * @param nomedoLaboratorio nome do laboratorio em string */
	public ContaLaboratorio(String nomedoLaboratorio) {
		this.nomedoLaboratorio = nomedoLaboratorio;
		this.cota = 2000;//esta em mb
		this.armazenamento =0;
	
	}

	/**
	 *Constrói um laboratorio , a partir do nome do laboratorio e o limite de espaço disponível na memoria 
	 *@param nomedoLaboratorio nome do laboratorio em string
	 *@param cota o limite de espaço na memoria em um número inteiro*/

	public ContaLaboratorio(String nomedoLaboratorio, int cota) {
		
		this.nomedoLaboratorio = nomedoLaboratorio;
		this.cota = cota;
		
	}
	/**
	 * Soma a quantidade de espaço consumida no armazenamento
	 * @param mbytes quantidade inteira de espaço consumido em mb
	 * @return armazenamento um inteiro que representa a quantidade de espaço consumida*/
	public int consomeEspaco(int mbytes) {
	
		armazenamento = armazenamento+ mbytes;
		
		return armazenamento;
		
		
	}
	/**
	 * Subtrai a quantidade de espaço consumida no armazenamento, dessa forma liberando espaço
	 * @param mbytes quantidade interia de espaço liberado em mb
	 * @return armazenamento um inteiro que representa a quantidade de espaço consumida*/
	
	public int liberaEspaco(int mbytes) {
		armazenamento = armazenamento-mbytes;
		
		return armazenamento;
		
	}
	/**
	 * Verifica se a quantidade de utilizada (armazenamento) chegou ao limite de memoria (cota)*
	 * @return atingiuCota atingiu ou não a quantidade disponivel da memoria em boolean
	 */
	public boolean atingiuCota() {
		boolean	atingiuCota = false;
		
		if (armazenamento  >= cota ) {
			return atingiuCota=true;
			
		}else {
			return atingiuCota;
		}
	}

	/**
	 *Retorna a string que representa o nome do laboratorio , o quanto foi utilizado e o quanto tinha disponivel, 
	 *no formato " nomedoLaboratorio armazenamento/cota "
	 *@return a representação em string do nome do laboratorio , o quanto foi utilizado e o quanto tinha disponivel 
	 */
	 
	
	@Override
	public String toString() {
		return  nomedoLaboratorio + " "+  armazenamento+ "/" + cota;
	}
}
