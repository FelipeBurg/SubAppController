package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import java.util.List;

public interface AssinaturaRepository {
    Assinatura findById(long codigo);

    List<Assinatura> findAll(long clienteId);

    void save(Assinatura assinatura);

    void update(Assinatura assinatura);
}
