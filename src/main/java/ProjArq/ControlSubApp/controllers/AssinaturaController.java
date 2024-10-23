import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    private final AssinaturasPorTipoUC assinaturasPorTipoUC;
    private final CriarAssinaturaUC criarAssinaturaUC;
    private final AssinaturasDoClienteUC assinaturasDoClienteUC;  // Corrigido o nome do UC
    private final AssinaturasPorAplicativoUC assinaturasPorAplicativoUC; // Corrigido o nome do UC

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
    public List<AssinaturaDTO> listarAssinaturasPorAplicativo(@PathVariable long codapp) {
        return assinaturasPorAplicativoUC.listarAssinaturasPorAplicativo(codapp, "TODAS"); 
    }

    @PostMapping
    public Assinatura criarAssinatura(@RequestParam long codigoCliente, @RequestParam long codigoAplicativo) {
        return criarAssinaturaUC.criarAssinatura(codigoCliente, codigoAplicativo);
    }
}
