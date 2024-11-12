package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.ClienteRepository;
import ProjArq.ControlSubApp.domain.entidades.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodosClientesUC {

    private final ClienteRepository clienteRepository;

    public TodosClientesUC(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listaClientes() {
        return clienteRepository.findAll();
    }
}
