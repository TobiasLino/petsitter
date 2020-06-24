

public class Menu 
{
    public Menu() {
        System.out.println("[Menu] Creating interface.");
    }
 public void inicio()
 {  	 
  System.out.println("\nBem - vindo ao Sistema da PETSITTER");
 }

 public void mainMenu()	
 { 
  System.out.println("\n\n\t\t######################################################################");		
  System.out.println("\t\t#\t1 - Cadastrar Profissionais.                                 #");
  System.out.println("\t\t#\t2 - Cadastrar Clientes e Animais                             #");  
  System.out.println("\t\t#\t3 - Exibir relat�rio de ra�as mais comuns                     #");
  System.out.println("\t\t#\t4 - Exibir relat�rio de genero preferido pelo cliente.        #");
  System.out.println("\t\t#\t5 - Exibir hist�rico de atendimento.                         #");
  System.out.println("\t\t#\t6 - Sair			                             #");
  System.out.println("\t\t######################################################################");
  System.out.print("\nDigite a op��o:");
 }
}