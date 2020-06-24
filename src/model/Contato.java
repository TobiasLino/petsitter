package PetShop;

// TODO(Tobias): need refatoration
// The code has getters and setters, but all attributes are public

public class Contato implements Comparable<Contato> 
{	
 public String codcliente;
 public String nomecliente;
 public String nomepetsitter;
 public String ddd;
 public String numero;
 public String endereco;
 public String data;
 public String mes;
 public String ano;
 public String cpf;
 public String raca;
 public String genero;
 public String idade;

 @Override
 public int compareTo(Contato o) 
 {
  return nomecliente.compareTo(o.nomecliente);
 }

 // TODO(Tobias): need refatoration
 // remove 'texto' from constructor parameters

 public Contato(String texto)
 {
    System.out.println("[Contato] Creating new Contact.");
  nomecliente = texto;
  nomepetsitter = texto;
  endereco = texto;
  ddd = texto;
  numero = texto;
  data = texto;
  mes = texto;
  ano = texto;
  cpf = texto;
  genero = texto;  
  raca = texto;
  idade = texto;
 }

 public String getNomeCliente() 
 {
  return nomecliente;			
 }		
 public void setNomeCliente(String nomecliente) 
 {
  this.nomecliente = nomecliente;			
 } 
 public String getNomePetsitter() 
 {
  return nomepetsitter;			
 }		
 public void setNomePetsitter(String nomepetsitter) 
 {
  this.nomepetsitter = nomepetsitter;			
 } 
 public String getEndereco() 
 {
  return endereco;			
 }		
 public void setEndereco(String endereco) 
 {
  this.endereco = endereco;			
 }
 public String getDDD()
 {
  return ddd; 
 } 
 public void setDDD(String ddd)
 {
  this.ddd = ddd;	 
 }	 
 public String getNumero()
 {
  return numero; 
 } 
 public void setNumero(String numero)
 {
  this.numero = numero;	 
 }	 
 public String getData()
 {
  return data; 
 } 
 public void setData(String data)
 {
  this.data = data;	 
 }	 
 public String getMes()
 {
  return mes; 
 } 
 public void setMes(String mes)
 {
  this.mes = mes;	 
 }	 
 public String getAno()
 {
  return ano;	 
 }
 public void setAno(String ano)
 {
  this.ano = ano;	 
 }	 
 public String getCPF()
 {
  return cpf;	 
 }
 public void setCPF(String cpf)
 {
  this.cpf = cpf;	 
 }	 
 public String getRaca()
 {
  return raca;	 
 }
 public void setRaca(String raca)
 {
  this.raca = raca;	 
 }	 	 
 public String getGenero()
 {
  return genero;	 
 }
 public void setGenero(String genero)
 {
  this.genero = genero;	 
 }
 public String getIdade()
 {
  return idade;	 
 }
 public void setIdade(String idade)
 {
  this.idade = idade;	 
 } 
}