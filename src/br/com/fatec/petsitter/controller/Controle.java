package br.com.fatec.petsitter.controller;

import java.util.HashMap;
import java.util.Scanner;

import br.com.fatec.petsitter.model.Cliente;
import br.com.fatec.petsitter.model.People;
import br.com.fatec.petsitter.model.Profissional;
import br.com.fatec.petsitter.model.Telefone;
import br.com.fatec.petsitter.view.Menu;

public class Controle 
{
 public Scanner scanner;
	
 public Controle() 
 {
     System.out.println("[Controller] Creating new Scanner");
  scanner = new Scanner(System.in);	  
 }

 public int option() 
 {
  int op = scanner.nextInt();
  return op;
 }	

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


    public Cliente createClient() {
        Cliente novo = new Cliente();
        edit(novo);
        return novo;
    }

    public Profissional createPetsitter() {
        Profissional novo = new Profissional();
        edit(novo);
        return novo;
    }

    private void edit(People toEdit) {
        boolean exit = false;
        Menu menu = new Menu();
        HashMap<Integer, editPeople> opt = new EditPeopleOptions().get();
        while (!exit) {
            menu.insertPeople(toEdit);
            int option = this.option();

            exit = checkExitOptions(option);

            Object cmd = opt.get(option);
            ((editPeople) cmd).editPeopleData(toEdit);
        }
    }

    private boolean checkExitOptions(int option) {
        if (cancelEverything(option))
            return true;
        if (option != 7)
            return false;
        return confirm();
    }

    private boolean cancelEverything(int option) {
        return option == 6;
    }

    private boolean confirm() {
        System.out.print("Tem certeza? (S/N) : ");
        String confirm = this.texto();
        return (confirm.equals("S") || confirm.equals("s"));
    }

}

interface editPeople {
    public void editPeopleData(People people);
}

class EditPeopleOptions {
    Controle ctrl = new Controle();

    public HashMap<Integer, editPeople> get() {
        HashMap<Integer, editPeople> map = new HashMap<>();

        map.put(1, setName());
        map.put(2, setCPF());
        map.put(3, setPhone());

        return map;
    }

    private editPeople setName() {
        return new editPeople() {
            public void editPeopleData(People people) {
                System.out.print("Insira o nome: ");
                people.setName(ctrl.texto());
            }
        };
    }

    private editPeople setCPF() {
        return new editPeople() {
            public void editPeopleData(People people) {
                System.out.print("Insira o cpf: ");
                people.setCPF(ctrl.texto());
            }
        };
    }

    private editPeople setPhone() {
        return new editPeople() {
            public void editPeopleData(People people) {
                Telefone novo = new Telefone();
                System.out.print("Insira o ddd: ");
                novo.ddd = ctrl.texto();
                System.out.print("Insira o número: ");
                novo.numero = ctrl.texto();
                people.setPhone(novo);
            }
        };
    }
}