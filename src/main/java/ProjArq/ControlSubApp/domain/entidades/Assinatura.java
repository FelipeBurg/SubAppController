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
    private long cliente_codigo;
    @ManyToOne
    @JoinColumn(name = "aplicativo_codigo", referencedColumnName = "codigo")
    private long aplicativo_codigo;

    public Assinatura(long codigo, Timestamp inicioVigencia, Date fimVigencia, long cliente_codigo, long aplicativo_codigo) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.cliente_codigo = cliente_codigo;
        this.aplicativo_codigo = aplicativo_codigo;
    }

    public Assinatura() {
    }

    public long getCodigo() {
        return codigo;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public long getCliente() {
        return cliente_codigo;
    }

    public long getAplicativo() {
        return aplicativo_codigo;
    }

    @ManyToOne(optional = false)
    private Aplicativo a;

    public Aplicativo getA() {
        return a;
    }

    public void setA(Aplicativo a) {
        this.a = a;
    }
}
