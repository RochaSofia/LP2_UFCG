package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle_de_alunos.Aluno;

class AlunoTest {
	private Aluno alunoTest;
	
	@BeforeEach
	public void alunoTest() {
		
	}
	
	@Test
	public void testExibeAlunoCadastrado() {
		alunoTest = new Aluno("123", "adriano", "cc");
		assertEquals("Aluno: 123 - adriano - cc", alunoTest.exibirAluno());
	}
	
	@Test
	public void testImprimeGrupo() {
		alunoTest = new Aluno("098", "Paulo Rocha", "computação");
		assertEquals("* 098 - Paulo Rocha - computação\n", alunoTest.imprimeGrupo());
	}
	
	@Test
	public void testToString() {
		alunoTest = new Aluno("111", "Paulo Rocha", "computação");
		assertEquals("111 - Paulo Rocha - computação\n", alunoTest.toString());
	}
	
	@Test
	public void testMatriculaNull() {
		assertThrows(NullPointerException.class, () -> {
			alunoTest = new Aluno(null, "Dudu", "cc");
	});
	}
	
	@Test
	public void testMatriculaVazia() {
		assertThrows(IllegalArgumentException.class, () -> {
			alunoTest = new Aluno("", "jorge", "arq");
		});
	}
	
	
	
	

}
