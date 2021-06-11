package controle_de_alunos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Uma classe responsavel pelas ações dos alunos
 * @author Sofia Rocha*/

public class ControleAlunos {
	private HashMap<String, Aluno> repositorioAlunos ;
	private HashMap<String, Grupo> colecaogrupos ;
	private ArrayList<Aluno> alunosResponderam;
	/***
	 * Constroi um controle de alunos */
	
	
	
	public ControleAlunos() {
		
		this.repositorioAlunos = new HashMap<String, Aluno>();
		this.colecaogrupos = new HashMap<String, Grupo>();
		this.alunosResponderam = new ArrayList<Aluno>();
	}
	/***
	 * Cadastra aluno a partir da sua matricula , nome e curso
	 * @param matricula A matricula em String
	 * @param nome O nome do aluno em String
	 * @param curso O curso do aluno em String
	 * @return saida Retorna se a matricula foi cadastrada ou se já existe*/

	public String cadastraAluno(String matricula, String nome,String curso) {
		//Aluno aluno = new Aluno(matricula,nome,curso);
		//this.repositorioAlunos.put(matricula, aluno);
		boolean matriculaExiste = this.repositorioAlunos.containsKey(matricula);
		String saida= "";
		
		if (matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Entrada inválida");
		}
		if (matricula.equals("") || nome.equals("") || curso.equals("")) {
			throw new IllegalArgumentException("Entrada inválida");
		}
		
		
		if (matriculaExiste == true) {
			//System.out.println(alunos.getAluno(matricula));
			saida = "MATRÍCULA JÁ CADASTRADA!";
			return saida;
		} else {
			Aluno aluno = new Aluno(matricula,nome,curso);
			this.repositorioAlunos.put(matricula, aluno);
			saida = "CADASTRO REALIZADO!";
			return saida;
			
		}
		
	}
	
	/*
	//procura de ja existe essa matricula
	public boolean existeAluno(String matricula) {
		return this.repositorioAlunos.containsKey(matricula);
	}*/
	
	/**
	 * Cadastra o nome do grupo de estudos 
	 * @param nomedoGrupo Nome do grupo de estudos dado pelo usuario
	 * @return saida Mensagem se o grupo foi cadastrado ou se ele já existe*/
	public String cadastrarGrupo(String nomedoGrupo) {
		String saida ="";
		
		if (nomedoGrupo == null) {
			throw new NullPointerException("Entrada inválida");
		}
		if (nomedoGrupo == "") {
			throw new IllegalArgumentException("Entrada inválida");
		}
		
		
		if (this.colecaogrupos.containsKey(nomedoGrupo) == false) {
			Grupo grupo = new Grupo(nomedoGrupo);
			this.colecaogrupos.put(nomedoGrupo, grupo);
			saida = "CADASTRO REALIZADO!";
		}else {
			saida= "GRUPO JÁ CADASTRADO!";
		}
		return saida;
		
	}
	
	//pega um aluno do mapa
	/**
	 * Pega um aluno referente a matricula dada pelo usuario como parametro
	 * @param matricula A matricula do aluno
	 * @return Dados do aluno no formato : Aluno: matricula - nome - curso*/
	public String getAluno(String matricula) {
		return this.repositorioAlunos.get(matricula).exibirAluno();
	} 
	/**
	 * Adiciona um aluno ao grupo de estudo 
	 * @param matricula A matricula do aluno que sera adicionado
	 * @param nomedoGrupo O nome do grupo que o aluno deverá ser adicionado
	 * @return saida A mensagem de confirmação se o aluno foi adicionado , ou se o grupo ou o aluno não estão cadastrados*/
	
