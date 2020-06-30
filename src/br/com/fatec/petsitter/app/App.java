package br.com.fatec.petsitter.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.com.fatec.petsitter.model.Agenda;
import br.com.fatec.petsitter.model.Animal;
import br.com.fatec.petsitter.model.Cliente;
import br.com.fatec.petsitter.model.Historic;
import br.com.fatec.petsitter.model.People;
import br.com.fatec.petsitter.model.Profissional;
import br.com.fatec.petsitter.model.Report;
import br.com.fatec.petsitter.view.Menu;
import br.com.fatec.petsitter.controller.Controle;


public class App {
	public static void main(String[] args) {
		System.out.println("[Application] Starting..");
        Menu menu = new Menu();
        Agenda agenda = Agenda.createEmpty();
        Historic historic = Historic.createEmpty();
		CreateMap cMap = new CreateMap();
		HashMap<Integer, Task> options = cMap.get();
		
		System.out.println("[Application] Started!");
		menu.inicio();
	
		while(true) {
		    menu.mainMenu();
	
		    int opcao = Controle.option();
	
		    Object cmd = options.get(opcao);
		    ((Task) cmd).command();
		}
	}

}

interface Task {
    void command();
}

class CreateMap {
    private Agenda agenda;
    private Controle ctrl;
    private Historic hist;

    public CreateMap(Agenda agenda, Controle ctrl, Historic hist) {
        this.agenda = agenda;
        this.ctrl = ctrl;
        this.hist = hist;
    }

    public HashMap<Integer, Task> get() {
        HashMap<Integer, Task> map = new HashMap<Integer, Task>();
        map.put(1, insertPetsitter());
        map.put(2, insertClient());
        map.put(3, insertPet());
        map.put(4, allocatePetSiterToClient());
        map.put(5, showReport());
        map.put(6, showAllEntries());
        map.put(7, exit());
        return map;
    }

    private Task insertPetsitter() {
        return new Task() {
            public void command() {
                Profissional petsitter = ctrl.createPetsitter();
                agenda.insertPetsitter(petsitter);
            }
        };
    }

    private Task insertClient() {
        return new Task() {
            public void command() {
                Cliente client =  ctrl.createClient();
                agenda.insertClient(client);
            }
        };
    }

    private Task insertPet() {
        return new Task() {
            public void command() {
                Animal pet = ctrl.createPet();
                System.out.print("Insira o nome do cliente dono: ");
                String clientName = Controle.texto();
                Optional<Cliente> finded = agenda.getClient(clientName);
                if (finded.isEmpty()) {
                    System.out.println("Erro: cliente não encontrado");
                    return;
                }
                finded.get().addPet(pet);
            }
        };
    }

    private Task allocatePetSiterToClient() {
        return new Task(){
        
            @Override
            public void command() {
                ctrl.allocate(hist, agenda);
            }
        };
    }

    private Task showReport() {
        return new Task() {
            public void command() {
                Report rep = Report.create(agenda);
                System.out.println(rep.getReport());
                rep.writeReportToFile();
            }
        };
    }

    private Task showAllEntries() {
        return new Task(){
            @Override
            public void command() {
                System.out.println("TODOS OS CADASTROS\n");
                System.out.println("PETSITTERS");
                for (Map.Entry<Integer, People> petsitters : agenda.getPetsitters().entrySet()) {
                        System.out.println(((Profissional)petsitters.getValue()).data());
                }
                System.out.println("CLIENTES");
                for (Map.Entry<Integer, People> clients : agenda.getClients().entrySet()) {
                    System.out.println(((Cliente)clients.getValue()).data());
                }
            }
        };
    }

    private Task exit() {
        return new Task() {
            public void command() {
                System.out.println("[Application] Finishing..");
                System.exit(0);
            }
        };
    }

}
