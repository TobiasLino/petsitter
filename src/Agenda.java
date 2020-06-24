import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Agenda 
{ 
   public List<Contato> contatos = new ArrayList<Contato>(); 
   
   public Agenda() {
      System.out.println("[Agenda] Creating new Agenda.");
   }

   // TODO(Tobias): transfer interface to Menu

   public void inserirProfissionais()
 {
  int sair = 1;
  while(sair == 1) 
	   {
	    System.out.println("Entre com o nome do profissional:");	    
        Controle ctrl = new Controle();        
        Contato c = new Contato(ctrl.texto());        
        System.out.println("Entre com o CPF:");
        c.cpf = ctrl.texto();
        System.out.println("Entre com o endere�o:");
        c.endereco = ctrl.texto();
        System.out.println("Entre com o DDD para contato:");	
        c.ddd = ctrl.texto();
        System.out.println("Entre com o numero para contato:");
        c.numero = ctrl.texto();
        contatos.add(c);
        System.out.println("\nProfissional cadastrado!");
        System.out.println("Para continuar cadastrando digite 1 ou 0 para sair");
    	@SuppressWarnings("resource")
    	Scanner out = new Scanner(System.in);
    	sair = out.nextInt();
	   }  
 } 

 // TODO(Tobias): transfer interface to Menu
 // look at the size of this function!

 public void inserirClientes() 
 {
  int sair = 1;
  while(sair == 1)
  {
   System.out.println("Digite o c�digo do cliente:");
   Controle ctrl = new Controle();
   Contato c = new Contato(ctrl.texto());    
   System.out.println("Entre com o nome do cliente:");
   c.nomecliente = ctrl.texto(); 
   System.out.println("Entre com o dia do atendimento:");
   c.data = ctrl.texto();
   System.out.println("Entre com o mes:");
   c.mes = ctrl.texto();
   System.out.println("Entre com o ano:");
   c.ano = ctrl.texto();	    
   System.out.println("Entre com o CPF:");
   c.cpf = ctrl.texto();
   System.out.println("Entre com o endere�o:");
   c.endereco = ctrl.texto();
   System.out.println("Entre com o DDD para contato:");
   c.ddd = ctrl.texto();
   System.out.println("Entre com o numero para contato:");
   c.numero = ctrl.texto();
   if(contatos.size()>=5) 
	  {
	   System.out.println("Atingiu o limite de cadastros!");
	  } 
	  else 
	     {
		  System.out.println("Digite a ra�a do animal:");
		  c.raca = ctrl.texto();
		  System.out.println("Digite o g�nero do animal:");
		  c.genero = ctrl.texto();
		  System.out.println("Digite a idade do animal:");
		  c.idade = ctrl.texto();
		  contatos.add(c);
		  System.out.println("\nAnimal e cliente cadastrados!");
		  System.out.println("Para continuar cadastrando digite 1 ou 0 para sair");
		  @SuppressWarnings("resource")
		  Scanner out = new Scanner(System.in);
	      sair = out.nextInt();		  
	     }            
  }  	    
 } 

 // TODO(Tobias): need refatoration

 public void exibirHistorico()
 {
  Collections.sort(contatos);    
  System.out.println("\t\tHist�rico de Atendimentos");  
  for(Contato contato: contatos) 
	 {  
	  //System.out.println("Nome do Petsitter: " + contato.getNomePetsitter());
	  System.out.println("Nome do Cliente: " + contato.getNomeCliente());
	  System.out.println("Data de Atendimento: " + contato.getData()+"/"+ contato.getMes()+"/"+contato.getAno());	  
	  System.out.println("Ra�a: " + contato.getRaca());
	  System.out.println("\n");	 
	 }   	  
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


