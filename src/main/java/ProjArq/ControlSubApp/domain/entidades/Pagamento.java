package ProjArq.ControlSubApp.domain.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    private double valorPago;
    private Date dataPagamento;
    private String promocao;
    private long assinatura_codigo;

    public Pagamento(long codigo, double valorPago, Date dataPagamento, String promocao, long assinatura_codigo) {
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.assinatura_codigo = assinatura_codigo;
    }
    public Pagamento(){}

    public long getCodigo() {
        return codigo;
    }

    public double getValorPago() {
        return valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public long getAssinatura_codigo() {
        return assinatura_codigo;
    }
}
