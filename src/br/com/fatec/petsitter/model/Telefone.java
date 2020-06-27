package br.com.fatec.petsitter.model;



public class Telefone 
{
 public String ddd;
 public String numero;	

    public static Telefone create() {
        Telefone phone = new Telefone();
        phone.ddd = "";
        phone.numero = "";
        return phone;
    }

    public String data() {
        return "\tTelefone: (" + ddd + ") " + numero;
    }
}