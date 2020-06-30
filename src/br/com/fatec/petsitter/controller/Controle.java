package br.com.fatec.petsitter.controller;

import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

import br.com.fatec.petsitter.model.Agenda;
import br.com.fatec.petsitter.model.Animal;
import br.com.fatec.petsitter.model.Cliente;
import br.com.fatec.petsitter.model.Historic;
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

interface allocator {
    public void allocate(Agenda agenda, Object[] list);
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
        AnimalDataEditor aDataEditor = new AnimalDataEditor();
        aDataEditor.edit(novo);
        return novo;
    }

    public void editClient(Agenda agenda) {
        PeopleDataEditor pDataEditor = new PeopleDataEditor();
        System.out.print("Digite o Nome do Cliente: ");
        String clientName = Controle.texto();
        Optional<Cliente> finded = agenda.getClient(clientName);
        if (finded.isEmpty()) {
            System.out.println("Erro: cliente não encontrado");
            return;
        }
        pDataEditor.edit(finded.get());
    }

    public void editPetsitter(Agenda agenda) {
        PeopleDataEditor pDataEditor = new PeopleDataEditor();
        System.out.print("Digite o Nome do Petsitter: ");
        String petsitterName = Controle.texto();
        Optional<Profissional> finded = agenda.getPetsitter(petsitterName);
        if (finded.isEmpty()) {
            System.out.println("Erro: petsitter não encontrado");
            return;
        }
        pDataEditor.edit(finded.get());
    }

    public void allocate(Historic hist, Agenda agenda) {
        Allocate allocate = new Allocate();
        Object[] list = allocate.allocate(agenda);
        hist.allocate((Profissional)list[0], (Cliente)list[1], (Animal)list[2]);
    }

    class PeopleDataEditor {

        public void edit(People toEdit) {
            boolean exit = false;
            Menu menu = new Menu();
            HashMap<Integer, editPeople> opt = new EditPeopleOptions().get();
            CheckExitOption cOption = new CheckExitOption(6,7);
            while (!exit) {
                menu.insertPeople(toEdit);
                int option = Controle.option();
                
                exit = cOption.check(option);
    
                Object cmd = opt.get(option);
                ((editPeople) cmd).editPeopleData(toEdit);
            }
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
            CheckExitOption cOption = new CheckExitOption(5, 6);
            while (!exit) {
                menu.editPet(pet);;
                int option = Controle.option();
                
                exit = cOption.check(option);
    
                Object cmd = opt.get(option);
                ((editAnimal) cmd).editAnimalData(pet);
            }
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

    class Allocate {
        public Object[] allocate(Agenda agenda) {
            boolean exit = false;
            Menu menu = new Menu();
            Object[] list = createStandardNotNullList();
            HashMap<Integer, allocator> opt = new AllocateOptions().get();
            CheckExitOption cOption = new CheckExitOption(4, 5);
            while (!exit) {
                menu.allocate(list);
                int option = Controle.option();
                
                exit = cOption.check(option);
    
                Object cmd = opt.get(option);
                ((allocator)cmd).allocate(agenda, list);
            }
            return list;
        }
        

        public Object[] createStandardNotNullList() {
            Object[] list = new Object[3];
            list[0] = Profissional.create();
            list[1] = Cliente.create();
            list[2] = Animal.create();
            return list;
        }

        class AllocateOptions {
        
            public HashMap<Integer, allocator> get() {
                HashMap<Integer, allocator> map = new HashMap<>();
        
                map.put(1, setPetsitter());
                map.put(2, setClient());
                map.put(3, setPet());
        
                return map;
            }
        
            private allocator setPetsitter() {
                return new allocator(){
                    @Override
                    public void allocate(Agenda agenda, Object[] list) {
                        System.out.print("Digite o Nome do Petsitter: ");
                        String petsitterName = Controle.texto();
                        Optional<Profissional> finded = agenda.getPetsitter(petsitterName);
                        if (finded.isEmpty()) {
                            System.out.println("Erro: petsitter não encontrado");
                            return;
                        }
                        list[0] = finded.get();
                    }
                };
            }
            private allocator setClient() {
                return new allocator(){
                    @Override
                    public void allocate(Agenda agenda, Object[] list) {
                        System.out.print("Digite o Nome do Cliente: ");
                        String clientName = Controle.texto();
                        Optional<Cliente> finded = agenda.getClient(clientName);
                        if (finded.isEmpty()) {
                            System.out.println("Erro: cliente não encontrado");
                            return;
                        }
                        list[1] = finded.get();
                    }
                };
            }
            private allocator setPet() {
                return new allocator(){
                    @Override
                    public void allocate(Agenda agenda, Object[] list) {
                        System.out.print("Digite o Nome do Pet: ");
                        String petName = Controle.texto();
                        Optional<Animal> finded = ((Cliente)list[1]).getPets().stream()
                            .filter(x -> x.name.equals(petName))
                            .findFirst();
                        if (finded.isEmpty()) {
                            System.out.println("Erro: pet não encontrado");
                            return;
                        }
                        list[2] = finded.get();
                    }
                };
            }
        }
    }

    class CheckExitOption {
        private int saveOption, cancelOption;

        public CheckExitOption(int cancel, int save) {
            saveOption = save;
            cancelOption = cancel;
        }

        private boolean check(int option) {
            if (cancelEverything(option))
                return true;
            if (option != saveOption)
                return false;
            return confirm();
        }
    
        private boolean cancelEverything(int option) {
            return option == cancelOption;
        }
    
        private boolean confirm() {
            System.out.print("Tem certeza? (S/N) : ");
            String confirm = Controle.texto();
            return (confirm.equals("S")
                    || confirm.equals("s")
                    || confirm.equals(""));
        }
    }
}
