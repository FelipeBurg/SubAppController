package ProjArq.ControlSubApp.aplicacao.dtos;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Aplicativo;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Assinatura;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;

import java.util.Date;

public class AssinaturaDTO {
    private long id;
    private long clienteId;
    private long aplicativoId;
    private Date inicioVigencia;
    private Date fimVigencia;

    public AssinaturaDTO(long id, long clienteId, long aplicativoId, Date inicioVigencia, Date fimVigencia) {
        this.id = id;
        this.clienteId = clienteId;
        this.aplicativoId = aplicativoId;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public long getAplicativoId() {
        return aplicativoId;
    }

    public void setAplicativoId(long aplicativoId) {
        this.aplicativoId = aplicativoId;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public static AssinaturaDTO fromModel(Assinatura assinatura) {
        Cliente cliente = assinatura.getCliente();
        Aplicativo app = assinatura.getAplicativo();
        return new AssinaturaDTO(assinatura.getCodigo(),cliente.getCodigo(), app.getCodigo(), assinatura.getInicioVigencia(), assinatura.getFimVigencia());
    }
    }

