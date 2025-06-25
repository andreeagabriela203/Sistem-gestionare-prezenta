package proiect;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Cod {
  private static ArrayList<Integer> cod= new ArrayList<Integer>();
  private static Integer data_generare=0;
  //Metode
  
  //Metoda pentru generarea unui cod
  public static Integer genereazaCod() {
	  int random_code=0;
	  Random rand = new Random();
	  for(int i=0; i<5; i++) {            // generam un cod de 5 cifre, unde fiecare cifra e aleasa random intre 0-9
		  random_code= random_code*10 + rand.nextInt(9);
	  }
	  cod.add(random_code);
	  
	  return random_code;
	  
	  
  }
  
  //Metoda pentru validarea unui cod
  public static boolean validareCod(Integer c) {
	  if(cod.contains(c))
		  return true;
	  return false;
  }
  
  public static Integer getData() {
	  return data_generare;
  }
  // golim lista la sf de sapt si crestem pentru saptamana viitoare
  public void eliminare_cod(Integer c) {
	  cod.clear();
	  data_generare++;
}
  
}