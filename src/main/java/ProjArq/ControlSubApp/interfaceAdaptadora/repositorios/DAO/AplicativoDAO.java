package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AplicativoDAO extends JpaRepository<Aplicativo, Long> {
    // Método personalizado para buscar aplicativos por aplicativoId
    List<Aplicativo> findBycodigo(long codigo);
}
