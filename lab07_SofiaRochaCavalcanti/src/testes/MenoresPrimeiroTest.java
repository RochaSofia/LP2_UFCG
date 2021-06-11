package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.estrategia.JogaMenoresPrimeiro;

class MenoresPrimeiroTest {
	private Mesa m ;
	@BeforeEach
	void setup() throws Exception {
		m = new Mesa();
		m.jogaNaDireita(new Peca(1, 0));
		m.jogaNaDireita(new Peca(0, 6));
	}

	@Test
	void menoresPrimeiroDireitatest() {
		JogaMenoresPrimeiro j = new JogaMenoresPrimeiro();
		Jogada j1 = j.decideJogada(m, List.of(new Peca(3, 5), new Peca(1,2 )));
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}

}
