package projetosimples;

public class Imagem {

    protected Object dado;

    protected Imagem ( Object dado ){

        this.dado = dado;

    }

    @Override

    public String toString (){

        return String.valueOf(dado);

    }

}
