package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Pagamento;

import java.util.List;

public interface PagamentoRepository {
    Pagamento findById(long codigo);

    List<Pagamento> findAll();

    void save(Pagamento pagamento);

    void deleteById(long codigo);
}
