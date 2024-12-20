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
@RequestMapping("/assinaturas")
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

   /* private final AssinaturasPorTipoUC assinaturasPorTipoUC;
    private final CriaAssinaturaUC criarAssinaturaUC;
    private final AssinaturasDoClienteUC assinaturasDoClienteUC;
    private final AssinaturasPorAplicativoUC assinaturasPorAplicativoUC;
    private final AssCacheService assCacheService;  // Dependência para AssCache

    public AssinaturaController(AssinaturasPorTipoUC assinaturasPorTipoUC, CriaAssinaturaUC criarAssinaturaUC,
                                AssinaturasDoClienteUC assinaturasDoClienteUC, AssinaturasPorAplicativoUC assinaturasPorAplicativoUC,
                                AssCacheService assCacheService) {
        this.assinaturasPorTipoUC = assinaturasPorTipoUC;
        this.criarAssinaturaUC = criarAssinaturaUC;
        this.assinaturasDoClienteUC = assinaturasDoClienteUC;
        this.assinaturasPorAplicativoUC = assinaturasPorAplicativoUC;
        this.assCacheService = assCacheService;
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorTipo(@PathVariable String tipo) {
        List<AssinaturaDTO> assinaturas = assCacheService.getAssinaturasPorTipoFromCache(tipo);

        // Se não encontrar no cache, consulta o banco (SCAA) e atualiza o cache
        if (assinaturas == null || assinaturas.isEmpty()) {
            assinaturas = assinaturasPorTipoUC.listarAssinaturas(tipo).stream()
                    .map(assinatura -> new AssinaturaDTO(assinatura))
                    .collect(Collectors.toList());

            // Atualiza o cache com as assinaturas encontradas
            assCacheService.updateCacheWithAssinaturasPorTipo(tipo, assinaturas);
        }

        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/cliente/{codcli}")
    public ResponseEntity<List<Assinatura>> listarAssinaturasPorCliente(@PathVariable long codcli) {
        List<Assinatura> assinaturas = assCacheService.getAssinaturasDoClienteFromCache(codcli);

        // Se não encontrar no cache, consulta o banco (SCAA) e atualiza o cache
        if (assinaturas == null || assinaturas.isEmpty()) {
            assinaturas = assinaturasDoClienteUC.listarAssinaturasDoCliente(codcli);

            // Atualiza o cache com as assinaturas do cliente
            assCacheService.updateCacheWithAssinaturasDoCliente(codcli, assinaturas);
        }

        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/aplicativo/{codapp}")
    public ResponseEntity<List<AssinaturaDTO>> listarAssinaturasPorAplicativo(@PathVariable long codapp) {
        List<AssinaturaDTO> assinaturas = assCacheService.getAssinaturasPorAplicativoFromCache(codapp);

        // Se não encontrar no cache, consulta o banco (SCAA) e atualiza o cache
        if (assinaturas == null || assinaturas.isEmpty()) {
            assinaturas = assinaturasPorAplicativoUC.listarAssinaturasPorAplicativo(codapp, "TODAS");

            // Atualiza o cache com as assinaturas do aplicativo
            assCacheService.updateCacheWithAssinaturasPorAplicativo(codapp, assinaturas);
        }

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

        // Atualiza o cache após a criação de uma nova assinatura
        String message = "Assinatura criada/atualizada: Cliente " + codigoCliente + ", Aplicativo " + codigoAplicativo;
        assCachePublisherService.notifyAssCache(message);
        return ResponseEntity.ok(assinatura);
    }*/
}