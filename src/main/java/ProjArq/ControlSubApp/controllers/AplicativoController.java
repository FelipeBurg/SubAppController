package ProjArq.ControlSubApp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProjArq.ControlSubApp.aplicacao.casosDeUso.AtualizarCustoMensalUC;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.TodosAplicativos;
import ProjArq.ControlSubApp.domain.entidades.Aplicativo;

@RestController
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {

    private final TodosAplicativos todosAplicativos;
    private final AtualizarCustoMensalUC atualizarCustoMensalUC;

    public AplicativoController(TodosAplicativos todosAplicativos, AtualizarCustoMensalUC atualizarCustoMensalUC) {
        this.todosAplicativos = todosAplicativos;
        this.atualizarCustoMensalUC = atualizarCustoMensalUC;
    }

    // Endpoint para listar todos os aplicativos
    @GetMapping
    public List<Aplicativo> listarAplicativos() {
        return todosAplicativos.listaAplicativos();
    }

    // Endpoint para atualizar o custo mensal de um aplicativo
    @PostMapping("/atualizacusto/{idAplicativo}")
    public Aplicativo atualizarCusto(@PathVariable long idAplicativo, @RequestParam double custo) {
        return atualizarCustoMensalUC.atualizarCustoMensal(idAplicativo, custo);
    }
}
