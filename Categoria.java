package projetosimples;

public class Categoria extends Lista {

    protected String titulo;
    protected int noticiaAtual = -1;

    protected Categoria(String titulo){

        this.titulo = titulo;

    }

    protected void addNoticia ( Noticia noticia ){

        this.addData(noticia);

    }

    protected Object noticiaAtual(){

        return this.procurarData(noticiaAtual);

    }

    protected Object proximaNoticia(){

        noticiaAtual++;
        return this.procurarData(noticiaAtual);

    }

    protected Object anteriorNoticia(){

        noticiaAtual--;
        return this.procurarData(noticiaAtual);

    }

    protected void removerNoticia(){

        this.removeData(noticiaAtual);
        noticiaAtual = -1;

    }

    protected void resetNoticiaAtual(){

        this.noticiaAtual = -1;

    }

    @Override

    public String toString (){

        return String.valueOf(titulo);

    }
}