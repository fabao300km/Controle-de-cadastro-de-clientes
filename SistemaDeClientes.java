import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeClientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Método para cadastrar cliente
    public void cadastrarCliente(String nome, String email, String telefone) {
        Cliente novoCliente = new Cliente(nome, email, telefone);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Método para listar clientes
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    // Método para atualizar cliente
    public void atualizarCliente(String nome, String novoEmail, String novoTelefone) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                cliente.setEmail(novoEmail);
                cliente.setTelefone(novoTelefone);
                System.out.println("Cliente atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    // Método para remover cliente
    public void removerCliente(String nome) {
        clientes.removeIf(cliente -> cliente.getNome().equalsIgnoreCase(nome));
        System.out.println("Cliente removido com sucesso!");
    }

    public static void main(String[] args) {
        SistemaDeClientes sistema = new SistemaDeClientes();
        Scanner scanner = new Scanner(System.in);

        // Interface de menu para o usuário
        while (true) {
            System.out.println("\n1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    sistema.cadastrarCliente(nome, email, telefone);
                    break;
                case 2:
                    sistema.listarClientes();
                    break;
                case 3:
                    System.out.print("Nome do cliente a atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    sistema.atualizarCliente(nomeAtualizar, novoEmail, novoTelefone);
                    break;
                case 4:
                    System.out.print("Nome do cliente a remover: ");
                    String nomeRemover = scanner.nextLine();
                    sistema.removerCliente(nomeRemover);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
