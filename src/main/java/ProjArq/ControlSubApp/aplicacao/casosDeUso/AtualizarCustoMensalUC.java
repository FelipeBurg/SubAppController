package ProjArq.ControlSubApp.aplicacao.casosDeUso;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.domain.entidades.Aplicativo;

import java.util.List;

public class AtualizarCustoMensalUC {

    private final AplicativoRepository aplicativoRepository;

    // O repositório é passado via construtor
    public AtualizarCustoMensalUC(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    // Método para atualizar o custo mensal
    public void atualizarCustoMensal(long codigo, double valor) {
        // Busca todos os aplicativos
        List<Aplicativo> aplicativos = aplicativoRepository.findAll();

        // Procura o aplicativo pelo código e atualiza o custo
        for (Aplicativo app : aplicativos) {
            if (app.getCodigo() == codigo) {
                app.setCustoMensal(valor);  // Atualiza o custo mensal no objeto Aplicativo
                aplicativoRepository.update(app);  // Atualiza o aplicativo no banco
            }
        }
    }
}
