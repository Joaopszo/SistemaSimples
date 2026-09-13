package projetosimples;

public class SistemaNoticias extends Lista {

    protected int categoriaAtual = -1;

    protected void addCategoria ( Categoria categoria ){

        this.addData(categoria);

    }

    protected Object categoriaAtual(){

        return this.procurarData(categoriaAtual);

    }

    protected Object proximaCategoria(){

        categoriaAtual++;
        return this.procurarData(categoriaAtual);

    }

    protected Object anteriorCategoria(){

        categoriaAtual--;
        return this.procurarData(categoriaAtual);

    }

    protected void removerCategoria(){

        this.removeData(categoriaAtual);
        categoriaAtual = -1;

    }
}
