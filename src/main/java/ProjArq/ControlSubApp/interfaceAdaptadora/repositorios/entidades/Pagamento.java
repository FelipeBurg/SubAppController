package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades;

import java.util.Date;

public class Pagamento {
    private long codigo;
    private double valorPago;
    private Date dataPagamento;
    private String promocao;
    private Assinatura assinatura;

    public Pagamento(long codigo, double valorPago, Date dataPagamento, String promocao, Assinatura assinatura) {
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
        this.assinatura = assinatura;
    }

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

    public Assinatura getAssinatura() {
        return assinatura;
    }
}
