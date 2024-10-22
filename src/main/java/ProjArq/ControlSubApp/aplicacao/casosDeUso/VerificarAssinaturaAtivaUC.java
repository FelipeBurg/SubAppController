package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;

import java.time.LocalDate;
import java.util.Date;

public class VerificarAssinaturaAtivaUC {
    private final AssinaturaRepository assinaturaRepository;

    public VerificarAssinaturaAtivaUC(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public boolean validarAssinatura(long codAss) {
        Assinatura assinatura = assinaturaRepository.findById(codAss);

        if (assinatura == null) {
            return false;
        }

        Date dataTermino = assinatura.getFimVigencia();

        if (dataTermino == null) {
            return false;
        }

        LocalDate localDateTermino = dataTermino.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

        LocalDate dataAtual = LocalDate.now();

        if (localDateTermino.isAfter(dataAtual)) {
            return true;
        } else {
            return false;
        }
    }
}

