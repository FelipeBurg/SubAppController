package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Aplicativo;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Assinatura;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AssinaturaDAO implements AssinaturaRepository {
    private Connection connection;

    public AssinaturaDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Assinatura assinatura) {
        String sql = "INSERT INTO assinatura (codigo, inicioVigencia, fimVigencia, aplicativo, cliente) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, assinatura.getCodigo());
            stmt.setDate(2, (Date)assinatura.getInicioVigencia());
            stmt.setDate(3, new java.sql.Date(assinatura.getFimVigencia().getTime()));
            stmt.setObject(4, assinatura.getAplicativo());
            stmt.setObject(5, assinatura.getCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Assinatura assinatura) {
        String sql = "UPDATE assinatura SET inicioVigencia = ?, fimVigencia = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(assinatura.getInicioVigencia().getTime()));
            stmt.setDate(2, (Date)assinatura.getFimVigencia());
            stmt.setLong(3, assinatura.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Assinatura findById(long codigo) {
        Assinatura assinatura = null;
        String sql = "SELECT * FROM assinatura WHERE cliente_codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                long clienteCodigo = rs.getLong("Cliente_codigo");
                long aplicativoCodigo = rs.getLong("Aplicativo_codigo");

                ClienteDao clienteDAO = ;
                Cliente cliente = clienteDAO.findById(clienteCodigo); // Buscar cliente
                Aplicativo aplicativo = aplicativoDAO.findById(aplicativoCodigo); // Buscar aplicativo


                assinatura = new Assinatura(
                        rs.getLong("codigo"),
                        rs.getTimestamp("inicioVigencia"),
                        rs.getDate("fimVigencia"),
                        rs.ge("cliente"),
                        rs.getBoolean("ativa")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assinatura;
    }

    @Override
    public List<Assinatura> findByCliente(long clienteId) {
        List<Assinatura> assinaturas = new LinkedList<>();
        String sql = "SELECT * FROM assinatura WHERE clienteId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, clienteId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Assinatura assinatura = new Assinatura(
                        rs.getLong("id"),
                        rs.getLong("clienteId"),
                        rs.getLong("aplicativoId"),
                        rs.getDate("validade"),
                        rs.getBoolean("ativa")
                );
                assinaturas.add(assinatura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assinaturas;
    }

    @Override
    public List<Assinatura> findByAplicativo(long aplicativoId) {
        List<Assinatura> assinaturas = new LinkedList<>();
        String sql = "SELECT * FROM assinatura WHERE aplicativoId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, aplicativoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Assinatura assinatura = new Assinatura(
                        rs.getLong("id"),
                        rs.getLong("clienteId"),
                        rs.getLong("aplicativoId"),
                        rs.getDate("validade"),
                        rs.getBoolean("ativa")
                );
                assinaturas.add(assinatura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assinaturas;
    }
}
