package br.com.fatec.petsitter.model;

public class Animal {
    public String name;
    public String raca;
    public String genero;
    public int idade;

    public Animal() {
        name = "";
        raca = "";
        genero = "";
        idade = 0;
    }

    public String data() {
        return "\t" + name.toUpperCase() + "\n"
            + "\t\traca: " + raca + "\n"
            + "\t\tgenero: " + genero + "\n"
            + "\t\tidade: " + idade;
    }
}
