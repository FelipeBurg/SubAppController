package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories;

import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
    // Usa Optional para permitir retornos nulos
    Optional<Aplicativo> findById(Long codigo);

    // Este método retorna todos os aplicativos sem argumento
    List<Aplicativo> findAll();

    // Os métodos save e update são automaticamente gerenciados pelo JpaRepository
}
