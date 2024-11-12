package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.domain.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {

    // Caso você precise de um método personalizado para busca
    List<Cliente> findByNome(String nome);
}
