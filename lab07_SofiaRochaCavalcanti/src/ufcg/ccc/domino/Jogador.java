package ufcg.ccc.domino;

import java.util.LinkedList;
import java.util.List;

import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.VisaoDaMesa;

/**
 * Encapsula as informa��es de um jogador em uma partida de domin�.
 *
 */
public class Jogador {

	private EstrategiaDeJogo estrategia;
	private List<Peca> mao;
	private String nome;
	private Jogada ultimaJogada;
	private Peca ultimaPeca;
	private int vitorias;
	private int cruzada;
	private int carroca;
	private int laelo;
	private int batidaUnica;
	
	
	
	public int getCruzada() {
		return cruzada;
	}

	public int getCarroca() {
		return carroca;
	}

	public int getLaelo() {
		return laelo;
	}

	public int getBatidaUnica() {
		return batidaUnica;
	}

	public void setCruzada() {
		this.cruzada ++;
	}

	public void setCarroca() {
		this.carroca++;
	}

	public void setLaelo() {
		this.laelo++;
	}

	public void setBatidaUnica() {
		this.batidaUnica++;
	}
	
	
	/**
	 * Cria um jogador
	 * 
	 * @param nome       Id do jogador
	 * @param estrategia A estratégia para decidir a próxima jogada
	 * @param maoJogador A mão inicial do jogador, com suas peças
	 */
	public Jogador(String nome, EstrategiaDeJogo estrategia, List<Peca> maoJogador) {
		
		this.nome = nome;
		this.estrategia = estrategia;
		this.mao = new LinkedList<>(maoJogador);
		this.ultimaJogada = null;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	/**
	 * @return O nome do jogador
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Decide a próxima jogada a ser feita pelo jogador dado o estado da mesa.
	 * Verifica se a decisão da estratégia é para uma peça que está de fato na mão
	 * do jogador.
	 * 
	 * @param mesa A visão da mesa, mostrando as peças jogadas e pontas.
	 * @return A Jogada decidida.
	 * @throws EstrategiaInvalidaException Caso a estratégoa decida jogar uma peça
	 *                                     que não está na mão do jogador.
	 */
	public Jogada decideJogada(VisaoDaMesa mesa) throws EstrategiaInvalidaException {
        Jogada jogada = this.estrategia.decideJogada(mesa, mao);

        if (jogada.getTipo() != TipoJogada.PASSA) {
            Peca pecaJogada = jogada.getPeca();
            boolean realmenteTem = mao.contains(pecaJogada);
            if (!realmenteTem) {
                throw new EstrategiaInvalidaException(nome + " tentou jogar pe�a que n�o tem: " + pecaJogada);
            }
            this.ultimaPeca = pecaJogada;
        }
        this.ultimaJogada = jogada;
        return jogada;
    }
	
	/**
	 * Retira uma peça da mão do jogador. É ncessário quando a peça é posta na mesa.
	 * 
	 * @param peca A peça a retirar.
	 */
	public void removeDaMao(Peca peca) {
		this.mao.remove(peca);
	}

	/**
	 * Número de peças na mão do jogador.
	 * 
	 * @return peças na mão ainda por jogar.
	 */
	public int getNumPecas() {
		return mao.size();
	}

	@Override
	public String toString() {
		return this.getNome() + (ultimaJogada == null ? "" : ", joga: " + ultimaJogada.toString()) + ", m�o: "
				+ mao.toString();
	}
	

	/**
	 * @return A última jogada desse jogador. Null se não há.
	 */
	public Jogada getUltimaJogada() {
		return ultimaJogada;
	}
	
	/**
	 * @return C�pia da m�o dispon�el para esse jogador.
	 */
	public List<Peca> getMao() {
		return new LinkedList<>(mao);
	}
	public int somaPecas() {
		int valorPecas = 0;
		
		for(int k = 0; k < mao.size(); k++) {
			valorPecas += mao.get(k).somalados();
		}
		return valorPecas;
	}
	public Peca getUltimaPeca() {
		return this.ultimaPeca;
	}
	
}
