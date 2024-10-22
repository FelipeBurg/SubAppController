package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.ClienteRepository;
import ProjArq.ControlSubApp.domain.entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteDao implements ClienteRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Cliente findById(long codigo) {
        return entityManager.find(Cliente.class, codigo);
    }

    @Override
    public List<Cliente> findAll() {
        String jpql = "SELECT c FROM Cliente c";
        return entityManager.createQuery(jpql, Cliente.class).getResultList();
    }

    @Override
    public void save(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        entityManager.persist(cliente);
    }
}