import java.util.Scanner;

public class Biblioteca {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    listarUsuarios();
                    break;
                case 2:
                    adicionarUsuario();
                    break;
                case 3:
                    listarLivros();
                    break;
                case 4:
                    adicionarLivro();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Biblioteca ===");
        System.out.println("1. Listar Usuários");
        System.out.println("2. Adicionar Usuário");
        System.out.println("3. Listar Livros");
        System.out.println("4. Adicionar Livro");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void listarUsuarios() {
        UsuarioDAO.listarUsuarios();
    }

    private static void adicionarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo (Aluno/Professor): ");
        String tipo = scanner.nextLine();
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();

        UsuarioDAO.adicionarUsuario(nome, tipo, email);
    }

    private static void listarLivros() {
        LivroDAO.listarLivros();
    }

    private static void adicionarLivro() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o fornecedor do livro: ");
        String fornecedor = scanner.nextLine();

        LivroDAO.adicionarLivro(titulo, autor, fornecedor);
    }
}
