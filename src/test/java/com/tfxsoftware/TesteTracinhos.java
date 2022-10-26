package com.tfxsoftware;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TesteTracinhos {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

        //Teste instanciar com valores inválidos
        @Test
        public void case1() throws Exception{
            thrown.expect(Exception.class);
            thrown.expectMessage("Quantidade de tracinhos inválida!");
            Tracinhos tracinhos = new Tracinhos(-1);
        }

        //Testes de métodos únicos da classe
        @Test
        public void case2() throws Exception{
    
            Tracinhos tracinhos = new Tracinhos(5);
            // tentando revelar uma letra no indice maior que o tamanho; \/
            thrown.expect(Exception.class);
            thrown.expectMessage("Posição inválida!");
            tracinhos.revele(10, 'e'); 
            // checando se tem tracinhos sem termos revelado nem uma letra \/
            assertTrue(tracinhos.isAindaComTracinhos());
            // checando se tem tracinhos apos temos revelado todos os tracinhos \/
            for (int i=0;i<5;i++){
                tracinhos.revele(i, 'e');
            }
            assertFalse(tracinhos.isAindaComTracinhos());
        }

        //Teste métodos obrigatórios
        @Test
        public void case3() throws Exception{
            Tracinhos tracinhos = new Tracinhos(5);
            tracinhos.revele(1, 'e');
            assertEquals(tracinhos.toString(), "_ e _ _ _ "); // testando método toString
            Tracinhos tracinhos1 = new Tracinhos(5);
            assertFalse(tracinhos.equals(tracinhos1)); // testando com objetos do mesmo tamanho porem com numero de letras reveladas diferentes
            tracinhos1.revele(1, 'e');
            assertTrue(tracinhos.equals(tracinhos1)); // testando com objetos iguais
            tracinhos = null;
            assertFalse(tracinhos1.equals(tracinhos)); // testando com objeto nulo
        }
        
}
