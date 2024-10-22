package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.domain.entidades.Assinatura;
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
            stmt.setDate(2, (Date) assinatura.getInicioVigencia());
            stmt.setDate(3, new java.sql.Date(assinatura.getFimVigencia().getTime()));
            stmt.setLong(4, assinatura.getAplicativo_codigo());
            stmt.setLong(5, assinatura.getCliente_codigo());
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
            stmt.setDate(2, (Date) assinatura.getFimVigencia());
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

                assinatura = new Assinatura(
                        rs.getLong("codigo"),
                        rs.getTimestamp("inicioVigencia"),
                        rs.getDate("fimVigencia"),
                        clienteCodigo,
                        aplicativoCodigo
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assinatura;
    }
@Override
    public List<Assinatura> findAll(long clienteId) {
        List<Assinatura> assinaturas = new LinkedList<>();
        String sql = "SELECT * FROM assinatura WHERE clienteId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, clienteId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Assinatura assinatura = new Assinatura(
                        rs.getLong("codigo"),
                        rs.getTimestamp("inicioVigencia"),
                        rs.getDate("fimVigencia"),
                        rs.getLong("cliente_codigo"),
                        rs.getLong("aplicativo_codigo")
                );
                assinaturas.add(assinatura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assinaturas;
    }

    public List<Assinatura> findByAplicativo(long aplicativoId) {
        List<Assinatura> assinaturas = new LinkedList<>();
        String sql = "SELECT * FROM assinatura WHERE aplicativoId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, aplicativoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Assinatura assinatura = new Assinatura(
                        rs.getLong("codigo"),
                        rs.getTimestamp("inicioVigencia"),
                        rs.getDate("fimVigencia"),
                        rs.getLong("cliente_codigo"),
                        rs.getLong("aplicativo_codigo")
                );
                assinaturas.add(assinatura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assinaturas;
    }
}
