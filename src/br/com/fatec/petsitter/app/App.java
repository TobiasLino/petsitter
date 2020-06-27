package br.com.fatec.petsitter.app;

import java.util.HashMap;

import br.com.fatec.petsitter.model.Agenda;
import br.com.fatec.petsitter.view.Menu;
import br.com.fatec.petsitter.controller.Controle;


public class App {
	public static void main(String[] args) {
		System.out.println("[Application] Starting..");
		Menu menu = new Menu();
		Controle ctrl = new Controle();
		CreateMap cMap = new CreateMap();
		HashMap<Integer, Task> options = cMap.get();
		
		System.out.println("[Application] Started!");
		menu.inicio();
	
		while(true) {
		    menu.mainMenu();
	
		    int opcao = ctrl.option();
	
		    Object cmd = options.get(opcao);
		    ((Task) cmd).command();
		}
	}

}

interface Task {
    void command();
}

class CreateMap {
    private static Agenda ag = new Agenda();

    public HashMap<Integer, Task> get() {
        HashMap<Integer, Task> map = new HashMap<Integer, Task>();
        map.put(1, insertPetsitter());
        map.put(2, insertClient());
        map.put(5, showHistoric());
        map.put(6, exit());
        return map;
    }

    private Task insertPetsitter() {
        return new Task() {
            public void command() {
            	System.out.println("Inserir petsitter");
            }
        };
    }

    private Task insertClient() {
        return new Task() {
            public void command() {
            	System.out.println("Inserir cliente");
            }
        };
    }

    private Task showHistoric() {
        return new Task() {
            public void command() {
            	System.out.println("Hist�rico");
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
