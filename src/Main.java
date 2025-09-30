import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comparador = Comparator.naturalOrder();
        Ordenacao ordenacao = Ordenacao.ASC;

        LDEO<Integer> ldeo = new LDEO<>(Ordenacao.ASC,comparador);


    }

}