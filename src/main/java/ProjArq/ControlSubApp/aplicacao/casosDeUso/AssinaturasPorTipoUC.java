package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssinaturasPorTipoUC {

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturasPorTipoUC(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<Assinatura> listarAssinaturas(String tipo) {
        List<Assinatura> todasAssinaturas = assinaturaRepository.findAllByTipo(tipo);
        List<Assinatura> resultado = new ArrayList<>();
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
                resultado.add(assinatura);
            }
        }

        return resultado;
    }
}
