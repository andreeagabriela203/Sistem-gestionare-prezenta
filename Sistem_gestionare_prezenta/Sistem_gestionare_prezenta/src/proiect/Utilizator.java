package proiect;

import java.util.ArrayList;

public class Utilizator {
	
	private String nume_utilizator;
	private String parola;
	private String email;
	private String rol;

	//Metode
	
	//Constructor fara parametrii
    public Utilizator() {
    	this.nume_utilizator=null;
    	this.parola=null;
    	this.email=null;
    	this.rol= null;
    
    }
    
    //Constructor cu parametrii
    public Utilizator(String nume, String parola,String rol) {
    	this.nume_utilizator=nume;
    	this.parola=parola;
    	this.rol= rol;
    	this.email=null;
    }

	public String getNume() {
		return this.nume_utilizator;
	}
	public String getRol() {
		return this.rol;
	}
	public String getParola() {
		return this.parola;
	}

	

}
