package Outros;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author aluno_imd
 */
@ManagedBean
public class Estagio {
    private Long id;
    private int cnpjEmpresa;
    private String funcao,descricao,Inioferta,Fimoferta,cidadeEmpresa,estadoEmpresa;
    private int quantidadeVagas;
    
    EstagioDAO DAO = new EstagioDAO();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(int cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInioferta() {
        return Inioferta;
    }

    public void setInioferta(String Inioferta) {
        this.Inioferta = Inioferta;
    }

    public String getFimoferta() {
        return Fimoferta;
    }

    public void setFimoferta(String Fimoferta) {
        this.Fimoferta = Fimoferta;
    }

    public String getCidadeEmpresa() {
        return cidadeEmpresa;
    }

    public void setCidadeEmpresa(String cidadeEmpresa) {
        this.cidadeEmpresa = cidadeEmpresa.toUpperCase();
    }

    public String getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(String estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa.toUpperCase();
    }

    public int getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(int quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }
    
    public void excluir(Estagio umEstagio){
        this.DAO.remove(umEstagio);
    }
}
