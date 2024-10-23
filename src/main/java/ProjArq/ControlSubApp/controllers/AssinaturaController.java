package ProjArq.ControlSubApp.controllers;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    private final AssinaturasPorTipoUC assinaturasPorTipoUC;
    private final CriarAssinaturaUC criarAssinaturaUC;
    private final AssinaturasDoClienteUC assinaturasDoClienteUC;
    private final AssinaturasPorAplicativoUC assinaturasPorAplicativoUC;

    public AssinaturaController(AssinaturasPorTipoUC assinaturasPorTipoUC, CriarAssinaturaUC criarAssinaturaUC,
                                AssinaturasDoClienteUC assinaturasDoClienteUC, AssinaturasPorAplicativoUC assinaturasPorAplicativoUC) {
        this.assinaturasPorTipoUC = assinaturasPorTipoUC;
        this.criarAssinaturaUC = criarAssinaturaUC;
        this.assinaturasDoClienteUC = assinaturasDoClienteUC;
        this.assinaturasPorAplicativoUC = assinaturasPorAplicativoUC;
    }

    @GetMapping("/{tipo}")
    public List<Assinatura> listarAssinaturasPorTipo(@PathVariable String tipo) {
        return assinaturasPorTipoUC.listarAssinaturas(tipo);
    }

    @GetMapping("/asscli/{codcli}")
    public List<Assinatura> listarAssinaturasPorCliente(@PathVariable long codcli) {
        return assinaturasDoClienteUC.execute(codcli);
    }

    @GetMapping("/assapp/{codapp}")
    public List<Assinatura> listarAssinaturasPorAplicativo(@PathVariable long codapp) {
        return assinaturasPorAplicativoUC.listarAssinaturasPorAplicativo(codapp, "TODAS");
    }

    @PostMapping
    public Assinatura criarAssinatura(@RequestParam long codigoCliente,
                                      @RequestParam long codigoAplicativo,
                                      @RequestParam int diaInicio,
                                      @RequestParam int mesInicio,
                                      @RequestParam int anoInicio,
                                      @RequestParam int diaFim,
                                      @RequestParam int mesFim,
                                      @RequestParam int anoFim) {
        // Converte as datas de início e fim para LocalDate
        LocalDate dataInicio = LocalDate.of(anoInicio, mesInicio, diaInicio);
        LocalDate dataFim = LocalDate.of(anoFim, mesFim, diaFim);

        // Chama o caso de uso para criar a assinatura
        return criarAssinaturaUC.criarAssinatura(codigoCliente, codigoAplicativo, dataInicio, dataFim);
    }
}
