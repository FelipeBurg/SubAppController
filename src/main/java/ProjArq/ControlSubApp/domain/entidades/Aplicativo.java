package ProjArq.ControlSubApp.domain.entidades;

public class Aplicativo {
    private long codigo;
    private String nome;
    private double custoMensal;

    public Aplicativo(long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }


    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoMensal() {
        return custoMensal;
    }
}
