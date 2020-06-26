package br.com.fatec.petsitter.view;

import br.com.fatec.petsitter.model.Cliente;
import br.com.fatec.petsitter.model.Profissional;

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
  System.out.println("\t\t#\t3 - Exibir relatorio de ra�as mais comuns                     #");
  System.out.println("\t\t#\t4 - Exibir relatorio de genero preferido pelo cliente.        #");
  System.out.println("\t\t#\t5 - Exibir historico de atendimento.                         #");
  System.out.println("\t\t#\t6 - Sair			                             #");
  System.out.println("\t\t######################################################################");
  System.out.print("\nDigite a opcaoo:");
 }
    public void insertPetSitter(Profissional petsitter) {
        // fix : imprimir dados do profissional
        System.out.println("\nInsira a opcao correta\n"
            + "\t1 - Nome\n"
            + "\t2 - CPF\n"
            + "\t3 - Telefone\n"
            + "\t4 - Endereco\n"
            + "\t5 - Cancelar\n"
            + "\t6 - Salvar\n");
        System.out.print("Qual sua opcao: ");
    }

    public void insertClient(Cliente client) {
        // fix : imprimir dados do cliente
        System.out.println("\nInsira a opcao correta\n"
            + "\t1 - Nome\n"
            + "\t2 - CPF\n"
            + "\t3 - Telefone\n"
            + "\t4 - Endereco\n"
            + "\t5 - Adicionar Pet\n"
            + "\t6 - Cancelar\n"
            + "\t7 - Salvar\n");
        System.out.print("Qual sua opcao: ");
    }

}