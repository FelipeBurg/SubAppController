package ProjArq.ControlSubApp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ProjArq.ControlSubApp.aplicacao.casosDeUso.CriarRegistroPagamentoUC;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.VerificarAssinaturaAtivaUC;
import ProjArq.ControlSubApp.aplicacao.dtos.PagamentoDTO;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final CriarRegistroPagamentoUC criarRegistroPagamentoUC;
    private final VerificarAssinaturaAtivaUC verificarAssinaturaAtivaUC;

    public PagamentoController(CriarRegistroPagamentoUC criarRegistroPagamentoUC, VerificarAssinaturaAtivaUC verificarAssinaturaAtivaUC) {
        this.criarRegistroPagamentoUC = criarRegistroPagamentoUC;
        this.verificarAssinaturaAtivaUC = verificarAssinaturaAtivaUC;
    }

    // Endpoint para registrar um pagamento
    @PostMapping
    public ResponseEntity<PagamentoDTO> registrarPagamento(
        @RequestParam long codAss, 
        @RequestParam int dia, 
        @RequestParam int mes,
        @RequestParam int ano, 
        @RequestParam double valorPago
    ) {
        PagamentoDTO pagamento = criarRegistroPagamentoUC.registrarPagamento(codAss, dia, mes, ano, valorPago);
        return ResponseEntity.ok(pagamento);
    }
}
