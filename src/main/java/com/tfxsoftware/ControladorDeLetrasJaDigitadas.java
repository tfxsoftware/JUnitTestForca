package com.tfxsoftware;


public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas = "";

    }

    public boolean isJaDigitada (char letra)
    {
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++){
            if (letra == this.letrasJaDigitadas.charAt(i)){
                return true;
            }
        }
        return false;

    }

    public void registre (char letra) throws Exception
    {
		if (isJaDigitada(letra)){
            throw new Exception("Letra já digitada");
        }
        else{
            this.letrasJaDigitadas = this.letrasJaDigitadas + letra;
        }
    }
    
    @Override
    public String toString ()
    {
        String letras = "";
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++){
            letras = letras + this.letrasJaDigitadas.charAt(i);
            if (i != letrasJaDigitadas.length() - 1){
                letras = letras + ",";
            }
        }
        return letras;
        

    }

    @Override
    public boolean equals (Object obj)
    {
        if (this == obj) return true;
        if (obj==null) return false;
        if (this.getClass() != obj.getClass()) return false;
        ControladorDeLetrasJaDigitadas comparador = (ControladorDeLetrasJaDigitadas) obj;
        if (this.letrasJaDigitadas != comparador.letrasJaDigitadas) return false;
        
        return true;

    }

    public int hashCode ()
    {
        int ret = 123;
        ret = ret * 7 + new String (this.letrasJaDigitadas).hashCode();
        if (ret < 0) ret=-ret;
        return ret;
    }
 
    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas c)
    throws Exception
    {
        if (c == null) throw new Exception("Erro ao clonar objeto! Clone ausente!");
        
        this.letrasJaDigitadas = c.letrasJaDigitadas;
    }

    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas novoclone = null;
    try {   
        novoclone = new ControladorDeLetrasJaDigitadas(this);
    } catch (Exception e) {e.printStackTrace();}
    
    return novoclone;
    }

}