	public String adicionaAluno(String matricula , String nomedoGrupo) {
		//return this.repositorioAlunos.containsKey(matricula);
		boolean matriculaExiste = this.repositorioAlunos.containsKey(matricula);
		boolean grupoExiste = this.colecaogrupos.containsKey(nomedoGrupo);
		String saida = "";
		
		if (matricula == null || nomedoGrupo == null) {
			throw new NullPointerException("Entrada inválida");
		}
		if (matricula.equals("") || nomedoGrupo == "") {
			throw new IllegalArgumentException("Entrada inválida");}
		
		
		if(matriculaExiste == true && grupoExiste == true ) {
			Grupo colecaogrupos = this.colecaogrupos.get(nomedoGrupo);
			Aluno repositorioAlunos = this.repositorioAlunos.get(matricula);
			colecaogrupos.adicionaIntegrante(repositorioAlunos);
			saida = "ALUNO ALOCADO!";
		}else{
			if (matriculaExiste == false) {
			saida= "Aluno não cadastrado.";
			}else {
				if (grupoExiste == false) {
					saida="Grupo não cadastrado.";

				}
			}
		
		}
		return saida ;
		
	}
	/**
	 * Imprime os integrantes do grupo de estudos a partir do nome do grupo que o usuario colocar como parametro
	 * @param nomedoGrupo o nome do grupo que deverá ser impresso
	 * @return Os integrantes do grupo de estudos*/
	
	public  String imprimirGrupo(String nomedoGrupo) {
		
			Grupo colecaogrupos = this.colecaogrupos.get(nomedoGrupo);
			return colecaogrupos.imprimeGrupo();
	}
	//alunos que responderam no quadro
	/**
	 * Cadastro de quem respondeu as questões no quadro , através da sua matricula 
	 * @param matricula A matricula do aluno que respondeu a questão e deverá ser cadastrado
	 * @return Mensagem se o aluno foi cadastrado ou não*/
	
	public String resgistrarAlunoRespondeu(String matricula) {
		boolean matriculaExiste = this.repositorioAlunos.containsKey(matricula);
		
		if (matricula == null) {
			throw new NullPointerException("Entrada inválida");
		}
		if (matricula == "") {
			throw new IllegalArgumentException("Entrada inválida");
		}
		
		
		
		if (matriculaExiste== true) {
			Aluno alunoRespondeu = this.repositorioAlunos.get(matricula);
			alunosResponderam.add(alunoRespondeu);
			return "ALUNO REGISTRADO!";
			
		}else {
			return "Aluno não cadastrado.";

		}
	}
		
		
		/*
		Aluno alunoRespondeu = this.repositorioAlunos.get(matricula);
		
		
		//verificar se existe , adiciona
		//aluno respondeu = pegar o aluno do hashmap 
		//Aluno alunoRespondeu = 
		alunosResponderam.add(alunoRespondeu);
	}*/
	/**
	 * A lista em ordem dos alunos que responderam no quadro 
	 * @return saida A lista de pessoas que responderam no quadro em ordem , no formato : posição. matricula - nome - curso*/
	public  String imprimir() {
		String saida= "";
		for (int i = 1; i <= alunosResponderam.size(); i++) {
			saida += i + ". "+ alunosResponderam.get(i-1).toString();
		}
		return saida;
	}
	
	
	@Override
	public String toString() {
		return "ControleAlunos [repositorioAlunos=" + repositorioAlunos + ", colecaogrupos=" + colecaogrupos
				+ ", alunosResponderam=" + alunosResponderam + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunosResponderam == null) ? 0 : alunosResponderam.hashCode());
		result = prime * result + ((colecaogrupos == null) ? 0 : colecaogrupos.hashCode());
		result = prime * result + ((repositorioAlunos == null) ? 0 : repositorioAlunos.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControleAlunos other = (ControleAlunos) obj;
		if (alunosResponderam == null) {
			if (other.alunosResponderam != null)
				return false;
		} else if (!alunosResponderam.equals(other.alunosResponderam))
			return false;
		if (colecaogrupos == null) {
			if (other.colecaogrupos != null)
				return false;
		} else if (!colecaogrupos.equals(other.colecaogrupos))
			return false;
		if (repositorioAlunos == null) {
			if (other.repositorioAlunos != null)
				return false;
		} else if (!repositorioAlunos.equals(other.repositorioAlunos))
			return false;
		return true;
	}
		
	}


