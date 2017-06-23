/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Outros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author aluno_imd
 */
@ManagedBean
public class EmpresaDAO {
    private Connection connection;
    public EmpresaDAO(){
        this.connection = new Conexao().getConnection();
    }
    public void adiciona(Empresa empresa){
        String sql = "insert into empresas"+"(cnpj,nome,email,senha,estado,cidade,endereco)"+"values(?,?,?,?,?,?,?)";
        try{
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, empresa.getCnpj());
                stmt.setString(2, empresa.getNome());
                stmt.setString(3, empresa.getEmail());
                stmt.setString(4, empresa.getSenha());
                stmt.setString(5, empresa.getEstado());
                stmt.setString(6, empresa.getCidade());
                stmt.setString(7, empresa.getEndereco());
                
                stmt.execute();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
        public void remove(Empresa umaEmpresa){
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from empresas where cnpj=?");
            stmt.setInt(1, umaEmpresa.getCnpj());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void altera(Empresa empresa,int cnpj){
        String sql = "update empresas set nome=?, email=?,"+
                "estado=?, cidade=?, endereco=? where cnpj=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, empresa.getNome());
            stmt.setString(2, empresa.getEmail());
            stmt.setString(3, empresa.getEstado());
            stmt.setString(4, empresa.getCidade());
            stmt.setString(5, empresa.getEndereco());
            stmt.setInt(6,cnpj);
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        
    }
}
