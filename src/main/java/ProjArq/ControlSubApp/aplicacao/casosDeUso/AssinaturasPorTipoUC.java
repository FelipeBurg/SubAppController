package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.domain.entidades.Assinatura;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssinaturasPorTipoUC {

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturasPorTipoUC(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public List<Assinatura> listarAssinaturas(String tipo) {
        List<Assinatura> todasAssinaturas = assinaturaRepository.findAll();
        List<Assinatura> resultado = new ArrayList<>();
        Date dataAtual = new Date();

        for (Assinatura assinatura : todasAssinaturas) {
            boolean incluir = false;

            switch (tipo.toUpperCase()) {
                case "TODAS":
                    incluir = true; // Inclui todas as assinaturas
                    break;
                case "ATIVAS":
                    // Assinatura ativa se a data de fim de vigência é posterior à data atual
                    if (assinatura.getFimVigencia().after(dataAtual)) {
                        incluir = true; // Inclui apenas assinaturas ativas
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
                resultado.add(assinatura); // Adiciona a assinatura ao resultado
            }
        }

        return resultado; // Retorna a lista filtrada
    }
}
