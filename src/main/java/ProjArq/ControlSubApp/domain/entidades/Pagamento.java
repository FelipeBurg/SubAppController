package ProjArq.ControlSubApp.domain.entidades;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    @ManyToOne
    @JoinColumn(name = "assinatura_codigo", referencedColumnName = "codigo")
    private Assinatura assinatura;

    private double valorPago;
    private Date dataPagamento;
    private String promocao;

    // Construtor completo
    public Pagamento(long codigo, double valorPago, Date dataPagamento, String promocao, Assinatura assinatura) {
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.assinatura = assinatura;
    }

    // Construtor vazio
    public Pagamento() {}

    // Getters e Setters
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
}
