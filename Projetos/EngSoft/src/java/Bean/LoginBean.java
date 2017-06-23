/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Outros.Empresa;
import Outros.UserDAO;
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
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String uname;
    private String password;
    private Empresa empresa;
    private boolean logado;

    public Empresa getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        Empresa result = UserDAO.login(uname, password);
        this.empresa=result;
        if (result!=null) {
            logado = true;
            return "HomeEmpresa?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "login";
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
