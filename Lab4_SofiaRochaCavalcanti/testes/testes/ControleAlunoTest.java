package testes;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle_de_alunos.Aluno;
import controle_de_alunos.ControleAlunos;

class ControleAlunoTest {
	private ControleAlunos controleAlunoTest;
	
	@BeforeEach
	public void aluno() {
		controleAlunoTest = new ControleAlunos();
		controleAlunoTest = new ControleAlunos();
		controleAlunoTest = new ControleAlunos();
	}
	@Test
	public void testCadadastraMatriculaNull() {
		assertThrows(NullPointerException.class, () -> {
			controleAlunoTest.cadastraAluno(null, "jorge felipe", "arq");
		});
	}
	@Test
	public void testCadastraMatriculaVazia() {
		assertThrows(IllegalArgumentException.class, () -> {
			controleAlunoTest.cadastraAluno("", "jorge felipe", "arq");
		});}
	
	

	@Test
	public void testNovoGrupo() {
		controleAlunoTest.cadastrarGrupo("listas");
		assertEquals("CADASTRO REALIZADO!", controleAlunoTest.cadastrarGrupo("listas"));
	}
	@Test
	public void testImprimeGrupo() {
		controleAlunoTest.cadastraAluno("16", "sofia", "civil");
		controleAlunoTest.cadastrarGrupo("materiais");
		controleAlunoTest.adicionaAluno("16", "materiais");
		assertEquals("* 16 - sofia - civil\n", controleAlunoTest.imprimirGrupo("materiais"));
	}

}
