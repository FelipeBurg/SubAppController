package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.aplicacao.dtos.PagamentoDTO;
import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.domain.entidades.Pagamento;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AplicativoRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.AssinaturaRepository;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.PagamentoRepository;

import java.time.LocalDate;
import java.util.Date;

@Service
public class CriarRegistroPagamentoUC {
    private final AssinaturaRepository assinaturaRepository;
    private final PagamentoRepository pagamentoRepository;
    private final AplicativoRepository aplicativoRepository;

    public CriarRegistroPagamentoUC(AssinaturaRepository assinaturaRepository, PagamentoRepository pagamentoRepository, AplicativoRepository aplicativoRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.aplicativoRepository = aplicativoRepository;
    }

    public PagamentoDTO registrarPagamento(long codAss, int dia, int mes, int ano, double valorPago) {
        Assinatura assinatura = assinaturaRepository.findById(codAss);
        if (assinatura == null) { // Verifica se a assinatura é nula
            return new PagamentoDTO("VALOR_INCORRETO", null, 0);
        }

        Aplicativo aplicativo = aplicativoRepository.findById(assinatura.getAplicativo_codigo());
        if (aplicativo == null) {
            return new PagamentoDTO("VALOR_INCORRETO", null, 0);
        }

        double valorMensal = aplicativo.getCustoMensal();

        if (valorPago < valorMensal) {
            return new PagamentoDTO("VALOR_INCORRETO", null, valorPago);
        }

        if (valorPago > valorMensal) {
            return new PagamentoDTO("VALOR_INCORRETO", null, valorPago - valorMensal);
        }

        Date dataPagamento = Date.from(LocalDate.of(ano, mes, dia).atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant());

        Pagamento pagamento = new Pagamento(0, valorPago, dataPagamento, null, assinatura.getCodigo());
        pagamentoRepository.save(pagamento);

        return new PagamentoDTO("PAGAMENTO_OK", dataPagamento, 0);
    }
}

