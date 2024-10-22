package ProjArq.ControlSubApp.controllers;

import ProjArq.ControlSubApp.domain.entidades.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/clientes")
public class ClienteController {

    private final TodosClientesUC todosClientesUC;

    public ClienteController(TodosClientesUC todosClientesUC) {
        this.todosClientesUC = todosClientesUC;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return todosClientesUC.listaClientes();
    }
}
