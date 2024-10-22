package ProjArq.ControlSubApp.controllers;

import ProjArq.ControlSubApp.domain.entidades.Aplicativo;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.AtualizarCustoMensalUC;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.TodosAplicativos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {

    private final TodosAplicativos todosAplicativos;
    private final AtualizarCustoMensalUC atualizarCustoMensalUC;

    public AplicativoController(TodosAplicativos todosAplicativos, AtualizarCustoMensalUC atualizarCustoMensalUC) {
        this.todosAplicativos = todosAplicativos;
        this.atualizarCustoMensalUC = atualizarCustoMensalUC;
    }

    @GetMapping
    public List<Aplicativo> listarAplicativos() {
        return todosAplicativos.listaAplicativos();
    }

    @PostMapping("/atualizacusto/{idAplicativo}")
    public Aplicativo atualizarCusto(@PathVariable long idAplicativo, @RequestParam double custo) {
        return atualizarCustoMensalUC.atualizarCustoMensal(idAplicativo, custo);
    }
}
