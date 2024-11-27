package ProjArq.ControlSubApp.controllers;

import ProjArq.ControlSubApp.domain.entidades.Assinatura;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.*;
import ProjArq.ControlSubApp.aplicacao.dtos.AssinaturaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@RestController
@RequestMapping("/login/assinaturas")
public class AssinaturaController {

    private final AssinaturasPorTipoUC assinaturasPorTipoUC;
    private final CriaAssinaturaUC criarAssinaturaUC;
    private final AssinaturasDoClienteUC assinaturasDoClienteUC;
    private final AssinaturasPorAplicativoUC assinaturasPorAplicativoUC;

    public AssinaturaController(AssinaturasPorTipoUC assinaturasPorTipoUC, CriaAssinaturaUC criarAssinaturaUC,
                                AssinaturasDoClienteUC assinaturasDoClienteUC, AssinaturasPorAplicativoUC assinaturasPorAplicativoUC) {
        this.assinaturasPorTipoUC = assinaturasPorTipoUC;
        this.criarAssinaturaUC = criarAssinaturaUC;
        this.assinaturasDoClienteUC = assinaturasDoClienteUC;
        this.assinaturasPorAplicativoUC = assinaturasPorAplicativoUC;
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorTipo(@PathVariable String tipo) {
        List<AssinaturaDTO> assinaturas = assinaturasPorTipoUC.listarAssinaturas(tipo).stream()
                .map(assinatura -> new AssinaturaDTO(assinatura))
                .collect(Collectors.toList());
        return ResponseEntity.ok(assinaturas);
    }


    @GetMapping("/cliente/{codcli}")
    public ResponseEntity<List<Assinatura>> listarAssinaturasPorCliente(@PathVariable long codcli) {
        List<Assinatura> assinaturas = assinaturasDoClienteUC.listarAssinaturasDoCliente(codcli); // Corrigido aqui
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/aplicativo/{codapp}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorAplicativo(@PathVariable long codapp) {
        List<AssinaturaDTO> assinaturas = assinaturasPorAplicativoUC.listarAssinaturasPorAplicativo(codapp, "TODAS");
        return ResponseEntity.ok(assinaturas);
    }

    @PostMapping
    public ResponseEntity<Assinatura> criarAssinatura(@RequestParam long codigoCliente,
                                                      @RequestParam long codigoAplicativo,
                                                      @RequestParam int diaInicio,
                                                      @RequestParam int mesInicio,
                                                      @RequestParam int anoInicio,
                                                      @RequestParam int diaFim,
                                                      @RequestParam int mesFim,
                                                      @RequestParam int anoFim) {
        LocalDate dataInicio = LocalDate.of(anoInicio, mesInicio, diaInicio);
        LocalDate dataFim = LocalDate.of(anoFim, mesFim, diaFim);

        Assinatura assinatura = criarAssinaturaUC.criarAssinatura(codigoCliente, codigoAplicativo, dataInicio, dataFim);
        return ResponseEntity.ok(assinatura);
    }
}