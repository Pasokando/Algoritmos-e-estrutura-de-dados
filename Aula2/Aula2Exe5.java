import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Aula2Exe5 {
    private HashMap<String, String> frutas = new HashMap<>();
    Scanner tec = new Scanner(System.in);
    Aula2Exe5(){
        int op = -1;
        while (op != 0) {
            menu();
            op = tec.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Digite o nome da fruta: ");
                    String nome = tec.next();
                    System.out.println("Digite o estado da fruta(madura/podre): ");
                    String estado = tec.next();
                    cadastrar(nome, estado);
                    System.out.println("Fruta cadastrada com sucesso!");
                    break;
                case 2:
                    selecionar();
                    break;
                case 3:
                    System.out.println("Digite o nome da fruta: ");
                    String nomeAlterar = tec.next();
                    System.out.println("Digite o novo nome: ");
                    String nomeNovo = tec.next();
                    System.out.println("Digite o estado da fruta(madura/podre): ");
                    String estadoAlterar = tec.next();
                    alterar(nomeAlterar, nomeNovo, estadoAlterar);
                    break;
                case 4:
                    System.out.println("Digite o nome da fruta: ");
                    excluir(tec.next());
                    break;
                case 5:
                    estatistica();
                    break;
                case 0:
                    System.out.println("Finalizando..");
                default:
                    System.out.println("Comando invalido!");
                    break;
            }
        }
    }

    void menu() {
        System.out.println("--- Gerenciador de Frutas ---");
        System.out.println("1. Cadastrar Fruta");
        System.out.println("2. Selecionar Frutas");
        System.out.println("3. Alterar Fruta");
        System.out.println("4. Excluir Fruta");
        System.out.println("5. Exibir Estatísticas");
        System.out.println("0. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    void cadastrar(String nome, String estado) {
        frutas.put(nome, estado);
    }

    void selecionar() {
        System.out.println(frutas);
    }

    void alterar(String nomeAntigo, String nomeNovo, String estadoNovo) {
        frutas.remove(nomeAntigo);
        frutas.put(nomeNovo, estadoNovo);
    }

    void excluir(String nome) {
        frutas.remove(nome);
    }

    void estatistica() {
        int total = 0, maduras = 0, podres = 0;
    
        for (Map.Entry<String, String> entry : frutas.entrySet()) {
            total++;
            String valor = entry.getValue();
    
            if (valor.equals("madura")) {
                maduras++;
            } else if (valor.equals("podre")) {
                podres++;
            }
        }
    
        System.out.println("Total: " + total);
        System.out.println("Maduras: " + maduras);
        System.out.println("Podres: " + podres);
    }
    

    public static void main(String[] args) {
        new Aula2Exe5();
    }
}