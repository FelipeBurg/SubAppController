package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories;

import ProjArq.ControlSubApp.domain.entidades.Cliente;
import ProjArq.ControlSubApp.domain.entidades.Pagamento;

import java.util.List;

public interface PagamentoRepository {
    Pagamento findById(long codigo);

    List<Pagamento> findAll();

    void save(Pagamento pagamento);
}
