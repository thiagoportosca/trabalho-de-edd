import java.util.Comparator;

public class LDEO <T> implements IlistaOrdenada<T>{


        private No  head;
        private No  tail;
        private int qtdItens;
        private Comparator<T> comparador;
        private Ordenacao ordem;

    /**
         * Implementa o nó da lista duplamente encadeada. Armazena o item propriamente
         * dito e uma referência para os nós próximo e anterior
         */
        private class No {
            public T  item;
            public No prox;
            public No ant;



            public No(T item) {
                this.item = item;
                this.prox = null;
                this.ant = null;
            }

    }

    public LDEO(Ordenacao ordem, Comparator<T> comparador) {
        this.comparador = comparador;
        this.head = null;
        this.tail = null;
        this.qtdItens = 0;
        this.ordem = ordem;
    }

   @Override
    public boolean inserir(T e) {
        No novoNo = new No(e);
        No aux ;

        if (qtdItens == 0){
            head = novoNo;
            tail = novoNo;
            qtdItens++;
            return true;
        }
       No atual = head;
       for (int i = 0; i < qtdItens; i++) {
        if((comparador.compare(atual.item,novoNo.item)>0 && ordem==Ordenacao.ASC)||(comparador.compare(atual.item,novoNo.item)<0 && ordem==Ordenacao.DESC)){
            atual = atual.prox;
        }
       }


    }


    public int testarcomparador(T i1, T i2){

        return comparador.compare(i1,i2);
    }


    @Override
        public T alterar(int p, T e) {
            No aux;
            T old;

            if (p < 0 || p >= qtdItens)
                return null;

            aux = localizarNo(p);

            old = aux.item;
            aux.item = e;

            return old;
        }

        @Override
        public T removerInicio() {
            No no;
            T item;

            if (qtdItens == 0)
                return null;

            no = head;
            head = head.prox;

            if (head == null)
                tail = null;
            else
                head.ant = null;

            item = no.item;
            no.item = null;
            no.prox = null;
            no.ant = null;

            qtdItens--;

            return item;
        }

        @Override
        public T removerFim() {
            No ultimo;
            T item;

            if (qtdItens == 0)
                return null;

            if (qtdItens == 1)
                return removerInicio();

            ultimo = tail;

            // Penúltimo passa a ser o último
            tail = tail.ant;
            tail.prox = null;

            item = ultimo.item;
            ultimo.item = null;
            ultimo.ant = null;

            qtdItens--;

            // Retorna o item removido
            return item;
        }


        @Override
        public T removerPosicao(int p) {
            No no, aux;
            T item;

            // Verifica se P é válido
            if (p < 0 || p >= qtdItens)
                return null;

            // Se P é a primeira posição, então é uma remoção do início
            // Se P é a ultima posição, então é uma remoção do fim
            if (p == 0)
                return removerInicio();
            else if (p == qtdItens-1)
                return removerFim();

            // AUX = nó da posição p-1
            aux = localizarNo(p-1);

            no = aux.prox;
            aux.prox = no.prox;
            no.prox.ant = aux;

            item = no.item;
            no.item = null;
            no.prox = null;
            no.ant = null;

            qtdItens--;

            return item;
        }

        @Override
        public T remover(T e) {
            if (e != null) {
                int p = posicao(e);

                if (p != -1) {
                    T old = getItem(p);

                    removerPosicao(p);

                    return old;
                }
            }

            return null;
        }

        @Override
        public T getItem(int p) {
            if (p < 0 || p >= qtdItens)
                return null;

            No aux = localizarNo(p);

            return aux.item;
        }

        @Override
        public boolean contem(T e) {
            return posicao(e) != -1;
        }

        @Override
        public int posicao(T e) {
            No aux = head;
            int p = 0;

            while (aux != null) {
                if (e.equals(aux.item))
                    return p;
                aux = aux.prox;
                p++;
            }

            return -1;
        }

        @Override
        public int quantidade() {
            return qtdItens;
        }

        @Override
        public boolean estaVazia() {
            return head == null;
        }

        @Override
        public void removerTodos() {
            No aux;

            while (head != null) {
                aux = head;
                head = head.prox;
                aux.item = null;
                aux.prox = null;
                aux.ant = null;
            }

            tail = null;

            qtdItens = 0;
        }

        @Override
        public String toString() {
            StringBuilder buffer = new StringBuilder();

            buffer.append("[");

            if (head != null) {
                No aux = head;

                while (aux.prox != null) {
                    buffer.append(aux.item);
                    buffer.append(", ");
                    aux = aux.prox;
                }

                buffer.append(aux.item);
            }

            buffer.append("]");

            return buffer.toString();
        }


        private No localizarNo(int p) {
            No aux = head;

            while (p > 0) {
                aux = aux.prox;
                p--;
            }

            return aux;
        }
    }



