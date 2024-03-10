import java.util.Scanner;

class Exercicio2 {

    static String[] lista = new String[10];
    static int index = 0, opcao;
    static boolean loop = true;

    static Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {

        while (loop) {
            System.out.println("Selecione o que desejas fazer:");
            System.out.println();
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos os nomes");
            System.out.println("3 - Alterar");
            System.out.println("4 - Remover");
            System.out.println("0 - Finalizar");
            System.out.println();

            opcao = tec.nextInt();

            switch (opcao) {
                case 1:
                    Cadastrar();
                    break;
                case 2:
                    Listar();
                    break;
                case 3:
                    Alterar();
                    break;
                case 4:
                    Remover();
                    break;
                default:
                    loop = false;
                    break;
            }
        }
        tec.close();
    }

    public static void Cadastrar() {
        if (index == 10) {
            System.out.println("A Lista está cheia!");
        } else {
            System.out.println("Digite o nome que desejas cadastrar:");
            String nome = tec.next();
            lista[index] = nome;
            index++;
            System.out.println("Nome Registrado!");
        }
    }

    public static void Listar() {
        System.out.println("-----------------");
        for (int i = 0; i < lista.length; i++) {
            System.out.println(i + "   " + lista[i]);
        }
        System.out.println("-----------------");
    }

    public static void Alterar() {
        System.out.println("Qual nome desejas alterar? (Apenas o id)");
        int id = tec.nextInt();
        System.out.println("Digite o novo nome: ");
        String nome = tec.next();
        lista[id] = nome;
        System.out.println("Nome alterado com sucesso!");
        System.out.println();
    }

    public static void Remover() {
        System.out.println("Qual nome desejas alterar? (Apenas o id)");
        int id = tec.nextInt();
        String[] listaNova = new String[10];

        int j = 0;
        for (int i = 0; i < lista.length; i++) {
            if (i == id) j++;
            listaNova[i] = lista[j];
            j++;
            if (j == 10) j = 9;
        }
        lista = listaNova;
        index--;
        if (index == -1) index = 0;
    }
}
