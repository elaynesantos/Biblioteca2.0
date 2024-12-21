import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO {

    public static void listarLivros() {
        String sql = "SELECT * FROM Livro";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n=== Lista de Livros ===");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_Livro") +
                                   ", Título: " + rs.getString("Titulo") +
                                   ", Autor: " + rs.getString("Autor") +
                                   ", Fornecedor: " + rs.getString("Fornecedor"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
    }

    public static void adicionarLivro(String titulo, String autor, String fornecedor) {
        String sql = "INSERT INTO Livro (Titulo, Autor, Fornecedor) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setString(3, fornecedor);

            stmt.executeUpdate();
            System.out.println("Livro adicionado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar livro: " + e.getMessage());
        }
    }
}
