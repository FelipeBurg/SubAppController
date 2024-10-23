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

    // Método para atualizar o custo mensal de um aplicativo específico
    public Aplicativo atualizarCustoMensal(long codigo, double valor) {
        // Busca o aplicativo pelo código
        Optional<Aplicativo> aplicativoOptional = aplicativoRepository.findByCodigo(codigo);

        // Se o aplicativo for encontrado, atualiza o custo
        if (aplicativoOptional.isPresent()) {
            Aplicativo aplicativo = aplicativoOptional.get();
            aplicativo.setCustoMensal(valor);  // Atualiza o custo mensal

            aplicativoRepository.update(aplicativo);  // Salva a atualização no banco de dados

            return aplicativo;  // Retorna o aplicativo atualizado
        } else {
            // Se não for encontrado, lança uma exceção
            throw new IllegalArgumentException("Aplicativo não encontrado com o código: " + codigo);
        }
    }
}
