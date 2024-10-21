package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Assinatura;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;

import java.util.List;

public interface AssinaturaRepository {
    Assinatura findById(long codigo);

    List<Assinatura> findAll();

    void save(Assinatura assinatura);

    void update(Assinatura assinatura);
}
