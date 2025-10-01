import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comparador = Comparator.naturalOrder();

        LDEO<Integer> ldeo = new LDEO<>(Ordenacao.ASC,comparador);

        ldeo.inserir(10);
        ldeo.inserir(5);
        ldeo.inserir(40);
        ldeo.inserir(24);



    }

}