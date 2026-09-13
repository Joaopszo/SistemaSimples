package projetosimples;

class Lista {

    protected Node begin;
    protected Node end;

    void addData(Object data) {

        Node novo = new Node();
        novo.data = data;

        if (begin == null) {

            begin = novo;
            begin.next = begin;
            begin.back = begin;
            end = begin;

        } else {

            end.next = novo;
            novo.back = end;
            novo.next = begin;
            begin.back = novo;
            end = novo;

        }

    }

    boolean isEmpty() {

        return this.begin == null;

    }

    private Node procurarNode(int index) {

        Node aux = this.begin;
        int contador = 0;

        if (index < 0) {

            while (contador != index) {

                aux = aux.back;
                contador--;

            }

        } else {

            while (contador != index) {

                aux = aux.next;
                contador++;

            }

        }

        return aux;

    }

    Object procurarData(int index) {

        return procurarNode(index).data;

    }

    void removeData(int index) {

        if (this.isEmpty()) {

            return;

        }

        Node aux = procurarNode(index);

        if (aux.next == aux) {

            this.begin = null;
            this.end = null;
            aux.back = null;
            aux.next = null;
            aux.data = null;
            return;

        }

        aux.back.next = aux.next;
        aux.next.back = aux.back;

        if (aux == this.begin) {

            this.begin = aux.next;

        }

        if (aux == this.end) {

            this.end = aux.back;

        }

        aux.back = null;
        aux.next = null;
        aux.data = null;

    }

    int retornarTamanho() {

        Node aux = this.begin;
        int tamanho = 0;

        if (this.begin != null) {

            do {

                tamanho++;
                aux = aux.next;


            } while (aux != this.begin);

        }

        return tamanho;

    }
}