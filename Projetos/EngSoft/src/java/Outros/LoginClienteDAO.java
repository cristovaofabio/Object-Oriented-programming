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
public class LoginClienteDAO {
    public static Cliente loginc(String email, String senha){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con=new Conexao().getConnection();
            ps=con.prepareStatement("select * from clientes where email='" + email + "' and senha='" + senha + "'");
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) // found
            {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                return cliente;
                
            }
            else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Error in loginc() -->" + ex.getMessage());
            return null;
        }
    }
}
