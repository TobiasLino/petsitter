package br.com.fatec.petsitter.model;



public class Telefone 
{
 public String ddd;
 public String numero;	

    public String data() {
        return "\tTelefone: (" + ddd + ") " + numero;
    }
}