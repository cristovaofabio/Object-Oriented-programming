package Bean;

import Outros.Cliente;
import Outros.LoginClienteDAO;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cristovao
 */
@ManagedBean(name = "loginclienteBean")
@SessionScoped
public class LoginclienteBean implements Serializable{
    private String uname;
    private String password;
    private Cliente cliente;
    private boolean logado;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
     
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String loginProject() {
        Cliente result = LoginClienteDAO.loginc(uname, password);
        this.cliente=result;
        if (result!=null) {
            logado = true;
            return "HomeCliente?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Login inválido!",
                    "Por favor, tente novamente!"));
            return "loginCliente";
        }
    }
    
    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/EngSoft");
    }

    
    public boolean estaLogado() {
        return logado;
    }
    
    public void permissao() throws IOException {
        if (!estaLogado()) {
            FacesContext.getCurrentInstance().addMessage("error", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Não está autorizado a acessar a página",
                            "ERROR"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("/EngSoft");
        }
    }
}
