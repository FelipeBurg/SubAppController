package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.ClienteRepository;
import ProjArq.ControlSubApp.domain.entidades.Aplicativo;

import java.util.List;

@Service
public class TodosAplicativos {
    private AplicativoRepository aplicativo;

    public TodosAplicativos(AplicativoRepository aplicativoRepository){
        this.aplicativo = aplicativoRepository;
    }
    public List<Aplicativo> listaAplicativos() {
        return aplicativo.findAll();
    }
}
