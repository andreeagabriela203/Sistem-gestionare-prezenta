package proiect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Situatie {
     private String curs;
     private Map<String,Boolean> absente= new HashMap<>(); // cheia= data cursului
     
     public Situatie() {
    	 this.curs= null;
     }
     public Situatie(String curs) {
    	 this.curs= curs;
    	 
     }
     public void prezenta(Integer data_curs) {

    	 String d= "Saptamana "+ (data_curs+1);
    	 this.absente.put(d,true);
     }
     public void setCurs(String c) {
    	 this.curs=c;
     }
     public String getCurs() {
    	 return this.curs;
     }
     
     // Metoda pentru afisarea situatiei pentru un anumit numar de saptamani
    public void afisabsente(Integer nr_sapt) {
    	int i=1;
    	while(i < nr_sapt) {
    		String dat= "Saptamana "+ i;
    		if(this.absente.containsKey(dat)) {
    			System.out.println(dat+ " Prezent");
    		}
    		else
    			System.out.println(dat+ " Absent");
    		i++;
    	}
    }
    public Map<String, Boolean> getAbsente(){
    	return this.absente;
    }
     
}
