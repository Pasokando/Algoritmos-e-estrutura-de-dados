import java.util.Scanner;
import java.util.Vector;

public class Aula2-Exercicio2 {
    static Vector<String> vector = new Vector<>();

    public static void main(String[] args) throws Exception {
        Scanner tec = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            menu();
            int opc = tec.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Nome a ser cadastrado: ");
                    cadastrar(tec.next());
                    break;
                case 2:
                    selecionar();
                    break;
                case 3:
                    System.out.println("Termo a ser pesquisado:");
                    pesquisar(tec.next());
                    break;
                case 4:
                    System.out.println("Nome antigo: ");
                    String nomeAntigo = tec.next();
                    System.out.println("Nome novo: ");
                    String nomeNovo = tec.next();
                    alterar(nomeAntigo, nomeNovo);
                    verificar(nomeAntigo);
                    break;
                case 5:
                    System.out.println("Nome a ser removido: ");
                    String nomeRemovido = tec.next();
                    remover(nomeRemovido);
                    verificar(nomeRemovido);
                    break;
                case 0:
                    System.out.println("Finalizando..");
                    loop = false;
                    break;
                default:
                    System.out.println("Opcão invalida!");
                    break;
            }
        }
        tec.close();
    }

    public static void cadastrar(String nome) {
        for (String string : vector) {
            if (string.equals(nome)) {
                System.out.println("Nome já está na lista!");
                return;
            }
        }
        vector.add(nome);
            System.out.println("Nome adicionado!");

    }

    public static void selecionar() {
        System.out.println("-----Lista-----");
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }
    }

    public static void pesquisar(String termo) {
        System.out.println("---Resultado---");
        for (String string : vector) {
            if (string.contains(termo)) {
                System.out.println(string);
            }
        }
    }

    public static void alterar(String nomeAlterar, String nomeNovo) {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).equalsIgnoreCase(nomeAlterar)) {
                vector.set(i, nomeNovo);
                return;
            }
        }
        System.out.println("Nome não encontrado!");
    }

    public static void remover(String nomeRemover) {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).equalsIgnoreCase(nomeRemover)) {
                vector.remove(i);
                return;
            }
        }
        System.out.println("Nome não encontrado!");
    }

    public static void menu() {
        System.out.println("------------------");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Selecionar todos os registros");
        System.out.println("3 - Pesquisar");
        System.out.println("4 - Alterar");
        System.out.println("5 - Remover");
        System.out.println("0 - Sair");
        System.out.println("------------------");
    }

    public static void verificar(String nome) {
        for (String string : vector) {
            if (string.equals(nome)) {
                System.out.println("Nome não removido/alterado!");
                return;
            }
        }
        System.out.println("Nome alterado/removido com sucesso!");
    }
}
