package com.tfxsoftware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TesteControladorDeErros {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    //Teste instanciar com valores inválidos
    @Test
    public void case1() throws Exception{
		thrown.expect(Exception.class);
		thrown.expectMessage("Quantidade maxima de erros inválida!");
        ControladorDeErros controladorDeErros = new ControladorDeErros(-1);
    }

    //Testando métodos únicos da classe
    @Test
    public void case2() throws Exception{
        ControladorDeErros controladorDeErros = new ControladorDeErros(5);
        controladorDeErros.registreUmErro();
        assertFalse(controladorDeErros.isAtingidoMaximoDeErros()); // antes de atigir a quantidade maxima
        controladorDeErros.registreUmErro();
        controladorDeErros.registreUmErro();
        controladorDeErros.registreUmErro();
        controladorDeErros.registreUmErro();
        assertTrue(controladorDeErros.isAtingidoMaximoDeErros()); // aqui já atingimos a quantidade máxima
    }

    //Testando métodos obrigatórios
    @Test
    public void case3() throws Exception{
        ControladorDeErros controladorDeErros = new ControladorDeErros(5);
        controladorDeErros.registreUmErro();
        assertEquals(new String(controladorDeErros.toString()), new String("1/5")); // checando método toString
        ControladorDeErros controladorDeErros2 = new ControladorDeErros(6);
        assertFalse(controladorDeErros.equals(controladorDeErros2)); // teste do equals com objetos diferentes
        ControladorDeErros controladorDeErros3 = new ControladorDeErros(6);
        assertTrue(controladorDeErros2.equals(controladorDeErros3)); //teste com objetos iguais
        ControladorDeErros controladorDeErros1 = null;
        controladorDeErros2.registreUmErro();
        controladorDeErros3.registreUmErro();
        assertTrue(controladorDeErros2.equals(controladorDeErros3)); // mais um teste com objetos iguais

        assertFalse(controladorDeErros3.equals(controladorDeErros1)); // teste com objeto nulo
    }
		
}

