package com.tfxsoftware;
public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
		if (qtdMax <= 0){
            throw new Exception("Quantidade maxima de erros inválida!");
        }
        this.qtdMax = qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        if (this.qtdErr >= qtdMax){
            throw new Exception("Quantidade máxima de erros antigida!");
        }
        else this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        if (this.qtdErr >= qtdMax) return true;
        else return false;

    }
    @Override
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }
    
    @Override
    public boolean equals (Object obj)
    {

        if (this == obj) return true;
        if (obj==null) return false;
        if (this.getClass() != obj.getClass()) return false;
        ControladorDeErros comparador = (ControladorDeErros) obj;
        if (this.qtdErr != comparador.qtdErr) return false;
        if (this.qtdMax != comparador.qtdMax) return false;
        
        return true;
    }

    public int hashCode ()
    {
        int ret = 123;
        ret = ret * 7 + new Integer (this.qtdErr).hashCode();
        ret = ret * 7 + new Integer (this.qtdMax).hashCode();
        if (ret < 0) ret=-ret;
        return ret;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de cópia
    {
        if (c == null) throw new Exception("Erro ao clonar objeto! Clone ausente!");
        
        this.qtdMax = c.qtdMax;
        this.qtdErr = c.qtdErr;
        
    }

    public Object clone ()
    {
        ControladorDeErros novoclone = null;
        try {   
            novoclone = new ControladorDeErros(this);
        } catch (Exception e) {e.printStackTrace();}
        
        return novoclone;
    }

}

