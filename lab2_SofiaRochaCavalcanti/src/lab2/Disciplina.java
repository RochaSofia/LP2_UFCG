/** Representação do Lab-Extra-02 , da aluna Sofia Rocha Cavalcanti (matricula 119210421), 
 * da disciplina de Programação 2 da Universidade Federal de Campina Grande -UFCG.
 * @author Sofia Rocha
 * */
package lab2;

import java.util.ArrayList;

public class Disciplina {
	private String nomedaDisciplina;
	private int horasdeEstudo;
	private double media;
	private ArrayList<Double>notas;
/**
 * Constroi uma disciplina a partir do nome da disciplina , onde os demais itens se inicializam zerados
 * @param nomedaDisciplina o nome da disciplina que irá estudar em string
 * */
	
	public Disciplina(String nomedaDisciplina) {
		
		this.nomedaDisciplina = nomedaDisciplina;
		this.horasdeEstudo=0;
		this.media = 0;
		this.notas = new ArrayList<Double>();
	}
	/**
	 * Aculmula as horas estudadas naquelaa disciplina 
	 * @param horasdeEstudo recebe as horas que iram ser gastas naquela disciplina a partir de um número inteiro
	 * @return horasdeEstudo retorna em um numero inteiro , o culmulativo das horas estudadas naquela disciplina */
	
	public int cadastraHoras(int horasdeEstudo) {
		this.horasdeEstudo += horasdeEstudo;
		return horasdeEstudo;
		
	}
	/**
	 *Indica qual nota esta querendo cadastrar e o valor dessa nota
	 *@param indiceNota qual das notas esta querendo cadastrar ,1°,2°,etc, no formato de um numero inteiro
	 *@param valorNota valor da nota em um número double */
	public void cadastraNota(int indiceNota, double valorNota) {
		notas.add((indiceNota-1), valorNota);
	}
	/**
	 * Calcula o valor da media e verifica se esta aprovado ou não
	 * @return se esta aprovado ou não através de um boolean*/
	
	public boolean aprovado() {
		media=0;
		for (int i = 0; i < notas.size(); i++) {
			media += notas.get(i); 
			
		}
			media = media/notas.size();
		if (media >= 7.0) {
			return true;
		}
			return false;
	}
	/**
	 * Retorna a string que representa a disciplina , as horas de estudo , a media e as notas cadastradas.
	 * No formato "nomedaDisciplina horasdeEstudo media [notas]"
	 * @return a representação em string do nome da disciplina , horas de estudo , a media e as notas cadastradas*/
	@Override
	public String toString() {
		return  nomedaDisciplina+ " "  + horasdeEstudo + " "
				+ media + " " + notas;
	}
	

}
