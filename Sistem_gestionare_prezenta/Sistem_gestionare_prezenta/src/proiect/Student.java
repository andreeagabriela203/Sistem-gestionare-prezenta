package proiect;

import java.util.ArrayList;

public class Student extends Utilizator {
     private ArrayList<Document> doc;
     private ArrayList<String> curs;
     private ArrayList<Situatie> situatie;

     
     //Metode
     public Student(String nume, String parola) {
    	 super(nume,parola,"student");
    	 doc=new ArrayList<Document>();
    	 curs= new ArrayList<String>(); 
    	 situatie = new ArrayList<Situatie>();
    	 
     }
     public void setCurs(ArrayList<String> cursuri) {
    	 for(int i=0; i< cursuri.size(); i++) {
    		 curs.add(cursuri.get(i));
    		 Situatie s= new Situatie(cursuri.get(i));
    		 situatie.add(s);
    	 }
     }
     //Metoda pentru afisarea tuturor cursurilor unui student
    public void getCursuri() {
    	for(int i=0; i<curs.size(); i++)
    		System.out.println(curs.get(i));
    }
    // Metoda care verifica daca un student are un anumit curs
    public boolean areCurs(String curs) {
    	if(this.curs.contains(curs))
    		return true;
    	return false;
    }
    
    // Metoda pentru scanarea unui cod si validarea automata la cursul dat din aceea saptamana
    public boolean scanareCod(Integer codul_meu, String curs) {
    	if(Cod.validareCod(codul_meu)) {
    		for(Situatie sit : situatie) {
    			if(sit.getCurs().equals(curs)) {
    				sit.prezenta(Cod.getData());
    			}
    		}
    		return true;
    	}
    	return false;
    }
    
    // Metoda pentru incarcarea unui document
	public String incarcareDocument(String fisier, int data_s) {

		Document verif_doc= new Document();
		String rezultat=verif_doc.incarcareDocument(fisier, data_s);
		if( rezultat.equals("Succes"))
		{
			this.doc.add(verif_doc);
			
		}
		return rezultat;
	}
	
	// Metoda pentru validarea unui prezenete de la o anumita data
	public void validarePrezenta(int data, String curs) {
		data--;
		for(Situatie sit : situatie) {
			if(sit.getCurs().equals(curs)) {
				sit.prezenta(data);
				break;
			}
		}
	}
	
	// Metoda ce verifica daca un anumit document cu un nume dat exista in lista
	public int getindexofDoc(String name) {
		int i=0;
		for(Document d: this.doc) {
			if(d.getNume().equals(name)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public ArrayList<Document> getListaDoc(){
		return this.doc;
	}
	public String getNumeStudent() {
		return super.getNume();
	}
	
	// Metoda pentru afisarea situatiei unui student la un anumit curs
	public void afisSituatie(String curs) {
		for(Situatie sit: situatie) {
			if(sit.getCurs().equals(curs))
			sit.afisabsente(5);
		}
	}
	
}
