// Usei "queue" devido sua propriedade (FIFO - First-In-First-Out).

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio4 {

    static Queue<String> fila = new LinkedList<>();
    static Scanner tec = new Scanner(System.in);
    public static void main(String[] args) {

        boolean finalizar = false;

        while (!finalizar) {

            System.out.println("1 - Cadastrar atendimento");
            System.out.println("2 - Remover");
            System.out.println("3 - Mostrar a fila");
            System.out.println("0 - Finalizar");
            int opc = tec.nextInt();

            switch (opc) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    fila.remove();
                    System.out.println("Atendimento removido!");
                    break;
                case 3:
                    System.out.println(fila);
                    break;
                default:
                finalizar = true;
                    break;
            }
        }
        tec.close();
    }

    public static void cadastrar(){
        System.out.println();
        System.out.println("Digite o nome a ser cadastrado: ");
        fila.add(tec.next());
    }
}
