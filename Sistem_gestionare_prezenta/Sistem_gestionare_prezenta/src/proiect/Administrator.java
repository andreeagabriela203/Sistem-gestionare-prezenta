package proiect;

import java.util.ArrayList;

public class Administrator extends Utilizator {
       private static ArrayList<Student> studenti;
       private ArrayList<Profesor> profesori;
       
       // ---- Metode ----
       
       //Constructor fara parametrii
       public Administrator() {
    	   studenti= new ArrayList<Student>();
    	   profesori= new ArrayList<Profesor>();
       }
       //Metoda pentru adaugarea unui profesor in functie de nume
	public void adaugaProfesor(String nume) {
		Profesor prof= new Profesor(nume, "1234");
	    profesori.add(prof);
	}
	// Metoda pentru adaugarea unui profesor impreuna cu cursurile pe care le va preda
	public void adaugaProfesor(String nume, ArrayList<String> cursuri) {
		
	}
	
	//Metoda pentru adaugarea unui nou student
	public void adaugaStudent(String nume) {
		Student student= new Student(nume,"1234");
		studenti.add(student);
	}
	
	//Setare cursuri pentru un student pe baza numelui acestuia
	public void setCursuri(String nume, ArrayList<String> cursuri) {
		for (Student student : studenti) {
		    if (student.getNume().equals(nume)) {
		        student.setCurs(cursuri);
		        break;
		    }
		}		
	}
	//Setare cursuri pentru un profesor pe baza numelui acestuia
	public void setCursProf(String nume, ArrayList<String> cursuri) {
		for(Profesor prof: profesori) {
			if(prof.getNume().equals(nume)) {
				prof.setCurs(cursuri);
				break;
			}
		}
	}
	// Se da lista de utilizatori si se formeaza listele cu studenti & profesori
	public void liste( ArrayList<Utilizator> utilizatori) {
		for(int i=0; i< utilizatori.size(); i++) {
			Utilizator e= utilizatori.get(i);
			if (e.getRol().equals("Student")) {
				Student s= new Student(e.getNume(),e.getParola());
				studenti.add(s);
			}
			else if(e.getRol().equals("Profesor")){
				Profesor p= new Profesor(e.getNume(), e.getParola());
				profesori.add(p);
			}
		}
	}
	// Se cauta si returneaza un profesor din lista de profesori pe baza numelui
	public Profesor getProfesor(String nume) {
		for(Profesor prof: profesori) {
			if(prof.getNume().equals(nume)) {
				return prof;
			}
		}
		return null;
	}
	// Se cauta si returneaza un student din lista de studenti pe baza numelui
	public Student getStudent(String nume) {
		for (Student student : studenti) {
		    if (student.getNume().equals(nume)) {
		       
		        return student;
		    }
		}	
		return null;
	}
	
	//Metoda pentru returnarea unei liste cu studentii care au un anumit curs
	public static ArrayList<Student> StudentiCurs(String curs){
		ArrayList<Student> sc= new ArrayList<Student>();
		for (Student st : studenti) {
			if( st.areCurs(curs))
				sc.add(st);
		}
		return sc;
	}
     // Metoda pentru afisarea celor 2 liste
	public void afisLista() {
		System.out.println("Studenti: ");
		for(int i=0; i<this.studenti.size(); i++) {
			Student s= this.studenti.get(i);
			System.out.println(s.getNumeStudent());
			s.getCursuri();
		}
		System.out.println("Profi: ");
		for(int i=0; i<this.profesori.size(); i++) {
			Profesor p= this.profesori.get(i);
			System.out.println(p.getNume());
			p.getCursuri();
		}
	}
	
}
