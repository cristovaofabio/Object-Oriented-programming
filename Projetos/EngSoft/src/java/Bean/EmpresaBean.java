/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import Outros.Empresa;
import Outros.EmpresaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author aluno_imd
 */
@ManagedBean
public class EmpresaBean {
    private Empresa empresa;
    private List<Empresa> empresas;
    EmpresaDAO DAO;
      public EmpresaBean(){
        this.DAO = new EmpresaDAO();
        this.empresa=new Empresa();
    }
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public void adicionar(){
        this.DAO.adiciona(this.empresa);
        this.empresa=new Empresa();
    }
    public void excluir(Empresa umEmpresa){
        this.empresas.remove(umEmpresa);
        this.DAO.remove(umEmpresa);
    }
    public String chamarPagina(){
       return "AdicionarEmpresa?faces-redirect=true";
    }
    public String ChamarPaginaAlterar(){
        return "AdicionarEmpresa?faces-redirect=true";
    }
    public void Alterar(int cnpj){
        this.DAO.altera(this.empresa,cnpj);
    }
    
}
