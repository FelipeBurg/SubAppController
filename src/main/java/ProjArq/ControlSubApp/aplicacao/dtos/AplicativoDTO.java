package ProjArq.ControlSubApp.aplicacao.dtos;

import ProjArq.ControlSubApp.domain.entidades.Aplicativo;

public class AplicativoDTO {
    private long codigo;
    private String nome;
    private double custoMensal;

    public AplicativoDTO(long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }

    public static AplicativoDTO fromModel(Aplicativo aplicativo) {
        return new AplicativoDTO(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }
}
