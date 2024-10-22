package ProjArq.ControlSubApp.aplicacao.dtos;

<<<<<<< HEAD
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Aplicativo;
import ProjArq.ControlSubApp.interfaceAdaptadora.repositorios.entidades.Cliente;

=======
import org.springframework.stereotype.Repository;

@Repository
>>>>>>> bcda5a099dd584dbf032930657519c5ac1e94c1c
public class ClienteDTO {
    private long codigo;
    private String nome;
    private String email;


    public ClienteDTO(long codigo, String nome, String email) {
    this.codigo = codigo;
    this.nome = nome;
    this.email = email;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static ClienteDTO fromModel(Cliente cliente) {
        return new ClienteDTO(cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
    }
}
