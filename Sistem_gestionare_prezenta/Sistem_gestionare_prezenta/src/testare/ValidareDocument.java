package testare;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import proiect.Document;
import proiect.Profesor;
import proiect.Student;

class ValidareDocument {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testAfisareDocumentValidare() {
        // Pregatim un student cu un document
        Student student = new Student("Elena","1234");
        String r =student.incarcareDocument("doc1.pdf",2);  // incarcam un doc in student ca sa avem  ce valida

        // Scanner simuleaza introducerea numelui documentului si apoi "nu"
        String input = "doc1.pdf\nnu\n";
        Scanner scanner = new Scanner(new StringReader(input));

        // Apelam metoda
        new Profesor().afisareDocument(student, scanner, "Mate");

        // Verificam ca mesajul de validare a fost afisat
        String output = outContent.toString();
        assertTrue(output.contains("Document validat cu succes."));
    }
    @Test
        public void testFormatIncorecte() {
        // Pregatim un student cu un document
        Student student = new Student("Elena","1234");
        String r =student.incarcareDocument("doc1.odt",2);  // incarcam un doc in student ca sa avem  ce valida
        assertNotEquals(r,"Succes");
    }

    @Test
    public void testMotivareRefuzata() {
        // Pregatim un student cu un document
        Student student = new Student("Elena","1234");
        String r =student.incarcareDocument("doc1.pdf",2);  // incarcam un doc in student ca sa avem  ce valida

        // Scanner simuleaza introducerea numelui documentului si apoi "nu"
        String input = "nu\n";
        Scanner scanner = new Scanner(new StringReader(input));

        new Profesor().afisareDocument(student, scanner, "Mate");

        String output = outContent.toString();
        assertFalse(output.contains("Document validat cu succes."));
    }
    
    @Test
    public void testAfisareFaraDocumente() {
    	 // Pregatim un student cu un document
        Student student = new Student("Elena","1234");
        String r =student.incarcareDocument("doc1.pdf",2);  // incarcam un doc in student

        // Scanner simuleaza introducerea numelui unui document invalid si apoi "nu"
        String input = "doc2.pdf\nnu\n";
        Scanner scanner = new Scanner(new StringReader(input));

        new Profesor().afisareDocument(student, scanner, "Mate");

        String output = outContent.toString();
        assertFalse(output.contains("Document validat cu succes."));
    }
    @Test
    public void testNiciunDocument() {
    	 // Pregatim un student cu un document
        Student student = new Student("Elena","1234");

        String input = "doc2.pdf\nnu\n";
        Scanner scanner = new Scanner(new StringReader(input));

        new Profesor().afisareDocument(student, scanner, "Mate");

        String output = outContent.toString();
        assertTrue(output.contains("Studentul nu are niciun document incarcat."));
    }
    @Test
    public void testDocumentInexistent() {
    	 // Pregatim un student cu un document
        Student student = new Student("Elena","1234");
        String r =student.incarcareDocument("doc1.pdf",2);  // incarcam un doc in student

        // Scanner simuleaza introducerea numelui unui document invalid si apoi "nu"
        String input = "doc1.pdf\ndoc3.pdf\nnu\n";
        Scanner scanner = new Scanner(new StringReader(input));
        new Profesor().afisareDocument(student, scanner, "Mate");

        String output = outContent.toString();
        assertTrue(output.contains("Numele nu exista"));
    }

}
