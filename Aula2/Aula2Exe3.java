import java.util.ArrayList;
import java.util.Scanner;

public class Aula2Exe3 {
    private static Scanner tec = new Scanner(System.in);
    private static ArrayList<Produto> produtos = new ArrayList<>();

    Aula2Exe3() {
        int op = -1;
        while (op != 0) {
            menu();
            op = tec.nextInt();

            switch (op) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    selecionar();
                    break;
                case 3:
                    exibirSeg();
                    break;
                case 4:
                    alterarProduto();
                    break;
                case 5:
                    removerProduto();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menu() {
        System.out.println("---------Menu---------");
        System.out.println("1. Cadastrar");
        System.out.println("2. Selecionar Todos os Produtos");
        System.out.println("3. Quantidade de Produtos por Segmento");
        System.out.println("4. Alterar Dados");
        System.out.println("5. Remover");
        System.out.println("0. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    private static void cadastrar() {
        System.out.print("Digite o nome do produto: ");
        String nome = tec.next();
        System.out.print("Digite o segmento do produto: ");
        String segmento = tec.next();

        produtos.add(new Produto(nome, segmento));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void selecionar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }
    }

    private static void exibirSeg() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        ArrayList<String> segmentos = new ArrayList<>();
        ArrayList<Integer> contagens = new ArrayList<>();
        for (Produto produto : produtos) {
            if (!segmentos.contains(produto.getSegmento())) {
                segmentos.add(produto.getSegmento());
                contagens.add(1);
            } else {
                int indice = segmentos.indexOf(produto.getSegmento());
                contagens.set(indice, contagens.get(indice) + 1);
            }
        }

        for (int i = 0; i < segmentos.size(); i++) {
            System.out.println("Segmento: " + segmentos.get(i) + " - Quantidade: " + contagens.get(i));
        }
    }

    private static void alterarProduto() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        selecionar();

        System.out.print("Digite o nome do produto: ");
        String nomeAntigo = tec.next();

        int indice = -1;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(nomeAntigo)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.print("Digite o novo nome do produto: ");
        String novoNome = tec.next();

        System.out.print("Digite o novo segmento do produto: ");
        String novoSegmento = tec.next();

        produtos.set(indice, new Produto(novoNome, novoSegmento));
        System.out.println("Produto alterado com sucesso!");
    }

    private static void removerProduto() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        selecionar();

        System.out.print("Digite o nome do produto que deseja remover: ");
        String nome = tec.next();

        int indice = -1;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(nome)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("Produto não encontrado!");
            return;
        }

        produtos.remove(indice);
        System.out.println("Produto removido com sucesso!");
    }

    public static void main(String[] args) {
        new Aula2Exe3();
    }
}

class Produto {

    private String nome;
    private String segmento;

    public Produto(String nome, String segmento) {
        this.nome = nome;
        this.segmento = segmento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    @Override
    public String toString() {
        return nome +
                ", segmento = " + segmento;
    }
}
