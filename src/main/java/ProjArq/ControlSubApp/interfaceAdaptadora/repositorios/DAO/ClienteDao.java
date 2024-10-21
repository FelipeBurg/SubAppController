package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.ClienteRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements ClienteRepository {
    private Connection connection;

    public ClienteDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Cliente findById(long codigo) {
        Cliente cliente = null;
        String query = "SELECT * FROM Cliente WHERE codigo = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                        rs.getLong("codigo"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getLong("codigo"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    @Override
    public void save(Cliente cliente) {
        String query = "INSERT INTO Cliente (codigo, nome, email) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, cliente.getCodigo());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cliente cliente) {
            String sql = "UPDATE aplicativo SET nome = ?, email = ? WHERE codigo = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setLong(1, cliente.getCodigo());
                stmt.setString(2, cliente.getNome());
                stmt.setString(3, cliente.getEmail());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long codigo) {
        String query = "DELETE FROM Cliente WHERE codigo = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}