package testare;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import proiect.Cod;
import proiect.Student;

class ScanareCod {

    
	@Test
	void testScanareCod() {
		// generam un cod
		int codul_meu = Cod.genereazaCod();
		//creare student
		Student st = new Student("Maria","234");
		boolean r= st.scanareCod(codul_meu, "Mate");
		assertTrue(r);
	}
	
	@Test
	void testScanareCodFaraGenerareInitiala() {
		Student st = new Student("Maria","234");
		boolean r= st.scanareCod(2346, "Mate");
		assertFalse(r);
	}
	@Test
	void testCodGresit() {
		int codul_meu = Cod.genereazaCod();
		Student st = new Student("Maria","234");
		boolean r= st.scanareCod(codul_meu/10, "Mate");
		assertFalse(r);
	}
	
}
