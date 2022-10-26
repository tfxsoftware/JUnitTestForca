package com.tfxsoftware;



public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		if (texto == null || texto == ""){
            throw new Exception("Texto inválido!");
        }
        this.texto = texto;

    }

    public int getQuantidade (char letra)
    {
        int quantidade = 0;    
        for (int i = 0; i < this.texto.length(); i++){
            if(this.texto.charAt(i)== letra){
                quantidade++;
            }
        }
        return quantidade;
        

        
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        int posicao = -1;
        int contador = 0;
        for (int index = 0; index < this.texto.length(); index++){
            if(this.texto.charAt(index)== letra){
                if (i==contador){
                    posicao = index;
                    return posicao;
                }
                else{
                    contador++;
                }
            }
        }
        if (posicao == -1){
            throw new Exception("letra nao existe na ocorrencia selecionada");
        }
        return posicao;

    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }
    
    @Override
    public boolean equals (Object obj)
    {
        if (this == obj) return true;
        if (obj==null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Palavra comparador = (Palavra) obj;
        if (this.texto != comparador.texto) return false;
        
        return true;

    }

    public int hashCode ()
    {
        int ret = 123;
        ret = ret * 7 + new String (this.texto).hashCode();
        if (ret < 0) ret=-ret;
        return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }

}
