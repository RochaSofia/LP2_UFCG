package controle_de_alunos;

import java.util.Scanner;

public class MainControledeAlunos {

	public static void main(String[] args) {
		ControleAlunos alunos = new ControleAlunos();
		Scanner scanner = new Scanner(System.in);
		char escolha = 'O';
		while (true) {
			try {
			escolha = menu(scanner);
			comando(escolha, alunos, scanner);
			}catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			} catch (IllegalAccessError e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		
		
		}
	}

	private static char menu(Scanner scanner) {
			System.out.println(
					"\n---\nMENU\n" + 
							"(C)adastrar Aluno\n" + 
							"(E)xibir Aluno\n"+
							"(N)ovo Grupo\n" + 
							"(A)locar Aluno no Grupo e Imprimir Grupos\n"+
							"(R)egistrar Aluno que Respondeu\n"+
							"(I)mprimir Alunos que Responderam\n"+
							"(O)ra, vamos fechar o programa!\n"+
							"Opção> ");
			return scanner.nextLine().toUpperCase().charAt(0);
		}

	private static void comando(char opcao, ControleAlunos aluno, Scanner scanner) {
		switch (opcao) {

		case 'C':
			cadastraAluno(aluno, scanner);
			break;
		case 'E':
			exibirAluno(aluno, scanner);
			break;
		case 'N':
			novoGrupo(aluno, scanner);
			break;
		case 'A':
			alocarImprimir(aluno, scanner);
			break;
		case 'R':
			registrarAluno(aluno, scanner);
			break;
		case 'I':
			imprimirResponderam(aluno);
			break;
		case 'O':
			//sai();
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida!");
		}

	}
	public static void imprimirResponderam(ControleAlunos aluno) {
		System.out.println(aluno.imprimir());//modificar o nome
		
	}

	//cadastrar alunos que responderam questões no quadro
	private static void registrarAluno(ControleAlunos aluno, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine().trim();
		if (matricula.equals("")) {
			throw new IllegalArgumentException("Entrada Inválida");
		}
		System.out.print(aluno.resgistrarAlunoRespondeu(matricula));
		/*
		if (aluno.existeAluno(matricula) == true) {
			aluno.resgistrarAlunoRespondeu(matricula);
			System.out.print("ALUNO REGISTRADO! ");

		}else {
			System.out.print("Aluno não cadastrado.");

		} */
		
		
	}

	private static void cadastraAluno(ControleAlunos alunos, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine().trim();
		if (matricula.equals("")) {
			throw new IllegalArgumentException("Entrada Inválida");
		}
		System.out.print("Nome: ");
		String nome = scanner.nextLine().trim();
		if (nome.equals("")) {
			throw new IllegalArgumentException("Entrada Inválida");

		}
		System.out.print("Curso: ");
		String curso = scanner.nextLine().trim();
		if (curso.equals("")) {
			throw new IllegalArgumentException("Entrada Inválida");

		}
		System.out.println(alunos.cadastraAluno(matricula, nome, curso));
		
	}
		/*
		if (alunos.existeAluno(matricula) == true) {
			//System.out.println(alunos.getAluno(matricula));
			System.out.print("MATRÍCULA JÁ CADASTRADA!");
		} else {
			alunos.cadastraAluno(matricula, nome, curso);

			//System.out.println(alunos.getAluno(matricula));
			System.out.print("CADASTRO REALIZADO!");
		} 
	} */



	private static void alocarImprimir(ControleAlunos alunos, Scanner scanner) {
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo ?");
		String preferencia = scanner.nextLine().trim().toUpperCase();
		if (preferencia.equals("A")) {
			System.out.print("\nMatrícula: ");
			String matricula = scanner.nextLine().trim().toUpperCase();
			if (matricula.equals("")) {
				throw new IllegalArgumentException("Entrada inválida");
			}
			System.out.print("Grupo:  ");
			String nomedoGrupo = scanner.nextLine().trim().toUpperCase();
			if (nomedoGrupo.equals("")) {
				throw new IllegalArgumentException("Entrada inválida");
			}
			//alunos.adicionaAluno(matricula, nomedogrupo);
			System.out.println(alunos.adicionaAluno(matricula, nomedoGrupo));


		}else if(preferencia.equals("I")) {
			System.out.print("Grupo:  ");
			String nomedoGrupo = scanner.nextLine().trim().toUpperCase();
			if (nomedoGrupo.equals("")) {
				throw new IllegalArgumentException("Entrada inválida");
			}
			System.out.print(alunos.imprimirGrupo(nomedoGrupo));
		}
	}

	// cadastrar o grupo de estudos
	private static void novoGrupo(ControleAlunos alunos, Scanner scanner) {
		System.out.print("Grupo: ");
		String nomedogrupo = scanner.nextLine().trim().toUpperCase();
		if (nomedogrupo.equals("")) {
			throw new IllegalArgumentException("Entrada Inválida");
		}
		System.out.print(alunos.cadastrarGrupo(nomedogrupo));


	}
	//consultar aluno
	private static void exibirAluno(ControleAlunos alunos, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine().trim();
		if (matricula.equals("")) {
			throw new IllegalArgumentException("Entrada Inválida");
		}
		if (alunos.getAluno(matricula) == null) {
			System.out.println("Aluno não cadastrado.");
		} else {
			System.out.println(alunos.getAluno(matricula));
		}
	}

}
