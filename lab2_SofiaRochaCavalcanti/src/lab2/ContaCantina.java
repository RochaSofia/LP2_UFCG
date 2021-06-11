/** Representação do Lab-Extra-02 , da aluna Sofia Rocha Cavalcanti (matricula 119210421), 
 * da disciplina de Programação 2 da Universidade Federal de Campina Grande -UFCG.
 * @author Sofia Rocha
 * */
package lab2;

public class ContaCantina {
	private String nomedaCantina;
	private int debito;
	private int quantidadeItens;
	private int valorLanches;
	
	
	/***
	 * Constroi uma conta na cantina a partir do nome da cantina ,onde nomedaCantina recebe o paremetro referente ao nome da cantina (nomedaCantina)
	 * e os demais atributos começam zerados
	 * @param nomedaCantina o nome da lanchonete/cantina onde se esta fazendo uma conta
	 */
	public ContaCantina(String nomedaCantina) {
		this.nomedaCantina = nomedaCantina;
		this.debito=0;
		this.quantidadeItens=0;
		this.valorLanches =0;
	}
	/**
	 *Cadastra a quantidade de itens que foi comprado e o valor em centavos gasto como inteiros, 
	 *somando ou não a um debito já existente naquela cantina/lanchonete
	 *@param quantidadedeItens quantidade de itens comprado
	 *@param valorCentavos o valor em cantavos gasto na compra dos itens */
	
	public void cadastraLanche(int quantidadeItens , int valorCentavos) {
		this.quantidadeItens += quantidadeItens;
		debito += valorCentavos;
		valorLanches += valorCentavos;
}
	/**
	 * Subtrai o valor que quer pagar do débito que existe na cantina/lanchonete
	 * @param valorCentavos um valor inteiro que quer pagar em centavos */
	public void pagaConta(int valorCentavos){
		if (valorCentavos <= debito) {
			debito -= valorCentavos;
		}
		
	}
	/**
	 *Retorna o valor ainda em débito na cantina/lanchonete 
	 *@return debito a quantia que falta pagar em inteiro*/
	
	public int getFaltaPagar() {
		return debito;
		
	}
	/**
	 * Retorna em string o nome da cantina , a quantidade de itens e o valor cadastrados ate o momento , 
	 * no formato nomedaCantina quantidadedeItens valorLanches
	 * @return  a representação em string do nome da cantina , a quantidade de itens e os valores cadastrados ate o momento*/
	
	@Override
	public String toString() {
		return  nomedaCantina + " " + quantidadeItens
				+  " " + valorLanches ;
	}
	
	

}


