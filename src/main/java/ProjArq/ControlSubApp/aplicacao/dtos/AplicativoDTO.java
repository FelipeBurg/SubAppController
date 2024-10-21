package ProjArq.ControlSubApp.aplicacao.dtos;

public class AplicativoDTO {
    private long codigo;
    private String nome;
    private double custoMensal;

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

    public void setCustoMensal(double preco) {
        this.custoMensal = custoMensal;
    }
}
