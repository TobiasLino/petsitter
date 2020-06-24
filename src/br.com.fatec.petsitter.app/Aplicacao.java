package PetShop;

import java.util.HashMap;

public class Aplicacao 
{
 public static void main(String[] args) throws Exception 
 {
  System.out.println("[Application] Starting..");
  Menu menu = new Menu();
  Controle ctrl = new Controle();
  CreateMap cMap = new CreateMap();
  HashMap<Integer, Task> options = cMap.get();

  System.out.println("[Application] Started!");
  menu.inicio();

  while(true) {
      menu.mainMenu();

      int opcao = ctrl.opcao();

      Object cmd = options.get(opcao);
      ((Task) cmd).command();
 }	
}


// Changed by TobiasLino
interface Task {
    void command();
}

class CreateMap {
    private static Agenda ag = new Agenda();

    public HashMap<Integer, Task> get() {
        HashMap<Integer, Task> map = new HashMap<Integer, Task>();
        map.put(1, new Task() {
            public void command() {
                ag.inserirProfissionais();
            }
        });
        map.put(2, new Task() {
            public void command() {
                ag.inserirClientes();
            }
        });
        map.put(5, new Task() {
            public void command() {
                ag.exibirHistorico();
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
}}
