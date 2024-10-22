package ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.Repositories;

import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;

import java.util.List;

public interface ClienteRepository {
    Cliente findById(long codigo);

    List<Cliente> findAll();

    void save(Cliente cliente);
    void update(Cliente cliente);
    void deleteById(long codigo);
}
