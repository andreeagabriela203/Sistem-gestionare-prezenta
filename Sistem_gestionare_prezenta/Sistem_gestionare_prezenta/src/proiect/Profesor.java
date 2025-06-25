package proiect;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Profesor extends Utilizator {
    private ArrayList<String> curs;
 
    
    //Metode
    
    //Constructor fara parametrii
    public Profesor() {
    	this.curs= new ArrayList<String>();
    }
    
    //Constructor cu parametrii
   public Profesor( String nume, String parola ) {
	   super(nume,parola,"Profesor");
		this.curs= new ArrayList<String>();
   }

   // Metoda pentru generarea unui cod si returnarea acestuia
   public Integer generareCod() {
	   Cod cod_generat= new Cod();
	   return cod_generat.genereazaCod();
   }
   // Metoda pentru adaugarea unor cursuri 
   public void setCurs(ArrayList<String> cursuri) {
  	 for(int i=0; i< cursuri.size(); i++) {
  		 curs.add(cursuri.get(i));
  	 }
   }
   // Metoda pentru afisarea cursurilor unui profesor
  public void getCursuri() {
  	for(int i=0; i<curs.size(); i++)
  		System.out.println(curs.get(i));
  }
  
   //Metoda pentru preluare lista studenti in functie de curs
   public void listaStudenti(String curs){
	   ArrayList<Student> lista = Administrator.StudentiCurs(curs);
	   for(Student st : lista) {
		   System.out.println(st.getNume());
	   }
   }
   
   // Metoda ce are ca scop validarea documentelor introduse de un student
   public void afisareDocument(Student st, Scanner s, String curs) {
	   //Preluam lista documentelor specifice studentului
	  ArrayList<Document> docs = st.getListaDoc();
	  
	  // Verficam daca exista documente, caz in care le afisam
	  if(docs.isEmpty())
		  System.out.println("Studentul nu are niciun document incarcat.");
	  else { // Parcurgem si afisam fiecare document in parte
		  for (Document d: docs) {
			  System.out.println("Nume fisier: "+ d.getNume() + "\n" + "Data incarcare: " + (d.getDataIncarcare()+1) + "\n"+" Data motivare: " + d.getDataScutire());

		  }
		  
		  System.out.println("Introduceti numele fisierului pe care doriti sa il validati sau 'nu' daca nu doriti sa validati: ");

		  String val = s.nextLine();    // Variabila utilizata pentru a retine raspunsul utilizatorului
		  while(!val.equals("nu")) {
			  int i = st.getindexofDoc(val);   
			  if(i==-1) {
				  System.out.println("Numele nu exista! Reincercati:");
				  val = s.nextLine();
			  }
			  else {
				  Document d= docs.get(i);    // Preluam documentul 
				  docs.remove(d);             // Scoatem documentul din lista
				  st.validarePrezenta(d.getDataScutire(),curs);    // Validam prezenta
				  System.out.println("Document validat cu succes. Doriti sa motivati alt document?");
				  val = s.nextLine();
			  }
		  }
	  }
	
	  
   }
   

}
