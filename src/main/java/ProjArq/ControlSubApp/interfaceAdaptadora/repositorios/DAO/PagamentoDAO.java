package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import ProjArq.ControlSubApp.domain.entidades.Pagamento;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.PagamentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagamentoDAO implements PagamentoRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public PagamentoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Override
    public Pagamento findById(long codigo) {
        return entityManager.find(Pagamento.class, codigo);
    }

    @Override
    public List<Pagamento> findAll() {
            String jpql = "SELECT p FROM Pagamento p";
            return entityManager.createQuery(jpql, Pagamento.class).getResultList();
        }

    @Override
    public void save(Pagamento pagamento) {
        entityManager.persist(pagamento);
    }
}