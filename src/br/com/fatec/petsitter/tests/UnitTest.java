// By Tobias
// Primeiro contato com teste de unidade em Java
// Primeiros testes são apenas para teste de nulos

package br.com.fatec.petsitter.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Optional;

import org.junit.Test;

import br.com.fatec.petsitter.model.Agenda;
import br.com.fatec.petsitter.model.Animal;
import br.com.fatec.petsitter.model.Cliente;
import br.com.fatec.petsitter.model.Historic;
import br.com.fatec.petsitter.model.Profissional;
import br.com.fatec.petsitter.model.Report;

public class UnitTest {
    @Test
    public void controllerFIndID() {
        Agenda a = Agenda.createEmpty();
        Cliente c1 = Cliente.create();
        Cliente c2 = Cliente.create();
        Cliente c3 = Cliente.create();
        c1.setName("Tobias");
        c2.setName("Ana");
        c3.setName("Fabio");

        a.insertClient(c1);
        a.insertClient(c2);
        a.insertClient(c3);

        Optional<Integer> finded = a.getIdByName("Tobias", a.getClients());

        assertTrue(finded.isPresent());
        assertEquals(1, (int)finded.get());
    }

    @Test
    public void report_writeToFile_01() {
        Agenda agenda = newAgendaWithThreeClients();

        Report rep = Report.create(agenda);
        
        rep.writeReportToFile();
    }

    public Agenda newAgendaWithThreeClients() {
        Agenda agenda = Agenda.createEmpty();
        Cliente n1 = Cliente.create();
        Cliente n2 = Cliente.create();
        Cliente n3 = Cliente.create();

        Animal pet1 = Animal.create();
        Animal pet2 = Animal.create();
        Animal pet3 = Animal.create();

        pet1.raca = "salsicha";
        pet1.genero = "male";
        pet2.raca = "poodle";
        pet2.genero = "male";
        pet3.raca = "salsicha";
        pet3.genero = "male";

        n1.addPet(pet1);
        n1.addPet(pet2);
        n2.addPet(pet3);
        // n3 não possui pet

        agenda.insertClient(n1);
        agenda.insertClient(n2);
        agenda.insertClient(n3);

        return agenda;
    }

    @Test
    public void historic_01() {
        Profissional p = Profissional.create();
        Cliente c = Cliente.create();
        Animal a = Animal.create();

        p.setName("Joao");
        c.setName("Tobias");
        a.name = "gamora";
        a.raca = "vira-lata";
        a.idade = 5;
        a.genero = "female";

        Historic h = Historic.createEmpty();
        h.allocate(p, c, a);
    }
}
