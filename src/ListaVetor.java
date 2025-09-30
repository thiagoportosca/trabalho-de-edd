/**
 * Implementa a estrutura de dados LISTA usando vetor
 * @param <T> Tipo a ser armazenado na lista
 */
public class ListaVetor<T> implements ILista<T> {

    private static final int TAM_INICIAL = 10;
    private static final int PERC_AUMENTO = 50;

    private T[] itens;
    private int qtdItens;

    public ListaVetor() {
        itens = (T[]) new Object[TAM_INICIAL];
        qtdItens = 0;
    }

    @Override
    public boolean inserirInicio(T e) {
        return inserirPosicao(0, e);
    }

    @Override
    public boolean inserirFim(T e) {
        return inserirPosicao(qtdItens, e);
    }

    @Override
    public boolean inserirPosicao(int p, T e) {
        if (p < 0 || p > qtdItens)
            return false;

        if (qtdItens == itens.length)
            try {
                aumentarVetor();
            } catch(OutOfMemoryError ex) {
                return false;
            }

        deslocarFrente(p);

        itens[p] = e;
        qtdItens++;

        return true;
    }

    @Override
    public T alterar(int p, T e) {
        if (p < 0 || p > qtdItens-1)
            return null;

        T old = itens[p];

        itens[p] = e;

        return old;
    }

    @Override
    public T removerInicio() {
        return removerPosicao(0);
    }

    @Override
    public T removerFim() {
        return removerPosicao(qtdItens-1);
    }

    @Override
    public T removerPosicao(int p) {
        if (p < 0 || p > qtdItens-1)
            return null;

        T old = itens[p];

        deslocarTras(p);

        itens[qtdItens-1] = null;
        qtdItens--;

        if (((double) qtdItens / itens.length) * 100 <= 25 && itens.length / 2 >= 10) {
            int novoTamanho = itens.length / 2;
            T[] novoVetor = (T[]) new Object[novoTamanho];
            System.arraycopy(itens, 0, novoVetor, 0, qtdItens);
            itens = novoVetor;
        }

        return old;
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
        if (p < 0 || p > qtdItens-1)
            return null;

        return itens[p];
    }

    @Override
    public boolean contem(T e) {
        return posicao(e) != -1;
    }

    @Override
    public int posicao(T e) {
        for (int i = 0; i < qtdItens; i++)
            if (itens[i].equals(e))
                return i;

        return -1;
    }

    @Override
    public int quantidade() {
        return qtdItens;
    }

    public int tamLista(){
        return itens.length;
    }


    @Override
    public boolean estaVazia() {
        return qtdItens == 0;
    }

    @Override
    public void removerTodos() {
        itens = (T[]) new Object[TAM_INICIAL];
        qtdItens = 0;
    }

    @Override
    public String toString(){
        StringBuilder buffer = new StringBuilder();

        buffer.append("[");

        for (int i = 0; i < qtdItens-1; i++) {
            buffer.append(itens[i]);
            buffer.append(", ");
        }

        buffer.append(itens[qtdItens-1]);
        buffer.append("]");

        return buffer.toString();
    }

    private void aumentarVetor() {
        int novoTam = itens.length + (itens.length * PERC_AUMENTO / 100);
        T[] novo = (T[]) new Object[novoTam];

        System.arraycopy(itens, 0, novo, 0, qtdItens);

        itens = novo;
    }

    private void deslocarFrente(int p) {
        for (int i = qtdItens-1; i >= p; i--)
            itens[i+1] = itens[i];
    }

    private void deslocarTras(int p) {
        for (int i = p; i < qtdItens; i++)
            itens[i] = itens[i+1];
    }






}
