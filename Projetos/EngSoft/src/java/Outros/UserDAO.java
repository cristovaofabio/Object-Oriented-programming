/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author cristovao
 */
public class UserDAO {
    public static Empresa login(String email, String senha){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con=new Conexao().getConnection();
            ps=con.prepareStatement("select * from empresas where email='" + email + "' and senha='" + senha + "'");
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) // found
            {
                Empresa empresa = new Empresa();
                empresa.setNome(rs.getString("nome"));
                empresa.setCnpj(rs.getInt("cnpj"));
                empresa.setEmail(rs.getString("email"));
                empresa.setEndereco(rs.getString("endereco"));
                empresa.setCidade(rs.getString("cidade"));
                empresa.setEstado(rs.getString("estado"));
                return empresa;
                
            }
            else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return null;
        }
    }
}
