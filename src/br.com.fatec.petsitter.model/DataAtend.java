package PetShop;

public class DataAtend 
{
 public String dia;
 public String mes;
 public String ano;
 
 public DataAtend(String texto)
 { 
  dia = texto;
  mes = texto;
  ano = texto;
 }
 public String getDia() 
 {
  return dia;			
 }		
 public void setDia(String dia) 
 {
  this.dia = dia;			
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
}