package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogador;
import ufcg.ccc.domino.Jogo;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.estrategia.CarrocaPrimeiro;

class JogadorTest {

	@Test
	void somaPecastest() {
        List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 6), new Peca(6, 4), new Peca(1, 3));
        //Jogo jogo = new Jogo("J1", estrategia1, nomeJogador2, estrategia2, numPecasInicial)
        Jogador jogador = new Jogador("j1", new CarrocaPrimeiro(), mao1);
        assertEquals(20,jogador.somaPecas());
		//Peca peca = new Peca(2, 1);
		
	}
	
}
