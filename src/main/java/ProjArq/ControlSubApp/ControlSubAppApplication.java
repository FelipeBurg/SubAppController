package ProjArq.ControlSubApp;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO.ClienteDao;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class ControlSubAppApplication {

    private static DataSource dataSource;

    public static void main(String[] args) {

        try {
            Connection connection = DatabaseConnection.getConnection();
            Cliente cliente = new Cliente(1L, "João Silva", "joao.silva@email.com");
            ClienteDao clienteDao = new ClienteDao(connection);
            clienteDao.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }


        SpringApplication.run(ControlSubAppApplication.class, args);
    }

}
