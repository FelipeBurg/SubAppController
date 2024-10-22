package ProjArq.ControlSubApp.domain.entidades;

import java.sql.Timestamp;
import java.util.Date;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;

public class Assinatura {
    private long codigo;
    private Timestamp inicioVigencia;
    private Date fimVigencia;
    private ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente cliente;
    private Aplicativo aplicativo;

    public Assinatura(long codigo, Timestamp inicioVigencia, Date fimVigencia, Cliente cliente, Aplicativo aplicativo) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.cliente = cliente;
        this.aplicativo = aplicativo;
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

    public Cliente getCliente() {
        return cliente;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }
}
