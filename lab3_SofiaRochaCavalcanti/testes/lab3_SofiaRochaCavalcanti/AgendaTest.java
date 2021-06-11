package lab3_SofiaRochaCavalcanti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

class AgendaTest {
	
	private Agenda agenda;
	private Contato contato;

	@BeforeEach
	public void criaAgenda(){
		this.agenda = new Agenda();
		this.contato = new Contato ("Sofia", "Rocha",new String[]{"33217789","98976789", "989786900" }, "1", "2");		
		this.agenda.cadastraContato(1,"Sofia", "Rocha",new String[]{"33217789","98976789", "989786900" }, "1", "2");
	}
	

	 @Test
	    void testGetContato() {
	        assertEquals(this.contato, this.agenda.getContato(1));
	    }
	 
	   @Test
	    void testCadastraContatoPosicaoOcupada() {
	        Contato contato1 = new Contato("Isaac", "Newton",new String[] {"(83) 98156-7349", "(83) 98649-0249",
	                "(83) 98164-4695"}, "1", "1");
	        this.agenda.cadastraContato(1,"Isaac", "Newton",new String[] {"(83) 98156-7349", "(83) 98649-0249",
            "(83) 98164-4695"}, "1", "1" );
	        assertEquals(contato1, this.agenda.getContato(1));
	    }
	
}
