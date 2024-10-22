package ProjArq.ControlSubApp.aplicacao.casosDeUso;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories.ClienteRepository;
import ProjArq.ControlSubApp.domain.entidades.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TodosClientesUC{

    private ClienteRepository clienteRepository;
    public TodosClientesUC(ClienteRepository cl) {
        this.clienteRepository = cl;
    }


    public List<Cliente> listaClientes(){
        return clienteRepository.findAll();
    }
}