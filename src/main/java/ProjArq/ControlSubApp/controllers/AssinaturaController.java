package ProjArq.ControlSubApp.controllers;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    private final AssinaturasPorTipoUC assinaturasPorTipoUC;
    private final CriarAssinaturaUC criarAssinaturaUC;
    private final ListarAssinaturasClienteUC listarAssinaturasClienteUC;
    private final ListarAssinaturasAplicativoUC listarAssinaturasAplicativoUC;

    public AssinaturaController(AssinaturasPorTipoUC assinaturasPorTipoUC, CriarAssinaturaUC criarAssinaturaUC,
                                ListarAssinaturasClienteUC listarAssinaturasClienteUC, ListarAssinaturasAplicativoUC listarAssinaturasAplicativoUC) {
        this.assinaturasPorTipoUC = assinaturasPorTipoUC;
        this.criarAssinaturaUC = criarAssinaturaUC;
        this.listarAssinaturasClienteUC = listarAssinaturasClienteUC;
        this.listarAssinaturasAplicativoUC = listarAssinaturasAplicativoUC;
    }

    @GetMapping("/{tipo}")
    public List<Assinatura> listarAssinaturasPorTipo(@PathVariable String tipo) {
        return assinaturasPorTipoUC.listarAssinaturas(tipo);
    }

    @GetMapping("/asscli/{codcli}")
    public List<Assinatura> listarAssinaturasPorCliente(@PathVariable long codcli) {
        return listarAssinaturasClienteUC.listarAssinaturas(codcli);
    }

    @GetMapping("/assapp/{codapp}")
    public List<Assinatura> listarAssinaturasPorAplicativo(@PathVariable long codapp) {
        return listarAssinaturasAplicativoUC.listarAssinaturas(codapp);
    }

    @PostMapping
    public Assinatura criarAssinatura(@RequestParam long codigoCliente, @RequestParam long codigoAplicativo) {
        return criarAssinaturaUC.criarAssinatura(codigoCliente, codigoAplicativo);
    }
}
