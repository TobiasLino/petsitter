package br.com.fatec.petsitter.model;
import java.util.LinkedList;

public class Cliente extends People {
    private LinkedList<Animal> pets;

    public static Cliente create() {
        return new Cliente();
    }

    public void addPet(Animal pet) {
        if (pet == null) {
            System.out.println("Erro: Animal está nulo.");
            return;
        } else if (pets.size() >= 5) {
            System.out.println("Erro: Só é possível cadastrar cinco pets para cada cliente.");
            return;
        }
        pets.push(pet);
    }

    public void removePet(String name) {
        
    }

    public String petsData() {
        String n = new String();
        for (Animal pet : pets) {
            n += "Pet(s):\n";
            n += pet.data() + "\n";
        }
        return n;
    }
}