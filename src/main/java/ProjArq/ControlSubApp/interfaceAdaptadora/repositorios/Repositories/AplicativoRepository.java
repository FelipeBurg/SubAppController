package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Aplicativo;
import java.util.List;

public interface AplicativoRepository {
    Aplicativo findById(long codigo);

    List<Aplicativo> findAll();

    void save(Aplicativo aplicativo);

    void update(Aplicativo aplicativo);
}
