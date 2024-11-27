package ProjArq.ControlSubApp.controllers;

import ProjArq.ControlSubApp.aplicacao.casosDeUso.TodosClientesUC;
import ProjArq.ControlSubApp.domain.entidades.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login/clientes")
public class ClienteController {

    private final TodosClientesUC todosClientesUC;

    public ClienteController(TodosClientesUC todosClientesUC) {
        this.todosClientesUC = todosClientesUC;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = todosClientesUC.listaClientes();
        return ResponseEntity.ok(clientes);
    }
}
