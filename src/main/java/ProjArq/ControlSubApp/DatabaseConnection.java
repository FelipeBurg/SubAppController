package ProjArq.ControlSubApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/subApp"; // URL do seu banco de dados
    private static final String USER = "root";
    private static final String PASSWORD = "Elfen.l1ed";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao banco de dados!");
            e.printStackTrace();
        }
        return connection;
    }
}
