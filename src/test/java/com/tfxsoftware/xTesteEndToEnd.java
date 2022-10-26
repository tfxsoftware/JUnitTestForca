package com.tfxsoftware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class xTesteEndToEnd 
{

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    //neste caso o jogador ganha o jogo apenas digitando letras certas
    @Test
    public void caseJogadorGanhaOJogo() throws Exception
    {
        Palavra palavra = new Palavra("TESTE");
        Tracinhos tracinhos = new Tracinhos(palavra.getTamanho());
        ControladorDeLetrasJaDigitadas letras = new ControladorDeLetrasJaDigitadas();
        ControladorDeErros erros = new ControladorDeErros((int) (palavra.getTamanho()*0.6));
        
        char primeiraLetraDigitada = 'E'; // "digitando" a primeira letra e fazendo as devidas verificaçoes!
        
        if (!letras.isJaDigitada(primeiraLetraDigitada)){
            letras.registre(primeiraLetraDigitada);
            int qtd = palavra.getQuantidade(primeiraLetraDigitada);
            if (qtd == 0){
                erros.registreUmErro();
            }
            else {
                for (int i=0; i<qtd; i++){
					int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,primeiraLetraDigitada);
					tracinhos.revele (posicao, primeiraLetraDigitada);
                }
            }
        }

        assertEquals(tracinhos.toString(), "_ E _ _ E "); // a nossa forca deve estar assim após termos digitado a letra 'e'

        char segundaLetraDigitada = 'T'; // "digitando" a segunda letra e fazendo as devidas verificaçoes!

        if (!erros.isAtingidoMaximoDeErros() && tracinhos.isAindaComTracinhos()){
           
            if (!letras.isJaDigitada(segundaLetraDigitada)){
                letras.registre(segundaLetraDigitada);
                int qtd = palavra.getQuantidade(segundaLetraDigitada);
                if (qtd == 0){
                    erros.registreUmErro();
                }
                else {
                    for (int i=0; i<qtd; i++){
                        int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,segundaLetraDigitada);
                        tracinhos.revele (posicao, segundaLetraDigitada);
                    }
                }
            }
        }

        assertEquals(tracinhos.toString(), "T E _ T E "); // a nossa forca deve estar assim após termos digitado a letra 't'

        char terceiraLetraDigitada = 'S'; // "digitando" a terceira letra e fazendo as devidas verificaçoes!

        if (!erros.isAtingidoMaximoDeErros() && tracinhos.isAindaComTracinhos()){
           
            if (!letras.isJaDigitada(terceiraLetraDigitada)){
                letras.registre(terceiraLetraDigitada);
                int qtd = palavra.getQuantidade(terceiraLetraDigitada);
                if (qtd == 0){
                    erros.registreUmErro();
                }
                else {
                    for (int i=0; i<qtd; i++){
                        int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,terceiraLetraDigitada);
                        tracinhos.revele (posicao, terceiraLetraDigitada);
                    }
                }
            }
        }

        assertEquals(tracinhos.toString(), "T E S T E "); // a nossa forca deve estar assim após termos digitado a letra 's'
        
        assertFalse(tracinhos.isAindaComTracinhos()); // se essa condição for falsa siguinifica que ganhamos o jogo! pois nao ha mais tracinhos no vetor
    }

    @Test
    public void caseJogadorPerdeOJogo() throws Exception{
        Palavra palavra = new Palavra("TESTE");
        Tracinhos tracinhos = new Tracinhos(palavra.getTamanho());
        ControladorDeLetrasJaDigitadas letras = new ControladorDeLetrasJaDigitadas();
        ControladorDeErros erros = new ControladorDeErros((int) (palavra.getTamanho()*0.6));

        char primeiraLetraDigitada = 'X'; // "digitando" a primeira letra e fazendo as devidas verificaçoes!
        
        if (!letras.isJaDigitada(primeiraLetraDigitada)){
            letras.registre(primeiraLetraDigitada);
            int qtd = palavra.getQuantidade(primeiraLetraDigitada);
            if (qtd == 0){
                erros.registreUmErro();
            }
            else {
                for (int i=0; i<qtd; i++){
					int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,primeiraLetraDigitada);
					tracinhos.revele (posicao, primeiraLetraDigitada);
                }
            }
        }
        
        assertEquals(tracinhos.toString(), "_ _ _ _ _ "); // a nossa forca deve estar assim após termos digitado a letra 'X'

        char segundaLetraDigitada = 'Z'; // "digitando" a segunda letra e fazendo as devidas verificaçoes!

        if (!erros.isAtingidoMaximoDeErros() && tracinhos.isAindaComTracinhos()){
           
            if (!letras.isJaDigitada(segundaLetraDigitada)){
                letras.registre(segundaLetraDigitada);
                int qtd = palavra.getQuantidade(segundaLetraDigitada);
                if (qtd == 0){
                    erros.registreUmErro();
                }
                else {
                    for (int i=0; i<qtd; i++){
                        int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,segundaLetraDigitada);
                        tracinhos.revele (posicao, segundaLetraDigitada);
                    }
                }
            }
        }

        assertEquals(tracinhos.toString(), "_ _ _ _ _ "); // a nossa forca deve estar assim após termos digitado a letra 'Z'

        char terceiraLetraDigitada = 'Y'; // "digitando" a terceira letra e fazendo as devidas verificaçoes!

        if (!erros.isAtingidoMaximoDeErros() && tracinhos.isAindaComTracinhos()){
           
            if (!letras.isJaDigitada(terceiraLetraDigitada)){
                letras.registre(terceiraLetraDigitada);
                int qtd = palavra.getQuantidade(terceiraLetraDigitada);
                if (qtd == 0){
                    erros.registreUmErro();
                }
                else {
                    for (int i=0; i<qtd; i++){
                        int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,terceiraLetraDigitada);
                        tracinhos.revele (posicao, terceiraLetraDigitada);
                    }
                }
            }
        }
        else{
            assertTrue(erros.isAtingidoMaximoDeErros()); // se entramos nesse else, entao quer dizer que atingimos o máximo de erros 3 (que é o tamanho da palavra * 0.6 arredondado)
        }                                                // portanto, perdemos o jogo   
        assertEquals(tracinhos.toString(), "_ _ _ _ _ "); // a nossa forca deve estar assim após termos digitado a letra 'Y'
    }

    //Neste caso iremos tentar instanciar uma palavra com tamanho 0
    @Test
    public void casePalavraTamanhoZero() throws Exception{
        thrown.expect(Exception.class);
		thrown.expectMessage("Texto inválido!"); // Este tipo de exceção está prevista e tratada, devendo retornar "Texto Inválido!"
        Palavra palavra = new Palavra("");
    }

    // Neste caso testaremos o jogo sem que ninguem entre com letras repetidas
    @Test
    public void caseSemLetrasRepetidas() throws Exception{
        caseJogadorGanhaOJogo(); // Ambos estes cases já testaram o não repetimento de letras
        caseJogadorPerdeOJogo();
    }

    
    //Neste caso testaremos uma partida de vitória igual o primeiro case, porém o jogador entra 2 vezes com a letra 'e'
    @Test
    public void caseComLetrasRepetidas() throws Exception{
        Palavra palavra = new Palavra("TESTE");
        Tracinhos tracinhos = new Tracinhos(palavra.getTamanho());
        ControladorDeLetrasJaDigitadas letras = new ControladorDeLetrasJaDigitadas();
        ControladorDeErros erros = new ControladorDeErros((int) (palavra.getTamanho()*0.6));
        
        char primeiraLetraDigitada = 'E'; // "digitando" a primeira letra e fazendo as devidas verificaçoes!
        
        if (!letras.isJaDigitada(primeiraLetraDigitada)){
            letras.registre(primeiraLetraDigitada);
            int qtd = palavra.getQuantidade(primeiraLetraDigitada);
            if (qtd == 0){
                erros.registreUmErro();
            }
            else {
                for (int i=0; i<qtd; i++){
					int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,primeiraLetraDigitada);
					tracinhos.revele (posicao, primeiraLetraDigitada);
                }
            }
        }

        assertEquals(tracinhos.toString(), "_ E _ _ E "); // a nossa forca deve estar assim após termos digitado a letra 'e'

        char segundaLetraDigitada = 'T'; // "digitando" a segunda letra e fazendo as devidas verificaçoes!

        if (!erros.isAtingidoMaximoDeErros() && tracinhos.isAindaComTracinhos()){
           
            if (!letras.isJaDigitada(segundaLetraDigitada)){
                letras.registre(segundaLetraDigitada);
                int qtd = palavra.getQuantidade(segundaLetraDigitada);
                if (qtd == 0){
                    erros.registreUmErro();
                }
                else {
                    for (int i=0; i<qtd; i++){
                        int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,segundaLetraDigitada);
                        tracinhos.revele (posicao, segundaLetraDigitada);
                    }
                }
            }
        }

        assertEquals(tracinhos.toString(), "T E _ T E "); // a nossa forca deve estar assim após termos digitado a letra 't'

        char terceiraLetraDigitada = 'E'; // "digitando" novamente a letra 'e'!
        
        assertTrue(letras.isJaDigitada(terceiraLetraDigitada)); // verificando se o jogo reconheceu que esta letra realmente ja foi digitada!
        
        if (!letras.isJaDigitada(terceiraLetraDigitada)){
            letras.registre(terceiraLetraDigitada);
            int qtd = palavra.getQuantidade(terceiraLetraDigitada);
            if (qtd == 0){
                erros.registreUmErro();
            }
            else {
                for (int i=0; i<qtd; i++){
					int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,terceiraLetraDigitada);
					tracinhos.revele (posicao, terceiraLetraDigitada);
                }
            }
        }
        
        assertEquals(tracinhos.toString(), "T E _ T E "); // a nossa forca deve estar assim após termos digitado novamente a letra "e", nada mudou!
        
        char quartaLetraDigitada = 'S'; // "digitando" a terceira letra e fazendo as devidas verificaçoes!

        if (!erros.isAtingidoMaximoDeErros() && tracinhos.isAindaComTracinhos()){
           
            if (!letras.isJaDigitada(quartaLetraDigitada)){
                letras.registre(quartaLetraDigitada);
                int qtd = palavra.getQuantidade(quartaLetraDigitada);
                if (qtd == 0){
                    erros.registreUmErro();
                }
                else {
                    for (int i=0; i<qtd; i++){
                        int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,quartaLetraDigitada);
                        tracinhos.revele (posicao, quartaLetraDigitada);
                    }
                }
            }
        }

        assertEquals(tracinhos.toString(), "T E S T E "); // a nossa forca deve estar assim após termos digitado a letra 's'
        
        assertFalse(tracinhos.isAindaComTracinhos()); // se essa condição for falsa siguinifica que ganhamos o jogo! pois nao ha mais tracinhos no vetor
    }


}


