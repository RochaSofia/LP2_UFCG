package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.JogadaInvalidaException;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.estrategia.CarrocaPrimeiro;

class CarrocaPrimeiroTest {
	
	@BeforeEach
	void setup() throws Exception {
	Mesa m = new Mesa();
	m.jogaNaDireita(new Peca(1, 0));
	m.jogaNaDireita(new Peca(0, 6));
	}
	
	@Test
	void mesaVaziatest() throws JogadaInvalidaException {
		CarrocaPrimeiro c = new CarrocaPrimeiro();
		Mesa  mesa = new Mesa();
		Jogada j1 = c.decideJogada(mesa, List.of(new Peca(0, 5), new Peca(2, 2)));
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
        assertEquals(2, j1.getPeca().getNumEsquerdo());
        assertEquals(2, j1.getPeca().getNumDireito());
	}
	

}
