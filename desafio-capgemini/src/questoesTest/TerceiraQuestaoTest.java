package questoesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import questoes.TerceiraQuestao;

class TerceiraQuestaoTest {

	
	@Test
	void testProcurarAnagrama() {
	  
	}
	  
	@Test
	void testRetiraEspaco() {
		assertEquals("ovo", TerceiraQuestao.retiraEspaco("o vo"));
	}
	 

	@Test
	void testContaAnagramas() {
		
		assertEquals(2, TerceiraQuestao.contaAnagramas("ovo"));
	}

}
