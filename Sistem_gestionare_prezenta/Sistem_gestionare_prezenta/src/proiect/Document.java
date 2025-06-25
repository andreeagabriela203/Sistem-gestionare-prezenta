package proiect;

import java.time.LocalDate;

public class Document {
	private Format_Document format;
	private String nume_fisier;
	private int data_incarcare;
	private int data_scutire;
	private int limita;
	
	//Metode
	
	//Constructor
	public Document() {
		this.nume_fisier = null;
		this.data_incarcare= 0;
		this.data_scutire= 0;
		this.limita=10;
	}
	
	//Metoda pentru incarcarea unui document
	public String incarcareDocument(String nume, int data_s) {
		//Verificare documentul este incarcat intr-un format acceptabil, altfel returnam eroarea
		this.nume_fisier = nume;
		String format_doc=nume.substring(nume.indexOf(".")+1);
		if(format_doc.equals("pdf"))
			this.format= Format_Document.pdf;
		else 
			if(format_doc.equals("doc")) {
			this.format= Format_Document.doc;
		    }
				else
					return "Documentul e incarcat intr-un formar incorect";
				
		// Atribuim variabilei data_incarcare, data curenta
	//	LocalDate azi = LocalDate.now();      //salvam intr-o variabila ziua curenta
		//this.data_incarcare = azi.toString();
		
		// Inseram data scutirii
		this.data_scutire= data_s;
		this.data_incarcare = Cod.getData();
		
		return "Succes";
	}
	
     public String getNume() {
    	 return this.nume_fisier;
     }
     public int getDataIncarcare() {
    	 return this.data_incarcare;
    	 
     }
     public int getDataScutire() {
    	 return this.data_scutire;
     }

}
