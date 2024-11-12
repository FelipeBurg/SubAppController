package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.domain.entidades.Cliente;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class CriaAssinaturaUC {

    private final AssinaturaRepository assinaturaRepository;
    private final ClienteRepository clienteRepository;
    private final AplicativoRepository aplicativoRepository;

    public CriaAssinaturaUC(AssinaturaRepository assinaturaRepository, ClienteRepository clienteRepository,
                            AplicativoRepository aplicativoRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.clienteRepository = clienteRepository;
        this.aplicativoRepository = aplicativoRepository;
    }


    public Assinatura criarAssinatura(long clienteId, long aplicativoId, LocalDate dataInicio, LocalDate dataFim) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        Aplicativo aplicativo = aplicativoRepository.findById(aplicativoId)
                .orElseThrow(() -> new IllegalArgumentException("Aplicativo não encontrado"));

        if (dataFim.isBefore(dataInicio)) {
            throw new IllegalArgumentException("A data de fim não pode ser anterior à data de início");
        }

        Assinatura novaAssinatura = new Assinatura();
        novaAssinatura.setCliente(cliente);  
        novaAssinatura.setAplicativo(aplicativo);

        LocalDateTime inicioVigenciaDateTime = dataInicio.atStartOfDay();
        novaAssinatura.setInicioVigencia(Timestamp.valueOf(inicioVigenciaDateTime));

        novaAssinatura.setFimVigencia(java.sql.Date.valueOf(dataFim));

        assinaturaRepository.save(novaAssinatura);

        return novaAssinatura;
    }
}
