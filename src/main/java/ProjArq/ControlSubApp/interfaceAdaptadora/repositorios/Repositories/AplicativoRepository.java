package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories;

import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AplicativoRepository{
    Aplicativo findById(long codigo);

    List<Aplicativo> findAll(long cliente_codigo);

    void save(Aplicativo aplicativo);

    void update(Aplicativo aplicativo);
}
