package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.DAO;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.domain.entidades.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoDAO extends JpaRepository<Assinatura, Long> {

    // Método para buscar todas as assinaturas de um cliente específico
    List<Pagamento> findByClienteCodigo(long clienteCodigo);

    // Método para buscar todas as assinaturas de um aplicativo específico
    List<Pagamento> findByAplicativoCodigo(long aplicativoCodigo);
}