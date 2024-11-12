package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.aplicacao.dtos.AssinaturaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssinaturasPorAplicativoUC {

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturasPorAplicativoUC(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<AssinaturaDTO> listarAssinaturasPorAplicativo(long codApp, String tipo) {
        List<Assinatura> todasAssinaturas = assinaturaRepository.findByAplicativoCodigo(codApp);
        List<AssinaturaDTO> resultado = new ArrayList<>();
        Date dataAtual = new Date();

        for (Assinatura assinatura : todasAssinaturas) {
            boolean incluir = false;

            switch (tipo.toUpperCase()) {
                case "TODAS":
                    incluir = true;
                    break;
                case "ATIVAS":
                    if (assinatura.getFimVigencia().after(dataAtual)) {
                        incluir = true;
                    }
                    break;
                case "CANCELADAS":
                    if (assinatura.getFimVigencia().before(dataAtual)) {
                        incluir = true;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de assinatura inválido: " + tipo);
            }

            if (incluir) {
                resultado.add(toDTO(assinatura));
            }
        }

        return resultado;
    }

    private AssinaturaDTO toDTO(Assinatura assinatura) {
        return new AssinaturaDTO(
                assinatura.getCodigo(),
                assinatura.getCliente().getCodigo(),  // Obtém o código da entidade Cliente
                assinatura.getAplicativo().getCodigo(),  // Obtém o código da entidade Aplicativo
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia(),
                assinatura.getFimVigencia().after(new Date()) ? "ATIVA" : "CANCELADA"  // Define o status
        );
    }
}
