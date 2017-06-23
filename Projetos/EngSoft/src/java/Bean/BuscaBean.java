/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Outros.BuscaDAO;
import Outros.ClienteestagioDAO;
import Outros.Empresa;
import Outros.Estagio;
import Outros.EstagioDAO;
import Outros.UserDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cristovao
 */
@ManagedBean(name = "buscaBean")
@SessionScoped
public class BuscaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private String cidade;
    private String estado;
    private Estagio estagio;
    private List<Estagio> estagios;
    private List<Integer> IDestagios;
    private List<Estagio> estagiosCliente;
    BuscaDAO DAO;
    ClienteestagioDAO DAOestagioCliente;
    
    public BuscaBean(){
        this.DAO = new BuscaDAO();
        this.DAOestagioCliente = new ClienteestagioDAO();
        this.estagio=new Estagio();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado.toUpperCase();
    }

    public Estagio getEstagio() {
        return estagio;
    }

    public void setEstagio(Estagio estagio) {
        this.estagio = estagio;
    }
 
    public String buscaProject() {
        this.estagios = BuscaDAO.busca(cidade, estado);
       
        if (estagios!=null) {
            
            return "BuscarEstagio";
        } else {
           
            return "BuscarEstagio";
        }
    }
    
    public int getCandidatosInscritos(int idEstagio) throws SQLException {
        return DAO.getQuantidadesInscritos(idEstagio);
    }
    
    public List<Estagio> getEstagios(String cidade,String estado) throws SQLException{
        this.estagios=DAO.getlista(cidade,estado);
        return estagios;
    }
    
    public List<Estagio> getEstagiCliente(int id) throws SQLException{
        this.IDestagios=DAOestagioCliente.getIDsEstagio(id);
        this.estagiosCliente=DAOestagioCliente.getEstagio(IDestagios);

        return estagiosCliente;
    }
}