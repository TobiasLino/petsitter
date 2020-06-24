package PetShop;

import java.util.Scanner;

public class Controle 
{
 public Scanner scanner;
	
 public Controle() 
 {
     System.out.println("[Controle] Creating new Scanner");
  scanner = new Scanner(System.in);	  
 }
 // TODO(Tobias): need integer verification
 // check input errors, nulls and invalid values.
 public int opcao() 
 {
  int op = scanner.nextInt();
  return op;
 }	
 // TODO(Tobias): need null verification
 public String texto()
 {
  String t = scanner.nextLine();
  return t;
 }
 @Override//metodo especial que executa antes de ser destruido
 protected void finalize() throws Throwable 
 {
  scanner.close();		
 }
}