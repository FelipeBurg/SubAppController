package ProjArq.ControlSubApp.aplicacao.dtos;

import java.util.Date;

public class PagamentoDTO {
    private String status;
    private Date data;
    private double valorEstornado;

    public PagamentoDTO(String status, Date data, double valorEstornado) {
        this.status = status;
        this.data = data;
        this.valorEstornado = valorEstornado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorEstornado() {
        return valorEstornado;
    }

    public void setValorEstornado(double valorEstornado) {
        this.valorEstornado = valorEstornado;
    }
}
