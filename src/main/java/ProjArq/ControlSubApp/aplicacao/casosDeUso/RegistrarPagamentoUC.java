import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.PagamentoRepository;

@Service
public class RegistrarPagamentoUC{

    public RegistrarPagamentoUC (PagamentoRepository pagamentoRepository){
        this.pagamentoRepository = pagamentoRepository;
    }

    private PagamentoRepository pagamentoRepository;

    public void RegistrarPagamento(Date dataPagamento, Assinatura codAssinatura, Double valorPago){
        
    }
}