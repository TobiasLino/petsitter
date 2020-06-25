

import java.util.Scanner;

public class Controle 
{
 public Scanner scanner;
	
 public Controle() 
 {
     System.out.println("[Controller] Creating new Scanner");
  scanner = new Scanner(System.in);	  
 }
 // TODO(Tobias): need integer verification
 // check input errors, nulls and invalid values.
 public int option() 
 {
  int op = scanner.nextInt();
  return op;
 }	
 // TODO(Tobias): need null verification
 public String texto()
 {
  String t = scanner.nextLine();
  if (t == null) {
      System.out.println("Digite uma informação válida");
      return "";
  }
  return t;
 }

 @Override
 protected void finalize() throws Throwable 
 {
  scanner.close();
  System.out.println("[Controller] Finishing..");
 }
}