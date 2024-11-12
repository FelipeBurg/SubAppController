package ProjArq.ControlSubApp.aplicacao.dtos;

import java.util.Date;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;

public class AssinaturaDTO {
    private long id;
    private long clienteId;
    private long aplicativoId;
    private Date inicioVigencia;
    private Date fimVigencia;
    private String status; // Novo campo

    public AssinaturaDTO(long id, long clienteId, long aplicativoId, Date inicioVigencia, Date fimVigencia, String status) {
        this.id = id;
        this.clienteId = clienteId;
        this.aplicativoId = aplicativoId;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.status = status; // Status adicionado no construtor
    }

    // Getters e Setters

    public AssinaturaDTO(Assinatura assinatura) {
        //TODO Auto-generated constructor stub
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

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método para converter o modelo Assinatura para o DTO
    public static AssinaturaDTO fromModel(Assinatura assinatura) {
        long clienteId = assinatura.getCliente().getCodigo();
        long aplicativoId = assinatura.getAplicativo().getCodigo();
        Date dataAtual = new Date();

        // Determinando o status com base na data de vigência
        String status = assinatura.getFimVigencia().after(dataAtual) ? "ATIVA" : "CANCELADA";

        return new AssinaturaDTO(
            assinatura.getCodigo(),
            clienteId,
            aplicativoId,
            assinatura.getInicioVigencia(),
            assinatura.getFimVigencia(),
            status  // Incluindo o status no DTO
        );
    }
}
