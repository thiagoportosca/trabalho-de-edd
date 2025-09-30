public interface IlistaOrdenada<T> {

    public boolean inserir(T e);

    /**
     * Insere o item na lista.
     *
     * @param e Item a ser inserido.
     * @return Verdadeiro, se a operação foi bem sucedida; ou falso, caso contrário.
     */

    public T alterar(int p, T e);

    /**
     * Remove o item do início da lista e o retorna.
     *
     * @return Item do início da lista; ou null, se a lista estiver vazia.
     */
    public T removerInicio();

    /**
     * Remove o item do fim da lista e o retorna.
     *
     * @return Item do fim da lista; ou null, se a lista estiver vazia.
     */
    public T removerFim();

    /**
     * Remove o item da posição p da lista e o retorna.
     *
     * @param p Posição de remoção. Valores válidos: 0 a quantidade-1.
     * @return Item removido; ou null, caso p seja inválido.
     */
    public T removerPosicao(int p);

    /**
     * Remove o item e da lista e o retorna.
     *
     * @param e Item a ser removido.
     * @return Item removido; ou null, caso e não exista.
     */
    public T remover(T e);

    /**
     * Retorna o item da posição p da lista.
     * O primeiro item da lista está na posição ZERO.
     *
     * @param p Posição do item
     * @return Item da posição p; ou null, caso p seja inválido.
     */
    public T getItem(int p);

    /**
     * Verifica se a lista contém o item e.
     *
     * @param e Item a ser buscado.
     * @return Verdadeiro se item e pertence à lista; ou falso, caso contrário.
     */
    public boolean contem(T e);

    /**
     * Retorna a primeira posição do item e na lista.
     *
     * @param e Item a ser buscado.
     * @return Primeira posição do item e na lista; ou -1, se e não pertence à lista.
     */
    public int posicao(T e);

    /**
     * Retorna a quantidade de itens da lista.
     *
     * @return Quantidade de itens da lista
     */
    public int quantidade();

    /**
     * Verifica se a lista está vazia.
     * @return Verdadeiro, se a lista estiver vazia; ou falso, caso contrário
     */
    public boolean estaVazia();

    /**
     * Remove todos os itens da lista.
     */
    public void removerTodos();
/*
* remove todos os itens da lista.
*/
}
