package br.com.fatec.petsitter.view;

import java.util.LinkedList;

import br.com.fatec.petsitter.model.Animal;
import br.com.fatec.petsitter.model.Cliente;
import br.com.fatec.petsitter.model.People;
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

    public void insertPeople(People people) {
        if (people instanceof Cliente)
            insertClient((Cliente) people);
        else
            insertPetSitter((Profissional) people);
    }

    public void insertPetSitter(Profissional petsitter) {
        System.out.println(petsitter.data());
        System.out.println("\nInsira a opcao correta\n"
            + "\t1 - Nome\n"
            + "\t2 - CPF\n"
            + "\t3 - Telefone\n"
            + "\t4 - Endereco\n"
            + "\t5 - Cancelar\n"
            + "\t6 - Salvar\n");
        System.out.print("Qual sua opcao: ");
    }

    private void insertClient(Cliente client) {
        System.out.println(client.data());
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

    public void editPet(Animal pet) {
        System.out.println(pet.data());
        System.out.println("\nInsira a opcao correta\n"
            + "\t1 - Nome\n"
            + "\t2 - raca\n"
            + "\t3 - genero\n"
            + "\t4 - idade\n"
            + "\t5 - Cancelar\n"
            + "\t6 - Salvar\n");
        System.out.print("Qual sua opcao: ");
    }


    public void allocate(Object[] list) {
        System.out.println(((Profissional)list[0]).getName().toUpperCase()
            + " alocado para " + ((Cliente)list[1]).getName().toUpperCase()
            + " para o pet " + ((Animal)list[2].name.toUpperCase() + "\n");
        System.out.println("\nInsira a opcao correta\n"
            + "\t1 - Inserir petsitter\n"
            + "\t2 - Inserir Cliente\n"
            + "\t3 - Inserir Pet\n"
            + "\t4 - Cancelar\n"
            + "\t5 - Salvar\n");
        System.out.print("Qual sua opcao: ");
    }
}