package com.tfxsoftware;


public class Tracinhos implements Cloneable
{
    private char[] texto;
    private int qtd;

    public Tracinhos (int qtd) throws Exception
    {
		if (qtd <= 0){
            throw new Exception("Quantidade de tracinhos inválida!");
        }
        this.qtd = qtd;
        this.texto = new char[this.qtd];
        for (int i=0;i<qtd;i++){
            texto[i] = '_';
        }

    }

    public void revele (int posicao, char letra) throws Exception
    {
		if (posicao < 0 || posicao >= this.texto.length){
            throw new Exception("Posição inválida!");
        }
        this.texto[posicao] = letra;

    }

    public boolean isAindaComTracinhos ()
    {
        for (int i=0;i<this.texto.length;i++){
            if (this.texto[i] == '_'){
                return true;
            }
        
        }
        return false;
        
    }
    
    @Override
    public String toString ()
    {
        String caracteres = "";
        for (int i=0;i<this.texto.length;i++){
            caracteres = caracteres + this.texto[i] + " ";
        }
        return caracteres;

    }

    @Override
    public boolean equals (Object obj)
    {
        if (this == obj) return true;
        if (obj==null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Tracinhos comparador = (Tracinhos) obj;
        for (int i = 0;i<this.qtd;i++){
            if (this.texto[i] != comparador.texto[i]) return false;
        }
        
        return true;
    }

    public int hashCode ()
    {
        int ret = 123;
        if (this.texto != null) ret = ret * 7 + this.texto.hashCode();
        if (ret < 0) ret=-ret;
        return ret;
    }
 
    public Tracinhos (Tracinhos t) throws Exception 
    {
        if (t == null) throw new Exception("Erro ao clonar objeto! Clone ausente!");
        
        this.texto = t.texto;
        this.qtd = t.qtd;

    }

    public Object clone (){
    Tracinhos novoclone = null;
    try {   
        novoclone = new Tracinhos(this);
    } catch (Exception e) {e.printStackTrace();}
    
    return novoclone;

}
}


