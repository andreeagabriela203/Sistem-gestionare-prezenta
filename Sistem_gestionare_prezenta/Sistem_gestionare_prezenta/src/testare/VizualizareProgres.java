package testare;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import proiect.Situatie;
class VizualizareProgres {

    private Situatie situatie;

    @BeforeEach
    void setUp() {
        situatie = new Situatie("POO");
    }	
    
	@Test
	void testPrezenta() {
        situatie.prezenta(1); // sapt 2

        Map<String, Boolean> absente = situatie.getAbsente();
        assertTrue(absente.containsKey("Saptamana 2"));
        assertTrue(absente.get("Saptamana 2"));
	}

	@Test
    void testAfisabsenteFaraPrezente() {
        Map<String, Boolean> absente = situatie.getAbsente();

        //absente ar trebui sa fie gol
        assertTrue(absente.isEmpty(), "Nu ar trebui sa existe nicio prezenta.");
    }
	
    @Test
    void testAfisabsenteCuPrezentePartial() {
        situatie.prezenta(0); // sapt 1
        situatie.prezenta(2); // sapt 3

        Map<String, Boolean> absente = situatie.getAbsente();
        assertEquals(2, absente.size());

        assertTrue(absente.containsKey("Saptamana 1"));
        assertTrue(absente.containsKey("Saptamana 3"));
        assertFalse(absente.containsKey("Saptamana 2"));
    }
    
    @Test
    void testLimitaSuperioara() {
        for (int i = 0; i < 50; i++) {
            situatie.prezenta(i);
        }

        Map<String, Boolean> absente = situatie.getAbsente();
        assertEquals(50, absente.size());
        assertTrue(absente.containsKey("Saptamana 50"));
        assertTrue(absente.get("Saptamana 50"));
    }
	
    @Test
    void testPrezentDeDouaOriAceeasiSaptamana() {
        situatie.prezenta(1); // sapt 2
        situatie.prezenta(1); // sapt 2 again

        Map<String, Boolean> absente = situatie.getAbsente();
        assertEquals(1, absente.size(), "Nu ar trebui sa adauge de doua ori aceeasi saptamana.");
        assertTrue(absente.get("Saptamana 2"));
    }
	

}