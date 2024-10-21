package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Aplicativo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AplicativoDAO implements AplicativoRepository {
    private Connection connection;

    public AplicativoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Aplicativo aplicativo) {
        String sql = "INSERT INTO aplicativo (nome, custoMensal) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aplicativo.getNome());
            stmt.setDouble(2, aplicativo.getCustoMensal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Aplicativo aplicativo) {
        String sql = "UPDATE aplicativo SET nome = ?, custoMensal = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aplicativo.getNome());
            stmt.setDouble(2, aplicativo.getCustoMensal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Aplicativo> findAll() {
        List<Aplicativo> aplicativos = new LinkedList<>();
        String sql = "SELECT * FROM aplicativo";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Aplicativo aplicativo = new Aplicativo(rs.getLong("id"), rs.getString("nome"), rs.getDouble("custoMensal"));
                aplicativos.add(aplicativo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aplicativos;
    }

    @Override
    public Aplicativo findById(long id) {
        Aplicativo aplicativo = null;
        String sql = "SELECT * FROM aplicativo WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                aplicativo = new Aplicativo(rs.getLong("id"), rs.getString("nome"), rs.getDouble("custoMensal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aplicativo;
    }
}
