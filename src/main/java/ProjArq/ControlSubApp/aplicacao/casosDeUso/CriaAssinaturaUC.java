package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CriaAssinaturaUC {

    private final AssinaturaRepository assinaturaRepository;
    private final ClienteRepository clienteRepository;
    private final AplicativoRepository aplicativoRepository;

    // Injeção de dependências via construtor
    public CriaAssinaturaUC(AssinaturaRepository assinaturaRepository, ClienteRepository clienteRepository, AplicativoRepository aplicativoRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.clienteRepository = clienteRepository;
        this.aplicativoRepository = aplicativoRepository;
    }

    // Método para criar uma nova assinatura
    public Assinatura criarAssinatura(long clienteId, long aplicativoId, LocalDate dataInicio, LocalDate dataFim) {
        // Verifica se o cliente existe
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        if (!clienteOptional.isPresent()) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        // Verifica se o aplicativo existe
        Optional<Aplicativo> aplicativoOptional = aplicativoRepository.findById(aplicativoId);
        if (!aplicativoOptional.isPresent()) {
            throw new IllegalArgumentException("Aplicativo não encontrado");
        }

        // Cria uma nova assinatura
        Assinatura novaAssinatura = new Assinatura();
        novaAssinatura.setClienteCodigo(clienteId);
        novaAssinatura.setAplicativoCodigo(aplicativoId);
        novaAssinatura.setInicioVigencia(java.sql.Date.valueOf(dataInicio));  // Converte LocalDate para Date
        novaAssinatura.setFimVigencia(java.sql.Date.valueOf(dataFim));

        // Salva a assinatura no repositório
        assinaturaRepository.save(novaAssinatura);

        // Retorna a assinatura criada
        return novaAssinatura;
    }
}
