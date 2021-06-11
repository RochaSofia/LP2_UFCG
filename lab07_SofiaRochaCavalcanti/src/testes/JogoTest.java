package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.HistoricoDeJogo;
import ufcg.ccc.domino.JogadaInvalidaException;
import ufcg.ccc.domino.Jogador;
import ufcg.ccc.domino.Jogo;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.estrategia.CarrocaPrimeiro;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaMenoresPrimeiro;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import java.util.List;
import java.util.Random;
class JogoTest {
	@Test
    void testVencedorJ1Simples() throws Exception {
        List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
        List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
        
        Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

        assertFalse(j.isFinalizado());
        assertEquals(null, j.getVencedor());

        j.jogaJogoCompleto();

        assertTrue(j.isFinalizado());
        assertEquals("J1", j.getVencedor());
    }
	
	
	
	@Test
	void testEmpate() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertNull(j.getVencedor());
	}
	
	@Test
	void testVitoriaJ2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}
	@Test
	void VencedorMaisPecastest() throws Exception {
		 List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
	        List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3),new Peca(1, 3));
	        
	        Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

	        assertFalse(j.isFinalizado());
	        assertEquals(null, j.getVencedor());

	        j.jogaJogoCompleto();

	        assertTrue(j.isFinalizado());
	        assertEquals("J1", j.getVencedor());		
	}


	@Test
	void VencedorSomaPecastest() throws Exception {
		 List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
	        List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3),new Peca(1, 3));
	        
	        Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

	       
	        j.jogaJogoCompleto();

	        assertTrue(j.isFinalizado());
	        assertEquals("J2", j.getVencedor());		
	}
	@Test
	void verificatest() {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
        List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3),new Peca(1, 3));
        Jogador j1 = new Jogador("j1", new JogaPrimeiraPossivel(), mao1);
        Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
        
        assertEquals(3, j.verificaPontuacao(j1));
	}
	
	
	

}
