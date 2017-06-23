package Bean;

import Outros.Cliente;
import Outros.ClienteDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cristovao
 */
@ManagedBean
@SessionScoped
public class ClienteBean {
    
    private Cliente cliente;
    private List<Cliente> clientes;
    ClienteDAO DAO;
    
    public ClienteBean(){
        this.DAO = new ClienteDAO();
        this.cliente=new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String adicionar(){
        this.DAO.adiciona(this.cliente);
        this.cliente=new Cliente();
        return "loginCliente?faces-redirect=true";
    }
    public void excluir(Cliente umCliente){
        this.clientes.remove(umCliente);
        this.DAO.remove(umCliente);
    }
    
}
