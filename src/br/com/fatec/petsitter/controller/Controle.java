package br.com.fatec.petsitter.controller;

import java.util.HashMap;
import java.util.Scanner;

import br.com.fatec.petsitter.model.Animal;
import br.com.fatec.petsitter.model.Cliente;
import br.com.fatec.petsitter.model.People;
import br.com.fatec.petsitter.model.Profissional;
import br.com.fatec.petsitter.model.Telefone;
import br.com.fatec.petsitter.view.Menu;

// Interface utilizada poara realizar as opções por interface.
interface editPeople {
    public void editPeopleData(People people);
}

interface editAnimal {
    public void editAnimalData(Animal pet);
}

public class Controle 
{
 public static Scanner scanner;
	
 public static Controle create() 
 {
    Controle ctrl = new Controle();
  Controle.scanner = new Scanner(System.in);
  return ctrl;  
 }

 public static int option() 
 {
  int op = scanner.nextInt();
  return op;
 }	

 public static String texto()
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
        PeopleDataEditor pDataEditor = new PeopleDataEditor();
        pDataEditor.edit(novo);
        return novo;
    }

    public Profissional createPetsitter() {
        Profissional novo = new Profissional();
        PeopleDataEditor pDataEditor = new PeopleDataEditor();
        pDataEditor.edit(novo);
        return novo;
    }

    public Animal createPet() {
        Animal novo = new Animal();

        return novo;
    }

    class PeopleDataEditor {
        public void edit(People toEdit) {
            boolean exit = false;
            Menu menu = new Menu();
            HashMap<Integer, editPeople> opt = new EditPeopleOptions().get();
            while (!exit) {
                menu.insertPeople(toEdit);
                int option = Controle.option();
    
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
            String confirm = Controle.texto();
            return (confirm.equals("S")
                    || confirm.equals("s")
                    || confirm.equals(""));
        }

        class EditPeopleOptions {
        
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
                        people.setName(Controle.texto());
                    }
                };
            }
        
            private editPeople setCPF() {
                return new editPeople() {
                    public void editPeopleData(People people) {
                        System.out.print("Insira o cpf: ");
                        people.setCPF(Controle.texto());
                    }
                };
            }
        
            private editPeople setPhone() {
                return new editPeople() {
                    public void editPeopleData(People people) {
                        Telefone novo = new Telefone();
                        System.out.print("Insira o ddd: ");
                        novo.ddd = Controle.texto();
                        System.out.print("Insira o número: ");
                        novo.numero = Controle.texto();
                        people.setPhone(novo);
                    }
                };
            }
        }
    }

    class AnimalDataEditor {
        public void edit(Animal pet) {
            boolean exit = false;
            Menu menu = new Menu();
            HashMap<Integer, editAnimal> opt = new EditAnimalOptions().get();
            while (!exit) {
                menu.editPet(pet);;
                int option = Controle.option();
    
                exit = checkExitOptions(option);
    
                Object cmd = opt.get(option);
                ((editAnimal) cmd).editAnimalData(pet);
            }
        }
    
        private boolean checkExitOptions(int option) {
            if (cancelEverything(option))
                return true;
            if (option != 6)
                return false;
            return confirm();
        }
    
        private boolean cancelEverything(int option) {
            return option == 5;
        }
    
        private boolean confirm() {
            System.out.print("Tem certeza? (S/N) : ");
            String confirm = Controle.texto();
            return (confirm.equals("S")
                    || confirm.equals("s")
                    || confirm.equals(""));
        }

        class EditAnimalOptions {
        
            public HashMap<Integer, editAnimal> get() {
                HashMap<Integer, editAnimal> map = new HashMap<>();
        
                map.put(1, setName());
                map.put(2, setBreed());
                map.put(3, setGender());
                map.put(4, setAge());
        
                return map;
            }
        
            private editAnimal setName() {
                return new editAnimal() {
                    public void editAnimalData(Animal pet) {
                        System.out.print("Insira o nome: ");
                        pet.name = Controle.texto();
                    }
                };
            }
        
            private editAnimal setBreed() {
                return new editAnimal() {
                    public void editAnimalData(Animal pet) {
                        System.out.print("Insira a raca: ");
                        pet.raca = Controle.texto();
                    }
                };
            }
        
            private editAnimal setGender() {
                return new editAnimal() {
                    public void editAnimalData(Animal pet) {
                        System.out.print("Insira o genero: (M/F): ");
                        String gender = Controle.texto();
                        if (gender.equals("m") || gender.equals("M")) {
                            pet.genero = "male";
                        } else if (gender.equals("f") || gender.equals("F")) {
                            pet.genero = "female";
                        } else {
                            System.out.println("Insira um valor válido.");
                        }
                    }
                };
            }
            private editAnimal setAge() {
                return new editAnimal() {
                    public void editAnimalData(Animal pet) {
                        System.out.print("Insira a idade: ");
                        pet.idade = Controle.option();
                    }
                };
            }
        }
    }

    
}


