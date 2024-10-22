package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.aplicacao.dtos.AssinaturaDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssinaturasPorAplicativoUC {

    private final AssinaturaRepository assinaturaRepository;

    // Construtor injetando o repositório de assinaturas
    public AssinaturasPorAplicativoUC(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    // Método para listar assinaturas por código de aplicativo e tipo (TODAS, ATIVAS, CANCELADAS)
    public List<AssinaturaDTO> listarAssinaturasPorAplicativo(long codApp, String tipo) {
        List<Assinatura> todasAssinaturas = assinaturaRepository.findByAplicativoCodigo(codApp); // Busca assinaturas pelo aplicativo
        List<AssinaturaDTO> resultado = new ArrayList<>();
        Date dataAtual = new Date(); // Data atual para comparar as datas de vigência

        for (Assinatura assinatura : todasAssinaturas) {
            boolean incluir = false;

            // Verifica o tipo de filtro (TODAS, ATIVAS, CANCELADAS)
            switch (tipo.toUpperCase()) {
                case "TODAS":
                    incluir = true; // Inclui todas as assinaturas
                    break;
                case "ATIVAS":
                    // Assinatura ativa se a data de fim de vigência for posterior à data atual
                    if (assinatura.getFimVigencia().after(dataAtual)) {
                        incluir = true; // Inclui apenas assinaturas ativas
                    }
                    break;
                case "CANCELADAS":
                    // Assinatura cancelada se a data de fim de vigência for anterior à data atual
                    if (assinatura.getFimVigencia().before(dataAtual)) {
                        incluir = true; // Inclui apenas assinaturas canceladas
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de assinatura inválido: " + tipo);
            }

            if (incluir) {
                resultado.add(toDTO(assinatura)); // Converte e adiciona ao resultado
            }
        }

        return resultado; // Retorna a lista de DTOs
    }

    // Método auxiliar para converter Assinatura em AssinaturaDTO
    private AssinaturaDTO toDTO(Assinatura assinatura) {
        return new AssinaturaDTO(
                assinatura.getCodigo(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia(),
                assinatura.getFimVigencia().after(new Date()) ? "ATIVA" : "CANCELADA"
        );
    }
}
