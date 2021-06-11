package testes;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Peca;

class Pecatest {
	

	@Test
	void somaLadostest() {
		Peca peca = new Peca(0, 6);
        assertEquals(6,peca.somalados());
	}
	
	@Test
	
	void isCarreiraoTest() {
		Peca peca = new Peca(0, 0);
		assertTrue(true == peca.isCarreirao());
		
	}
	
	@Test

    void CarreiraoDiferenteTest() {
        Peca peca = new Peca(0, 1);
        assertFalse(true == peca.isCarreirao());

    }
}
