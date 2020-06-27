package br.com.fatec.petsitter.model;

public class Animal {
    public String name;
    public String raca;
    public String genero;
    public int idade;

    public static Animal create() {
        Animal pet = new Animal();
        pet.name = "";
        pet.raca = "";
        pet.genero = "";
        pet.idade = 0;
        return pet;
    }

    public String data() {
        return "\t" + name.toUpperCase() + "\n"
            + "\t\traca: " + raca + "\n"
            + "\t\tgenero: " + genero + "\n"
            + "\t\tidade: " + idade;
    }
}
