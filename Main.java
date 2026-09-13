package projetosimples;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        SistemaNoticias sistema = new SistemaNoticias();
        Categoria categoriaAtual = null;
        Noticia noticiaAtual = null;
        Imagem imagemAtual = null;

        int opcao;

        do {

            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {

                case 1:
                    System.out.print("\n  Titulo da categoria: ");
                    sistema.addCategoria(new Categoria(scanner.nextLine()));
                    System.out.println("  [OK] Categoria adicionada com sucesso.");
                    break;

                case 2:
                    try {
                        categoriaAtual = (Categoria) sistema.proximaCategoria();
                        categoriaAtual.resetNoticiaAtual();
                        noticiaAtual = null;



                        System.out.println("\n  +------------------------------------------+");
                        System.out.println("  |              CATEGORIA ATUAL             |");
                        System.out.println("  +------------------------------------------+");
                        System.out.println("  | " + categoriaAtual);
                        System.out.println("  +------------------------------------------+");

                    } catch (NullPointerException e) {
                        System.out.println("\n  [!] Ainda não há categorias cadastradas.");
                    }
                    break;

                case 3:
                    try {
                        categoriaAtual = (Categoria) sistema.anteriorCategoria();
                        categoriaAtual.resetNoticiaAtual();
                        noticiaAtual = null;

                        System.out.println("\n  +------------------------------------------+");
                        System.out.println("  |              CATEGORIA ATUAL             |");
                        System.out.println("  +------------------------------------------+");
                        System.out.println("  | " + categoriaAtual);
                        System.out.println("  +------------------------------------------+");

                    } catch (NullPointerException e) {
                        System.out.println("\n  [!] Ainda não há categorias cadastradas.");
                    }
                    break;

                case 4:
                    if (categoriaAtual == null) {
                        System.out.println("\n  [!] Selecione uma categoria primeiro.");
                        System.out.println("      Use a opção 2 ou 3.");
                        break;
                    }

                    System.out.print("\n  Titulo da notícia: ");
                    categoriaAtual.addNoticia(new Noticia(scanner.nextLine()));

                    System.out.println("  [OK] Noticia adicionada em '" + categoriaAtual + "'.");
                    break;

                case 5:
                    if (categoriaAtual == null) {
                        System.out.println("\n  [!] Selecione uma categoria primeiro.");
                        System.out.println("      Use a opcao 2 ou 3.");
                        break;
                    }

                    try {
                        noticiaAtual = (Noticia) categoriaAtual.proximaNoticia();
                        noticiaAtual.resetImagemAtual();
                        imagemAtual = null;

                        System.out.println("\n  +------------------------------------------+");
                        System.out.println("  |                NOTICIA ATUAL             |");
                        System.out.println("  +------------------------------------------+");
                        System.out.println("  | " + noticiaAtual);
                        System.out.println("  +------------------------------------------+");

                    } catch (NullPointerException e) {
                        System.out.println("\n  [!] Essa categoria ainda nao tem noticias.");
                    }
                    break;

                case 6:
                    if (categoriaAtual == null) {
                        System.out.println("\n  [!] Selecione uma categoria primeiro.");
                        System.out.println("      Use a opcao 2 ou 3.");
                        break;
                    }

                    try {
                        noticiaAtual = (Noticia) categoriaAtual.anteriorNoticia();
                        noticiaAtual.resetImagemAtual();
                        imagemAtual = null;

                        System.out.println("\n  +------------------------------------------+");
                        System.out.println("  |                NOTICIA ATUAL             |");
                        System.out.println("  +------------------------------------------+");
                        System.out.println("  | " + noticiaAtual);
                        System.out.println("  +------------------------------------------+");

                    } catch (NullPointerException e) {
                        System.out.println("\n  [!] Essa categoria ainda nao tem noticias.");
                    }
                    break;

                case 7:
                    if (noticiaAtual == null) {
                        System.out.println("\n  [!] Selecione uma noticia primeiro.");
                        System.out.println("      Use a opcao 5 ou 6.");
                        break;
                    }

                    System.out.print("\n  Dado da imagem: ");
                    noticiaAtual.addImagem(new Imagem(scanner.nextLine()));

                    System.out.println("  [OK] Imagem adicionada em '" + noticiaAtual + "'.");
                    break;

                case 8:
                    if (noticiaAtual == null) {
                        System.out.println("\n  [!] Selecione uma noticia primeiro.");
                        System.out.println("      Use a opcao 5 ou 6.");
                        break;
                    }

                    try {
                        imagemAtual = (Imagem) noticiaAtual.proximaImagem();
                        System.out.println("\n  Imagem atual: " + imagemAtual);

                    } catch (NullPointerException e) {
                        System.out.println("\n  [!] Essa noticia ainda nao tem imagens.");
                    }
                    break;

                case 9:
                    if (noticiaAtual == null) {
                        System.out.println("\n  [!] Selecione uma noticia primeiro.");
                        System.out.println("      Use a opcao 5 ou 6.");
                        break;
                    }

                    try {
                        imagemAtual = (Imagem) noticiaAtual.anteriorImagem();
                        System.out.println("\n  Imagem atual: " + imagemAtual);

                    } catch (NullPointerException e) {
                        System.out.println("\n  [!] Essa noticia ainda nao tem imagens.");
                    }
                    break;

                case 10:
                    statusAtual(sistema, categoriaAtual, noticiaAtual, imagemAtual);
                    break;

                case 11:
                    if (sistema.isEmpty()) {
                        System.out.println("\n  [!] Nao ha categorias para remover.");
                        break;
                    }

                    Categoria categoriaRemovida =
                            (Categoria) sistema.categoriaAtual();

                    sistema.removerCategoria();

                    System.out.println("\n  [OK] Categoria removida: " + categoriaRemovida);

                    categoriaAtual = null;
                    noticiaAtual = null;
                    break;

                case 12:
                    if (categoriaAtual == null) {
                        System.out.println("\n  [!] Selecione uma categoria primeiro.");
                        System.out.println("      Use a opcao 2 ou 3.");
                        break;
                    }

                    if (categoriaAtual.isEmpty()) {
                        System.out.println("\n  [!] Essa categoria nao tem noticias para remover.");
                        break;
                    }

                    Noticia noticiaRemovida =
                            (Noticia) categoriaAtual.noticiaAtual();

                    categoriaAtual.removerNoticia();

                    System.out.println("\n  [OK] Noticia removida: " + noticiaRemovida);

                    noticiaAtual = null;
                    break;

                case 13:
                    if (noticiaAtual == null) {
                        System.out.println("\n  [!] Selecione uma noticia primeiro.");
                        System.out.println("      Use a opcao 5 ou 6.");
                        break;
                    }

                    if (noticiaAtual.isEmpty()) {
                        System.out.println("\n  [!] Essa noticia nao tem imagens para remover.");
                        break;
                    }

                    Object imagemRemovida = noticiaAtual.imagemAtual();

                    noticiaAtual.removerImagem();

                    System.out.println("\n  [OK] Imagem removida: " + imagemRemovida);
                    break;

                case 0:
                    System.out.println("\n  +------------------------------------------+");
                    System.out.println("  |          Encerrando o sistema...         |");
                    System.out.println("  +------------------------------------------+");
                    break;

                default:
                    System.out.println("\n  [X] Opcao invalida.");
                    System.out.println("      Escolha uma opcao disponivel no menu.");

            }

        } while (opcao != 0);

    }

    static int lerOpcao() {

        try {

            int opcao = scanner.nextInt();
            scanner.nextLine();

            return opcao;

        } catch (InputMismatchException e) {

            scanner.nextLine();

            return -1;

        }
    }

    static void statusAtual(
            SistemaNoticias sistema,
            Categoria categoriaAtual,
            Noticia noticiaAtual,
            Imagem imagemAtual ) {

        System.out.println();

        System.out.println("  +------------------------------------------+");
        System.out.println("  |             STATUS DO SISTEMA            |");
        System.out.println("  +------------------------------------------+");

        if (sistema == null) {

            System.out.println("  | Categorias: lista vazia                  |");

        } else {

            System.out.println("  | Categorias cadastradas: "
                    + sistema.retornarTamanho()  + "                |");
        }

        System.out.println("  |                                          |");

        if (categoriaAtual == null) {

            System.out.println("  | Categoria atual: nenhuma                 |");

        } else {

            System.out.println("  | Categoria atual: " + categoriaAtual);
            System.out.println("  | Noticias: " + categoriaAtual.retornarTamanho());

        }

        System.out.println("  |                                          |");

        if (noticiaAtual == null) {

            System.out.println("  | Noticia atual: nenhuma                   |");

        } else {

            System.out.println("  | Noticia atual: " + noticiaAtual);
            System.out.println("  | Imagens: " + noticiaAtual.retornarTamanho());

        }

        System.out.println("  |                                          |");

        if (imagemAtual == null) {

            System.out.println("  | Imagem atual: nenhuma                    |");

        } else {

            System.out.println("  | Imagem atual: " + imagemAtual);

        }

        System.out.println("  +------------------------------------------+");

    }

    static void exibirMenu() {

        System.out.println();

        System.out.println("  +------------------------------------------+");
        System.out.println("  |          SISTEMA DE NOTICIAS             |");
        System.out.println("  +------------------------------------------+");

        System.out.println("  |                                          |");
        System.out.println("  |               CATEGORIAS                 |");
        System.out.println("  |                                          |");
        System.out.println("  |  [ 1 ]  Adicionar categoria              |");
        System.out.println("  |  [ 2 ]  Proxima categoria                |");
        System.out.println("  |  [ 3 ]  Categoria anterior               |");

        System.out.println("  |                                          |");
        System.out.println("  |                NOTICIAS                  |");
        System.out.println("  |                                          |");
        System.out.println("  |  [ 4 ]  Adicionar noticia                |");
        System.out.println("  |  [ 5 ]  Proxima noticia                  |");
        System.out.println("  |  [ 6 ]  Noticia anterior                 |");

        System.out.println("  |                                          |");
        System.out.println("  |                 IMAGENS                  |");
        System.out.println("  |                                          |");
        System.out.println("  |  [ 7 ]  Adicionar imagem                 |");
        System.out.println("  |  [ 8 ]  Proxima imagem                   |");
        System.out.println("  |  [ 9 ]  Imagem anterior                  |");

        System.out.println("  |                                          |");
        System.out.println("  |                 SISTEMA                  |");
        System.out.println("  |                                          |");
        System.out.println("  |  [10 ]  Ver status                       |");
        System.out.println("  |  [11 ]  Remover categoria                |");
        System.out.println("  |  [12 ]  Remover noticia                  |");
        System.out.println("  |  [13 ]  Remover imagem                   |");

        System.out.println("  |                                          |");
        System.out.println("  |                  SAIR                    |");
        System.out.println("  |                                          |");
        System.out.println("  |  [ 0 ]  Sair                             |");
        System.out.println("  |                                          |");

        System.out.println("  +------------------------------------------+");

        System.out.print("\n  Escolha uma opcao: ");
    }
}