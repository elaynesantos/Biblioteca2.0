import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca"; // Substitua pela URL do seu banco
    private static final String USER = "root"; // Substitua pelo seu usuário do banco
    private static final String PASSWORD = "#8611Beta"; // Substitua pela sua senha do banco

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
}
