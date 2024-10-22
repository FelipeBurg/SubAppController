package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class AplicativoDAO implements AplicativoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public AplicativoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Aplicativo aplicativo) {
        entityManager.persist(aplicativo);
    }

    @Override
    public void update(Aplicativo aplicativo) {
        entityManager.persist(aplicativo);
    }

    @Override
    public List<Aplicativo> findAll(long cliente_codigo) {
        String jpql = "SELECT a FROM Assinatura a WHERE a.cliente_codigo = :clienteId";
        return entityManager.createQuery(jpql, Aplicativo.class)
                .setParameter("clienteId", cliente_codigo)
                .getResultList();
    }

    @Override
    public Aplicativo findById(long id) {
        return entityManager.find(Aplicativo.class, id);
    }

    public List<Aplicativo> findByAplicativo(long aplicativoId) {
        String jpql = "SELECT a FROM Aplicativo a WHERE codigo = :aplicativoId";
        return entityManager.createQuery(jpql, Aplicativo.class)
                .setParameter("aplicativoId", aplicativoId)
                .getResultList();
    }
}
