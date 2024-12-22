import java.util.Scanner;

public class Biblioteca {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcaoMenu();

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
                    listarLivrosPorFornecedor();
                    break;
                case 6:
                    buscarUsuarioPorNome();
                    break;
                case 7:
                    buscarUsuarioPorTipo();
                    break;
                case 8:
                    buscarUsuarioPorEmail();
                    break;
                case 9:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema de Biblioteca ===");
        System.out.println("1. Listar Usuários");
        System.out.println("2. Adicionar Usuário");
        System.out.println("3. Listar Livros");
        System.out.println("4. Adicionar Livro");
        System.out.println("5. Listar Livros por Fornecedor");
        System.out.println("6. Buscar Usuário por Nome");
        System.out.println("7. Buscar Usuário por Tipo");
        System.out.println("8. Buscar Usuário por Email");
        System.out.println("9. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Método para ler a opção do menu com tratamento de erro
    private static int lerOpcaoMenu() {
        int opcao = -1;
        while (opcao < 1 || opcao > 9) {
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao < 1 || opcao > 9) {
                    System.out.println("Opção inválida. Digite um número entre 1 e 9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
        }
        return opcao;
    }

    private static void listarUsuarios() {
        UsuarioDAO.listarUsuarios();
    }

    private static void adicionarUsuario() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo (Aluno/Professor): ");
        String tipo = lerTipoUsuario();
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();

        UsuarioDAO.adicionarUsuario(nome, tipo, email);
    }

    // Método para validar e garantir que o tipo de usuário seja "Aluno" ou "Professor"
    private static String lerTipoUsuario() {
        String tipo;
        while (true) {
            tipo = scanner.nextLine().trim().toLowerCase();
            if (tipo.equals("aluno") || tipo.equals("professor")) {
                return tipo.substring(0, 1).toUpperCase() + tipo.substring(1); // Retorna com a primeira letra maiúscula
            } else {
                System.out.println("Tipo inválido. Digite 'Aluno' ou 'Professor': ");
            }
        }
    }

    private static void listarLivros() {
        LivroDAO.listarLivros();
    }

    private static void listarLivrosPorFornecedor() {
        System.out.print("Digite o fornecedor: ");
        String fornecedor = scanner.nextLine();
        LivroDAO.listarLivrosPorFornecedor(fornecedor);
    }

    private static void buscarUsuarioPorNome() {
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        UsuarioDAO.buscarUsuarioPorNome(nome);
    }

    private static void buscarUsuarioPorTipo() {
        System.out.print("Digite o tipo de usuário (Aluno/Professor): ");
        String tipo = lerTipoUsuario();
        UsuarioDAO.buscarUsuarioPorTipo(tipo);
    }

    private static void buscarUsuarioPorEmail() {
        System.out.print("Digite o email do usuário: ");
        String email = scanner.nextLine();
        UsuarioDAO.buscarUsuarioPorEmail(email);
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
