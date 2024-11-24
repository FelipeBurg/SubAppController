package ProjArq.ControlSubApp.controllers;

import ProjArq.ControlSubApp.aplicacao.casosDeUso.TodosClientesUC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.AtualizarCustoMensalUC;
import ProjArq.ControlSubApp.aplicacao.casosDeUso.TodosAplicativos;
import ProjArq.ControlSubApp.domain.entidades.Aplicativo;

import java.util.List;

@RestController
@RequestMapping("/aplicativos")
public class AplicativoController {

    private final TodosAplicativos todosAplicativos;
    private final AtualizarCustoMensalUC atualizarCustoMensalUC;

    public AplicativoController(TodosAplicativos todosAplicativos, AtualizarCustoMensalUC atualizarCustoMensalUC) {
        this.todosAplicativos = todosAplicativos;
        this.atualizarCustoMensalUC = atualizarCustoMensalUC;
    }

    // Endpoint para listar todos os aplicativos
    @GetMapping
    public ResponseEntity<List<Aplicativo>> listarAplicativos() {
        List<Aplicativo> aplicativos = todosAplicativos.listaAplicativos();
        return ResponseEntity.ok(aplicativos);
    }

    /*@GetMapping
    public ResponseEntity<List<Aplicativo>> listarAplicativos() {
        List<Aplicativo> aplicativos;

        // Consultar o AssCache primeiro
        aplicativos = assCacheService.getaplicativosFromCache();

        // Se não encontrar no cache, consulta o SCAA e atualiza o AssCache
        if (aplicativos == null || aplicativos.isEmpty()) {
            aplicativos = todosAplicativos.listaAplicativos();  // Consulta no SCAA

            // Atualiza o AssCache com os dados recebidos do SCAA
            assCacheService.updateCacheWithAplicativos(aplicativos);
        }

        return ResponseEntity.ok(aplicativos);
    }*/

    // Endpoint para atualizar o custo mensal de um aplicativo
    @PostMapping("/atualizacusto/{idAplicativo}")
    public ResponseEntity<Aplicativo> atualizarCusto(@PathVariable long idAplicativo, @RequestParam double custo) {
        Aplicativo app = atualizarCustoMensalUC.atualizarCustoMensal(idAplicativo, custo);
        if (app == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(app);
    }
}
