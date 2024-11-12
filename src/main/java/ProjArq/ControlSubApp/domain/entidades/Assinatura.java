package ProjArq.ControlSubApp.domain.entidades;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    private Timestamp inicioVigencia;
    private Date fimVigencia;

    @ManyToOne
    @JoinColumn(name = "cliente_codigo", referencedColumnName = "codigo")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "aplicativo_codigo", referencedColumnName = "codigo")
    private Aplicativo aplicativo;

    private String tipo;

    // Construtor completo com Cliente e Aplicativo
    public Assinatura(long codigo, Timestamp inicioVigencia, Date fimVigencia, Cliente cliente, Aplicativo aplicativo) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.cliente = cliente;
        this.aplicativo = aplicativo;
    }

    // Construtor vazio
    public Assinatura() {
    }

    // Getters e Setters

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Timestamp getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Timestamp inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
