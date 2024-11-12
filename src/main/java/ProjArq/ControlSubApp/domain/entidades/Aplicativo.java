package ProjArq.ControlSubApp.domain.entidades;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    private String nome;
    private double custoMensal;

    public Aplicativo(long codigo, String nome, double custoMensal) {
        this.codigo = codigo;
        this.nome = nome;
        this.custoMensal = custoMensal;
    }

    public Aplicativo() {
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

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }

    // Corrigir o mappedBy para referenciar a propriedade 'aplicativo' na entidade Assinatura
    @OneToMany(mappedBy = "aplicativo")
    private Collection<Assinatura> assinaturas;

    public Collection<Assinatura> getAssinaturas() {
        return assinaturas;
    }

    public void setAssinaturas(Collection<Assinatura> assinaturas) {
        this.assinaturas = assinaturas;
    }
}
