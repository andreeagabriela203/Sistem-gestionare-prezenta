package proiect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicatie {
	
	private static ArrayList<Utilizator> utilizatori;
	private static Administrator a= new Administrator();
	
	public static void addUtilizatori() {
		Utilizator u= new Utilizator("Ana", "1234", "administrator");
		utilizatori.add(u);
		u= new Utilizator("Elena","5678","Student");
		utilizatori.add(u);
		u= new Utilizator("Maria","aremere","Student");
		utilizatori.add(u);
		u= new Utilizator("Ioana","prof1", "Profesor");
		utilizatori.add(u);
	}
	public static ArrayList<String> addCursStudenti() {
		ArrayList<String> curs= new ArrayList<String>();
		curs.add("Mate");
		curs.add("Fizica");
		curs.add("Info");
		return curs;
	}
	//Se cauta in lista de utilizatori un utilizator dupa nume si parola si se retuneaza indexul la care se gaseste acesta sau -1 in caz contrar
   public static int verificare(String nume, String parola) {
	   int index = 0;
	   for(Utilizator utilizator: utilizatori) {
		   if(utilizator.getNume().equals(nume) && utilizator.getParola().equals(parola)) {
			 
			  return index;
	   }
		   index++;
	   }
	   return -1;
   }
   
   //Functionalitatile specifice Administratorului
   public static void Admin(Scanner s) {
	   String buff;
	   System.out.println("Alegeti optiunea: "+"\n"+ "1.Adaugare profesor"+ "\n"+ "2.Adaugare student"+"\n"+ "3.Adaugare curs"+"\n" +"4.Deconectare");
	   int opt= s.nextInt();
	   buff = s.nextLine();
	   
	   while(opt!=4) {
		   
		   if(opt==1) {
			   System.out.println("Introduceti numele profesorului: ");
			   String num= s.nextLine();
			   a.adaugaProfesor(num);
		   }
		   
		   if(opt ==2 ){
			   System.out.println("Introduceti numele studentului: ");
			   String num= s.nextLine();
			   a.adaugaStudent(num);			   
		   }
		   
		   if(opt ==3) {
			   System.out.println("Pentru profesor sau Student?: ");
			   String r= s.nextLine();
			   System.out.println("Introduceti numele: ");
			   String num= s.nextLine();
			   ArrayList<String> cursuri = new ArrayList<String>();
			   String c="da";
			   while(!c.equals("nu")) {
				   System.out.println("Introduceti cursul sau 'nu' daca nu mai doriti sa adaugati cursuri: ");
				   c= s.nextLine();
				   if(!c.equals("nu"))
					   cursuri.add(c);
			   }
			   if(r.equals("Profesor"))
				   a.setCursProf(num, cursuri);
			   else
				   if(r.equals("Student")) {
					   a.setCursuri(num, cursuri);
				   }
		   }
		   System.out.println("Introduceti optiunea: ");
		  opt= s.nextInt();
		  
	   }
	   
	   System.out.println("Delogare reusita!");
   }
   
   //Functionalitatile specifice unui profesor
   public static void Prof(int index,Scanner s,String nume) {
	   Profesor prof= a.getProfesor(nume);
	   String buff;
	   System.out.println("Alegeti optiunea: "+"\n"+ "1.Generare cod"+ "\n"+ "2.Delogare"+ "\n" + "3.Generare Lista Studenti");
	   int opt= s.nextInt();
	   while(opt!=2) {
		   if(opt==1)
			   System.out.println(prof.generareCod());
		   if(opt ==3 ){
			   System.out.println("Introduceti numele cursului: ");
			   buff = s.nextLine();
			   String c= s.nextLine();
			   prof.listaStudenti(c);
			   System.out.println("Introduceti numele elevului pentru care doriti sa motivati absente sau 'nu' pentru a iesi: ");
			   String n= s.nextLine();
			   if(!n.equals("nu"))
			   prof.afisareDocument(a.getStudent(n), s, c);
			   
		   }
		  System.out.println("Introduceti optiunea: ");
		  opt= s.nextInt();
	   }
	   
	   System.out.println("Delogare reusita!");
   }
   
   //Functionalitatile specifice unui student
   public static void myStudent(String nume, Scanner s) {
	   Student st= a.getStudent(nume);
	   System.out.println("Alegeti optiunea: "+"\n"+ "1.Scanare cod"+ "\n"+ "2.Delogare"+ "\n"+ "3.Afisare situatie" + "\n" + "4.Incarcare document");
	   int opt= s.nextInt();
	   while(opt!=2) {
		   if(opt==1) {
			   System.out.println("Introduceti codul: ");
			   int cod= s.nextInt();
			   if(st.scanareCod(cod, "Mate")) {
				   System.out.println("Scanare reusita!");
			   }
			   else
				   System.out.println("Ups");
			  
		   }
		   if(opt==3) {
			   st.afisSituatie("Mate");
		   }
		   if(opt == 4) {
			   String nume_fisier;
			    int data_motivare;
			    String buff;
			   System.out.println("Numele fisierului(impreuna cu extensia):");
			   buff= s.nextLine();
			   nume_fisier = s.nextLine();
			   System.out.println("Saptamana in care se doreste motivarea:");
			   data_motivare = s.nextInt();
			   String r =st.incarcareDocument(nume_fisier, data_motivare);
			   System.out.println(r);
		   }
			  
		  opt= s.nextInt();
	   }
	   System.out.println("Delogare reusita!");
   }
   
	public static void main(String[] args) {
		
    Scanner s= new Scanner(System.in);
    utilizatori= new ArrayList<Utilizator>();
    addUtilizatori();
    //Testare listele au fost facute corect
    a.liste(utilizatori);
    //Testare adaugare prof   
    a.adaugaProfesor("Andrei");
    //Testare adaugare student
    a.adaugaStudent("Andreea");
    //Testare adaugare cursuri la studenti
    ArrayList<String> cursuri = new ArrayList<>(List.of("Mate", "Fizica", "Romana"));
    a.setCursuri("Maria", cursuri);
    a.setCursuri("Elena", cursuri);
    cursuri= new ArrayList<>(List.of("Mate","Romana"));
    a.setCursuri("Andreea", cursuri);
    //Testare adaugare cursuri la profi
    cursuri= new ArrayList<>(List.of("Mate"));
    a.setCursProf("Ioana", cursuri);
    cursuri= new ArrayList<>(List.of("Romana"));
    a.setCursProf("Andrei", cursuri);

    // Incepe
    String logare;
    System.out.println("Doriti sa va logati?: ");
    logare= s.nextLine();
    while(logare.equals("Da")) {
    	System.out.println("Introduceti numele: ");
    	String nume= s.nextLine();
    	System.out.println("Introduceti parola: ");
    	String parola= s.nextLine();
    	int index= verificare(nume, parola);
    	if(index == -1) {
    		System.out.println("Nu exista utilizator.");
    	}
    	else
    	{
    		String rol = utilizatori.get(index).getRol();
    		if(rol.equals("Profesor")) {
    			Prof(index, s, nume);
    			
    		}
    		if(rol.equals("Student")) {
    			myStudent(nume,s);
    		}
    		if(rol.equals("administrator")) {
    			Admin(s);
    		}
    	}
    	System.out.println("Doriti sa va logati?: ");
    	String buff = s.nextLine();
        logare= s.nextLine();    
    
    }
    System.out.println(a.getStudent("Elena").areCurs("Biologie"));
    
}
}
