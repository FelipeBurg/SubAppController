package ProjArq.ControlSubApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProjArq.ControlSubApp.aplicacao.casosDeUso.CriarRegistroPagamentoUC;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.VerificarAssinaturaAtivaUC;
import ProjArq.ControlSubApp.aplicacao.dtos.PagamentoDTO;

@RestController
@RequestMapping("/registrarpagamento")
public class PagamentoController {

    private final CriarRegistroPagamentoUC criarRegistroPagamentoUC;
    private final VerificarAssinaturaAtivaUC verificarAssinaturaAtivaUC;

    public PagamentoController(CriarRegistroPagamentoUC criarRegistroPagamentoUC, VerificarAssinaturaAtivaUC verificarAssinaturaAtivaUC) {
        this.criarRegistroPagamentoUC = criarRegistroPagamentoUC;
        this.verificarAssinaturaAtivaUC = verificarAssinaturaAtivaUC;
    }

    // Endpoint para registrar um pagamento
    @PostMapping
    public PagamentoDTO registrarPagamento(
        @RequestParam long codAss, 
        @RequestParam int dia, 
        @RequestParam int mes,
        @RequestParam int ano, 
        @RequestParam double valorPago
    ) {
        return criarRegistroPagamentoUC.registrarPagamento(codAss, dia, mes, ano, valorPago);
    }

    // Endpoint para verificar se uma assinatura é válida
    @GetMapping("/assinvalida/{codass}")
    public boolean verificarAssinaturaValida(@PathVariable long codass) {
        return verificarAssinaturaAtivaUC.validarAssinatura(codass);
    }
}
