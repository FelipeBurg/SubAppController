package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.domain.entidades.Pagamento;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class RegistrarPagamentoUC {

    private final PagamentoRepository pagamentoRepository;

    public RegistrarPagamentoUC(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public void registrarPagamento(Date dataPagamento, Assinatura assinatura, Double valorPago) {
        Pagamento pagamento = new Pagamento(0, valorPago, dataPagamento, null, assinatura);
        pagamentoRepository.save(pagamento);
    }
}
