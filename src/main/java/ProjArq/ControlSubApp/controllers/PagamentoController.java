package ProjArq.ControlSubApp.controllers;

import ProjArq.ControlSubApp.aplicacao.casosDeUso.*;
import ProjArq.ControlSubApp.aplicacao.dtos.PagamentoDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrarpagamento")
public class PagamentoController {

    private final CriarRegistroPagamentoUC criarRegistroPagamentoUC;
    private final VerificarAssinaturaAtivaUC verificarAssinaturaAtivaUC;

    public PagamentoController(CriarRegistroPagamentoUC criarRegistroPagamentoUC, VerificarAssinaturaAtivaUC verificarAssinaturaAtivaUC) {
        this.criarRegistroPagamentoUC = criarRegistroPagamentoUC;
        this.verificarAssinaturaAtivaUC = verificarAssinaturaAtivaUC;
    }

    @PostMapping
    public PagamentoDTO registrarPagamento(@RequestParam long codAss, @RequestParam int dia, @RequestParam int mes,
                                           @RequestParam int ano, @RequestParam double valorPago) {
        return criarRegistroPagamentoUC.registrarPagamento(codAss, dia, mes, ano, valorPago);
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean verificarAssinaturaValida(@PathVariable long codass) {
        return verificarAssinaturaAtivaUC.assinaturaAtiva(codass);
    }
}
