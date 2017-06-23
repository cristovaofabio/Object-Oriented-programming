/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Outros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author aluno_imd
 */
public class EstagioDAO {
    private Connection connection;
    
    public EstagioDAO(){
        this.connection = new Conexao().getConnection();
    }
    public void adiciona(Estagio estagio){
        String sql = "insert into estagios"+"(cnpjEmpresa,funcao,descricao,Inioferta,"
                + "Fimoferta,cidadeEmpresa,estadoEmpresa,quantidadeVagas)"+"values(?,?,?,?,?,?,?,?)";
        try{
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, estagio.getCnpjEmpresa());
                stmt.setString(2, estagio.getFuncao());
                stmt.setString(3, estagio.getDescricao());
                stmt.setString(4, estagio.getInioferta());
                stmt.setString(5, estagio.getFimoferta());
                stmt.setString(6, estagio.getCidadeEmpresa());
                stmt.setString(7, estagio.getEstadoEmpresa());
                stmt.setInt(8, estagio.getQuantidadeVagas());
                
                stmt.execute();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Estagio> getlista(String email) throws SQLException{
            List<Estagio> estagios = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement("select * from estagios where cnpjEmpresa in (select cnpj from empresas where email=?)");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Estagio estagio = new Estagio();
                estagio.setId(rs.getLong("id"));
                estagio.setFuncao(rs.getString("funcao"));
                estagio.setDescricao(rs.getString("descricao"));
                estagio.setInioferta(rs.getString("Inioferta"));
                estagio.setFimoferta(rs.getString("Fimoferta"));
                estagio.setCidadeEmpresa(rs.getString("cidadeEmpresa"));
                estagio.setEstadoEmpresa(rs.getString("estadoEmpresa"));
                estagio.setQuantidadeVagas(rs.getInt("quantidadeVagas"));
                estagios.add(estagio);
            }
          rs.close();
                stmt.close();
                return estagios;
    }
    
    public void remove(Estagio estagio){
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from estagios where id=?");
            stmt.setLong(1, estagio.getId());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public String listaEmail(int id) throws SQLException{
            String email="";
            int i=0;
            PreparedStatement stmt = connection.prepareStatement("select * from clienteEstagio where idEstagio=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                if(i==0)
                    email=rs.getString("emailCliente");
                else
                    email=email+","+rs.getString("emailCliente");
               i=i+1;
            }
          rs.close();
                stmt.close();
                return email;
    }
}
