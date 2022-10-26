package com.tfxsoftware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TestePalavra {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    //Teste instanciar com texto inválidos
    @Test
    public void case1() throws Exception{
		thrown.expect(Exception.class);
		thrown.expectMessage("Texto inválido!");
        Palavra palavra = new Palavra("");
    }

    // Testes métodos únicos da classe
    
    @Test
    public void case2() throws Exception{
        Palavra palavra = new Palavra("TESTEAUTOMATIZADO");
        assertEquals(palavra.getTamanho(), 17); // testando tamanho
        assertEquals(palavra.getPosicaoDaIezimaOcorrencia(0, 'E'), 1); // testando posicao da primeira ocorrencia da letra 'e'
        assertEquals(palavra.getQuantidade('E'), 2); //testando quantidade de letras 'e'
        assertEquals(palavra.getQuantidade('X'), 0); //testando quantidade da letra 'X';
    }

    
    //Testes dos métodos obrigatórios
    @Test
    public void case3() throws Exception{
        Palavra palavra = new Palavra("TESTEAUTOMATIZADO");
        assertEquals(palavra.toString(), "TESTEAUTOMATIZADO"); // teste toString
        Palavra palavra2 = new Palavra("TESTEAUTOMATIZADOTESTE");
        assertFalse(palavra.equals(palavra2)); // testando com objetos diferentes
        Palavra palavra3 = new Palavra("TESTEAUTOMATIZADOTESTE");
        assertTrue(palavra2.equals(palavra3)); //testando com objetos iguais
        palavra = null;
        assertFalse(palavra2.equals(palavra)); // testando com objeto nulo


    }
}
