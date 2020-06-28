// By Tobias
// Primeiro contato com teste de unidade em Java
// Primeiros testes são apenas para teste de nulos

package br.com.fatec.petsitter.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;

// import org.junit.Test;
// import org.junit.Assert;

import br.com.fatec.petsitter.model.Agenda;
import br.com.fatec.petsitter.model.Cliente;

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
}
