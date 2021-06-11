package lab3_SofiaRochaCavalcanti;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Contato;

class ContatoTest {
	
	
	private Contato contatoPessoa;
	//private Contato contatoGetTelefonesPrioritarios;
	//private Contato contatoGetWhatszapp;
	
	@BeforeEach
	public void criaContato() {
		this.contatoPessoa = new Contato("Sofia", "Rocha",new String[]{"33217789","98976789", "989786900" }, "1", "2");
		//this.contato1= new Contato ("Carlos", "Gabriel",new String[] {"37217789", "922767896","989780000"} , "", "");
		//this.contato2= new Contato ("Alicia", "Karolina",new String[] {"37217789", "922767896", "989780000"}, "", "3");
	}
	

	

	@Test
	void testToString() {
		String msg = "Esperando obter a representação da classe com suas informações em string : nome completo , telefone prioritario e whatszapp";
		assertEquals("Sofia Rocha\n33217789 (prioritarios)\n989767896 (whatszapp)", this.contatoPessoa.toString(),msg);		
		}		
	}


//}
