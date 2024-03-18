import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AtividadeAv1 {
    Queue<String> tarefas = new LinkedList<>();
    AtividadeAv1() {
        Scanner tec = new Scanner(System.in);
        int op = -1;
        while (op != 0) {
            menu();
            op = tec.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Que tarefa desejas adicionar?");
                    tec.nextLine();
                    adcionar(tec.nextLine());
                    break;
                case 2:
                    System.out.println("Concluida a tarefa:");
                    concluir();
                    break;
                case 3:
                    vizualizar();
                    break;
                case 0:
                    System.out.println("Finalizando..");
                    break;
                default:
                    System.out.println("Comando Invalido!");
                    break;
            }
        }
        tec.close();
    }

    private void concluir() {
        System.out.println(tarefas.poll());
    }

    private void vizualizar() {
        System.out.println(tarefas.peek());
    }

    private void adcionar(String tarefa) {
        tarefas.add(tarefa);
    }

    private void menu() {
        System.out.println("------------------------");
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Concluir tarefa");
        System.out.println("3 - Vizualizar tarefa");
        System.out.println("0 - sair");
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        new AtividadeAv1();
    }
}
