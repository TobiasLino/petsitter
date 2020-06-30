package br.com.fatec.petsitter.model;

import java.util.HashMap;
import java.util.Optional;

public class Agenda 
{ 
   private int idPetsitter;
   private int idClient;
   private HashMap<Integer, People> clients;
   private HashMap<Integer, People> petsitters;
   
   
   public static Agenda createEmpty() {
      Agenda agenda = new Agenda();
      agenda.idClient = 0;
      agenda.idPetsitter = 0;
      agenda.clients = new HashMap<>();
      agenda.petsitters = new HashMap<>();
      return agenda;
   }

   public int getTotalClients() {
      if (clients.size() != idClient) {
         System.out.println("[getTotalClients] Erro: por algum motivo o total de"
            + " clientes está errado, por favor verifique isso.");
         return 0;
      }
      return idClient;
   }
   public int getTotalPetsitter() {
      if (petsitters.size() != idPetsitter) {
         System.out.println("[getTotalClients] Erro: por algum motivo o total de"
            + " profissionais está errado, por favor verifique isso.");
         return 0;
      }
      return idPetsitter;
   }

   public HashMap<Integer, People> getClients() {
       return clients;
   }

   public HashMap<Integer, People> getPetsitters() {
       return petsitters;
   }

   public void insertPetsitter(Profissional petsitter) {
      if (petsitter == null) {
         System.out.println("[InserirProfissionais] Erro: o petsitter esta nulo");
         return;
      }
      idPetsitter += 1;    // id do último petsitter adicionado
      petsitters.put(idPetsitter, petsitter);
   }

   public void insertClient(Cliente client) {
      if (client == null) {
         System.out.println("[insertClient] Erro: o cliente está nulo");
         return;
      }
      idClient += 1;
      clients.put(idClient, client);
   }

   public Optional<Cliente> getClient(String name) {
      Optional<Integer> finded = getIdByName(name, clients);
      return Optional.of((Cliente)clients.get(finded.get()));
   }

   public Optional<Profissional> getPetsitter(String name) {
      Optional<Integer> finded = getIdByName(name, petsitters);
      return Optional.of((Profissional)petsitters.get(finded.get()));
   }

   public void removePetsitter(int id) {
      petsitters.remove(id);
      idPetsitter -= 1;
   }
   public void removePetsitter(String name) {
      removeByName(name, idPetsitter, petsitters);
   }

   public void removeClient(int id) {
      clients.remove(id);
      idClient -= 1;
   }
   public void removeClient(String name) {
      removeByName(name, idClient, clients);
   }

   private void removeByName(String name, int idTotal,
         HashMap<Integer, People> agenda) {
        Optional<Integer> finded = getIdByName(name, agenda);
        if (finded.isEmpty()) {
            System.out.println("Não foi encontrado nenhum cadastro com esse nome.");
            return;
        }
        agenda.remove(finded.get());
   }

   public Optional<Integer> getIdByName(String name, HashMap<Integer, People> agenda) {
        Optional<Integer> findedID = agenda.entrySet().stream()
            .filter(x -> name.equals(x.getValue().getName()))
            .map(x -> x.getKey())
            .findFirst();
        return findedID;
   }
}

  /*
  import java.util.Map.Entry;
  import java.util.TreeMap;
  private TreeMap<Double,List<String>>ranking;  
   
  public void listarRankingRacasMaisComuns()
  {
   ranking = new TreeMap<Double,List<String>>();
   //Random r = new Random();   
   System.out.println("\nRela��o do ranking de ra�as mais comuns");
   for(int i = 1;i<=10;i++)
      {
	   //int n = r.nextInt(10);
	   System.out.printf("\nObjeto:" + i,i);	   
      }	
      int i = 0;	
      for(Entry<Double,List<String>> entry:ranking.descendingMap().entrySet())   	  	
    	  System.out.println(++i + "�-" + entry.getValue());  
  }
  		
  public void listarRelatoriodeGenero() 
  {   
   int contMa = 0;
   int contFem = 0;   
   List<Animal> animais = new ArrayList<Animal>();
   //Collections.sort(animais);
   
   for(Animal animal:animais)
      {
	   if(animal.getGenero().equals("macho")) 
	    {
		 if(contMa>contFem)
	       {          
            System.out.println("Ra�a:" +animal.getRaca());
            System.out.println("G�nero:" +animal.getGenero());
            contMa++;
	       }
	    } vc
      }
      for(Animal animal:animais)
         {
	      if(animal.getGenero().equals("f�mea"))
	        {	         
	    	 if(contFem>contMa)
		       {          	
	            System.out.println("Ra�a:" +animal.getRaca());
                System.out.println("G�nero:" +animal.getGenero());
                contFem++;
		       } 
            }
	     } 
  }
  */  
//public ArrayList<Atendimento> atendimento = new ArrayList<Atendimento>(); 
//public ArrayList<DataAtend> dataatend = new ArrayList<DataAtend>();
//List<Cliente> clientes = new ArrayList<Cliente>();  

//public List<Cliente> clientes = new ArrayList<Cliente>();
//public List<Profissional> profissional = new ArrayList<Profissional>();
//public List<Animal> animais = new ArrayList<Animal>();

//int sair = 1;	

//while(sair == 1) 
//{

//System.out.println("Para continuar cadastrando digite 1 ou 0 para sair");
	//@SuppressWarnings("resource")
	//Scanner out = new Scanner(System.in);
	//sair = out.nextInt();
//} 

/*
public void inserirAnimais() 
{  
 List<Animal> animais = new ArrayList<Animal>();
 int sair = 1;
 while(sair == 1)
      {
	    if(animais.size()>=5) 
		  {
		   System.out.println("Atingiu o limite de cadastros!");
		  } 
		  else 
		     {			   
		      System.out.println("Digite o c�digo do cliente:");
		      Controle ctrl = new Controle();
		      Contato c = new Contato(ctrl.texto());		      
		      System.out.println("Digite a ra�a do animal:");
			  c.raca = ctrl.texto();
			  System.out.println("Digite o g�nero do animal:");
			  c.genero = ctrl.texto();
			  System.out.println("Digite a idade do animal:");
			  c.idade = ctrl.texto();
			  contatos.add(c);
			  System.out.println("\nAnimal cadastrado!");
			  System.out.println("Para continuar cadastrando digite 1 ou 0 para sair");
			  @SuppressWarnings("resource")
			  Scanner out = new Scanner(System.in);
		      sair = out.nextInt();   
		     }  
      }  	
 }*/


