import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class UsuarioDAO {

    // Listar todos os usuários
    public static void listarUsuarios() {
        String sql = "SELECT * FROM Usuario ORDER BY Nome";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n=== Lista de Usuários ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_Usuario") +
                                   ", Nome: " + rs.getString("Nome") +
                                   ", Tipo: " + rs.getString("Tipo") +
                                   ", Email: " + rs.getString("Email"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
    }

    // Buscar usuário por nome
    public static void buscarUsuarioPorNome(String nome) {
        String sql = "SELECT * FROM Usuario WHERE Nome LIKE ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n=== Resultados para o nome: " + nome + " ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_Usuario") +
                                   ", Nome: " + rs.getString("Nome") +
                                   ", Tipo: " + rs.getString("Tipo") +
                                   ", Email: " + rs.getString("Email"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário por nome: " + e.getMessage());
        }
    }

    // Buscar usuários por tipo (Aluno/Professor)
    public static void buscarUsuarioPorTipo(String tipo) {
        String sql = "SELECT * FROM Usuario WHERE Tipo = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n=== Resultados para o tipo: " + tipo + " ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_Usuario") +
                                   ", Nome: " + rs.getString("Nome") +
                                   ", Tipo: " + rs.getString("Tipo") +
                                   ", Email: " + rs.getString("Email"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário por tipo: " + e.getMessage());
        }
    }

    // Buscar usuário por email
    public static void buscarUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM Usuario WHERE Email = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n=== Resultado para o email: " + email + " ===");
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_Usuario") +
                                   ", Nome: " + rs.getString("Nome") +
                                   ", Tipo: " + rs.getString("Tipo") +
                                   ", Email: " + rs.getString("Email"));
            } else {
                System.out.println("Nenhum usuário encontrado com esse email.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário por email: " + e.getMessage());
        }
    }

    // Adicionar novo usuário
    public static void adicionarUsuario(String nome, String tipo, String email) {
        String sql = "INSERT INTO Usuario (Nome, Tipo, Email) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setString(3, email);

            stmt.executeUpdate();
            System.out.println("Usuário adicionado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }
}
