import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.domain.entidades.Assinatura;

@Service
public class AssinaturasDoClienteUC{

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturasDoClienteUC (AssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<Assinatura> execute(long clienteCodigo) {
        return assinaturaRepository.findA(clienteCodigo);
    }



}