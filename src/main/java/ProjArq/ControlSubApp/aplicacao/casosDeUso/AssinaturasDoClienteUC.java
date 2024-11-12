package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssinaturasDoClienteUC {

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturasDoClienteUC(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<Assinatura> listarAssinaturasDoCliente(long clienteCodigo) {
        return assinaturaRepository.findByClienteCodigo(clienteCodigo);
    }
}
