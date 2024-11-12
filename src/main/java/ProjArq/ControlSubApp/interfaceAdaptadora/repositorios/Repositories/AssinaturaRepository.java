package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByClienteCodigo(long clienteCodigo);
    // Usa Optional para permitir retornos nulos
    Optional<Assinatura> findById(Long codigo);

    List<Assinatura> findAll();

    List<Assinatura> findByClienteCodigo(Long clienteCodigo); // Método personalizado

    List<Assinatura> findByAplicativoCodigo(Long codApp);

    // Se necessário um método para listar por tipo
    List<Assinatura> findAllByTipo(String tipo);
}
;