package ProjArq.ControlSubApp.aplicacao.dtos;

import java.util.Date;

public class PagamentoDTO {
    private long codigo;
    private double valorPago;
    private Date dataPagamento;
    private String promocao;
    private Assinatura assinatura;

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

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public void setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
    }
}
