package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle_de_alunos.Aluno;
import controle_de_alunos.Grupo;

class Grupotest {
	private Grupo grupoTest;
	private Aluno alunoTest;

	@BeforeEach
	public void grupoBasico() {

	}
	@Test
	public void testImprimeAlunosEmGrupos() {
		grupoTest = new Grupo("listas");
		alunoTest = new Aluno("1", "netinho", "historia");
		this.grupoTest.adicionaIntegrante(alunoTest);
		assertEquals("* 1 - netinho - historia\n", grupoTest.imprimeGrupo());
	}
	@Test
	public void testNomeDoGrupoVazio() {
		assertThrows(IllegalArgumentException.class, () -> {
			grupoTest = new Grupo("");
		});
	}

	@Test
	public void testNomeDoGrupoNull() {
		assertThrows(NullPointerException.class, () -> {
			grupoTest = new Grupo(null);
		});
	}


	

}
