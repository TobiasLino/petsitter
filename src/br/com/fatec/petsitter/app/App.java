package br.com.fatec.petsitter.app;

import br.com.fatec.petsitter.model.Agenda;
import br.com.fatec.petsitter.view.Menu;
import br.com.fatec.petsitter.controller.Controle;


import java.util.HashMap;

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
        map.put(1, new Task() {
            public void command() {
            	System.out.println("Inserir petsitter");
            }
        });
        map.put(2, new Task() {
            public void command() {
            	System.out.println("Inserir cliente");
            }
        });
        map.put(5, new Task() {
            public void command() {
            	System.out.println("Histórico");
            }
        });
        map.put(6, new Task() {
            public void command() {
                System.out.println("[Application] Finishing..");
                System.exit(0);
            }
        });
        return map;
    }
}
