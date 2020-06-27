// By Tobias
// Primeiro contato com teste de unidade em Java
// Primeiros testes são apenas para teste de nulos

package br.com.fatec.petsitter.tests;

import org.junit.Test;
import org.junit.Assert;

import br.com.fatec.petsitter.controller.Controle;
import br.com.fatec.petsitter.model.Animal;
import br.com.fatec.petsitter.model.Cliente;

public class UnitTest {
	@Test
	public void model_test_animal_01() {
		Animal n = new Animal();
		Assert.assertEquals("", n.name);
		Assert.assertEquals("", n.raca);
		Assert.assertEquals("", n.genero);
		Assert.assertEquals(0, n.idade);
	}

	@Test
	public void model_test_client_01() {
		Cliente n1 = new Cliente();
		Assert.assertNotNull(n1.getPhone());
		n1.setCPF(null);	// precisa imprimir mensagem de erro
		Assert.assertEquals("", n1.getCPF());
	}

	@Test
	public void controller_test_01() {
		Controle ctrl = new Controle();
		Cliente n1 = new Cliente();
		ctrl.edit(n1);
		Assert.assertNotNull(n1.getCPF());
	}

	@Test
	public void controller_test_02() {
		Controle ctrl = new Controle();
		Assert.assertTrue(ctrl.checkExitOptions(6));
		Assert.assertFalse(ctrl.checkExitOptions(7));
	}
}
