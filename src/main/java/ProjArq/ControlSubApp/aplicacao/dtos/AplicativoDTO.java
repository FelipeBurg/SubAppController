package ProjArq.ControlSubApp.aplicacao.dtos;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Aplicativo;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Assinatura;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;

public class AplicativoDTO {
    private long id;
    private String nome;
    private double custoMensal;

    public AplicativoDTO(long id, String nome, double custoMensal) {
    this.id = id;
    this.nome = nome;
    this.custoMensal = custoMensal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public static AplicativoDTO fromModel(Aplicativo aplicativo) {
        return new AplicativoDTO(aplicativo.getCodigo(), aplicativo.getNome(), aplicativo.getCustoMensal());
    }

}
