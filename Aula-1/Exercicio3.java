import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio3 {

    static Scanner tec = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            menu();
            opcao = tec.nextInt();
            tec.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    pesquisar();
                    break;
                case 4:
                    alterar();
                    break;
                case 5:
                    remover();
                    break;
                case 0:
                    System.out.println("Finalizando..");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menu() {
        System.out.println("----------------------");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Pesquisar Produto");
        System.out.println("4 - Alterar Produto");
        System.out.println("5 - Remover Produto");
        System.out.println("0 - Finalizar");
        System.out.print("Digite a opção desejada: ");
    }

    private static void cadastrar() {
        System.out.print("Nome do produto: ");
        String nome = tec.nextLine();
        System.out.print("Valor do produto: ");
        double valor = tec.nextDouble();
        tec.nextLine();

        produtos.add(new Produto(nome, valor));
        System.out.println("Produto cadastrado!");
    }

    private static void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        System.out.println("----------------------");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " R$" + produto.getValor());
        }
    }

    private static void pesquisar() {
        System.out.print("Digite sua pesquisa: ");
        String termo = tec.nextLine();

        ArrayList<Produto> resultados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(produto);
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhum produto encontrado com essa palavra!");
            return;
        }

        System.out.println("----Resultado----");
        for (Produto produto : resultados) {
            System.out.println(produto.getNome() + " R$" + produto.getValor());
        }
    }

    private static void alterar() {
        System.out.print("Digite o nome do produto a ser alterado: ");
        String nome = tec.nextLine();

        int indice = buscarProdutoPorNome(nome);
        if (indice == -1) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.print("Novo nome do produto: ");
        String novoNome = tec.nextLine();
        System.out.print("Novo valor do produto: ");
        double novoValor = tec.nextDouble();
        tec.nextLine();

        produtos.get(indice).setNome(novoNome);
        produtos.get(indice).setValor(novoValor);
        System.out.println("Produto alterado com sucesso!");
    }

    private static void remover() {
        System.out.print("Digite o nome do produto a ser removido: ");
        String nome = tec.nextLine();

        int indice = buscarProdutoPorNome(nome);
        if (indice == -1) {
            System.out.println("Produto não encontrado!");
            return;
        }

        produtos.remove(indice);
        System.out.println("Produto removido com sucesso!");
    }

    private static int buscarProdutoPorNome(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }
}

class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}