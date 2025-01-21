package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conector {
    public Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/clientes"; // Endereço do banco de dados
        String user = "root"; // Usuário
        String password = ""; // Senha (em branco no seu caso)

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Conector conector = new Conector();
        Connection conexao = conector.getConnection();

        if (conexao != null) {
            System.out.println("Conexão estabelecida com sucesso!");
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    }
}
