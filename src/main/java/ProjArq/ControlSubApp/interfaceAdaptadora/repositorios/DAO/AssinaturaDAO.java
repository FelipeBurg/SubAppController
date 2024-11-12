package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssinaturaDAO extends JpaRepository<Assinatura, Long> {

    // Método para buscar todas as assinaturas de um cliente específico
    List<Assinatura> findByClienteCodigo(long clienteCodigo);

    // Método para buscar todas as assinaturas de um aplicativo específico
    List<Assinatura> findByAplicativoCodigo(long aplicativoCodigo);
}