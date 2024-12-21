import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

public class UsuarioDAO {

    public static void listarUsuarios() {
        String sql = "SELECT * FROM Usuario";

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
