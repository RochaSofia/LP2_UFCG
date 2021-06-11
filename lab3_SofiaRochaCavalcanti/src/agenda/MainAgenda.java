package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 * @author Sofia Rocha
 */
public class MainAgenda {
	/**
	 * Inicializa a agenda (arquivo_inicial.csv) e trabalha com possiveis erros por falta de arquivo*/
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(T)elefones prioritarios\n" +
						"(Z)aps\n"+
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "T":
			telefonePrioritario(agenda);
			break;
		case "Z":
			whatszapp(agenda);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	

	/**
	 *Identifica qual é o telefone referente ao whatszapp
	 *@param agenda a agenda que esta sendo manipulada */
	

	private static void whatszapp(Agenda agenda) {
		String endereco = ""  ;//variavel que guarda o valor do telefone da pessoa
		for (int i = 0; i < agenda.getContatos().length; i++) {
			Contato contato =agenda.getContato(i+1);
			if (contato != null) {
				endereco =agenda.getContato(i+1).getWhatszapp();
				System.out.println(agenda.getContato(i+1).getNomeCompleto() + " - " + endereco);}
				
				}
		
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				int posicao = i+ 1;
				System.out.println(posicao+" - " +contatos[i].getNomeCompleto());
				
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda que deverá ser manipulada.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		if (1 > posicao || posicao > 100) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
			}
		scanner.nextLine();
		Contato contato = agenda.getContato(posicao);
		if (contato == null) {
			System.out.println("POSIÇÃO INVÁLIDA!");
			return;
		}
		
		System.out.println("Dados do contato:\n" + posicao + ": " + contato);
	}
	/**
	 * Indentifica quem é o telefone prioritario do contato
	 * 
	 * @param agenda A agenda que esta sendo manipulada
	 * 
	 */
	
	private static void telefonePrioritario(Agenda agenda) {
		String endereco = ""  ;//variavel que guarda o valor do telefone da pessoa
		for (int i = 0; i < agenda.getContatos().length; i++) {
			Contato contato =agenda.getContato(i+1);
			if (contato != null) {
				endereco =agenda.getContato(i+1).getTelefonesPrioritarios();
				if (endereco.equals("")) {
					
					System.out.println(agenda.getContato(i+1).getNomeCompleto() + " - " + endereco);
					
				}
				System.out.println(agenda.getContato(i+1).getNomeCompleto() + " - " + endereco);
				
		}}
		
		
	}
	
	

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda que esta sendo manipulada.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		String[] telefones = new String[3];
		
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		if (1 > posicao || posicao > 100) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return; }
			
			scanner.nextLine();
			System.out.println("Nome: ");
			String nome = scanner.nextLine().trim();
			System.out.println("Sobrenome: ");
			String sobrenome = scanner.nextLine().trim();
			
			for (int i = 1; i <= telefones.length; i++) {
				System.out.println("Telefones"+i+":");
				String telefone = scanner.nextLine();
				telefones[i-1] = telefone;
			}
			
			System.out.println("Telefone prioritario:");
			
			String telefonePrioritario = scanner.nextLine().strip();
			
			if (telefonePrioritario == "") {
				telefonePrioritario = "-1";
				}
			
			
			System.out.println("Contato whatsapp:");
			
			String whatszapp = scanner.nextLine().strip();
			if (whatszapp =="") {
				whatszapp = "-1";
			}
			agenda.cadastraContato(posicao, nome ,sobrenome,telefones, telefonePrioritario,whatszapp);
			System.out.println("CASTRO REALIZADO");
			
			
		
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
