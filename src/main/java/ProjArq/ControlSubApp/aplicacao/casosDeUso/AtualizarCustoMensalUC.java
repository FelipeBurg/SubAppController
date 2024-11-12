package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtualizarCustoMensalUC {

    private final AplicativoRepository aplicativoRepository;

    public AtualizarCustoMensalUC(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    public Aplicativo atualizarCustoMensal(long codigo, double valor) {
        Optional<Aplicativo> aplicativoOptional = aplicativoRepository.findById(codigo);

        if (!aplicativoOptional.isPresent()) {
            throw new IllegalArgumentException("Aplicativo não encontrado com o código: " + codigo);
        }
        
        Aplicativo aplicativo = aplicativoOptional.get();
        aplicativo.setCustoMensal(valor);
        aplicativoRepository.save(aplicativo);
        
        return aplicativo;
    }
}
