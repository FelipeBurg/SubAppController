package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodosAplicativos {
    private final AplicativoRepository aplicativoRepository;

    public TodosAplicativos(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public List<Aplicativo> listaAplicativos() {
        return aplicativoRepository.findAll();
    }
}
