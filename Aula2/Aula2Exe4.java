import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Aula2Exe4 {
    List<String> nomes = new LinkedList<>();

    Aula2Exe4(){
        Scanner tec = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            menu();
            int op = tec.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Nome a ser adicionado: ");
                    cadastrar(tec.next());
                    break;
                case 2:
                    listar();
                    break;
                case 0:
                    loop = false;
                    System.out.println("Finalizando..");
                    break;
                default:
                    System.out.println("Comando Invalido!");
                    break;
            }
        }
        tec.close();
    }

    public void menu() {
        System.out.println("----------------");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("0 - Finalizar");
        System.out.println("----------------");
    }

    public void cadastrar(String nome) {
        nomes.add(nome);
    }

    public void listar() {
        System.out.println("------Lista------");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    public static void main(String[] args) {
        new Aula2Exe4();
    }
}