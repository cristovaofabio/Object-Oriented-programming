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

public class BuscaDAO {
    private Connection connection;
    
    public BuscaDAO(){
        this.connection = new Conexao().getConnection();
    }
    public static List<Estagio> busca(String cidade, String estado){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con=new Conexao().getConnection();
            List<Estagio> estagios;
            estagios = new ArrayList<>();
            ps=con.prepareStatement("select * from view_estagios where cidadeEmpresa='" + cidade + "' and estadoEmpresa='" + estado + "'");
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()==false) // found
            {
                return null;
                
            }
            
            if (rs.next()) // found
            {
                Estagio estagio = new Estagio();
                estagio.setId(rs.getLong("idEstagio"));
                estagio.setFuncao(rs.getString("funcao"));
                estagio.setDescricao(rs.getString("descricao"));
                estagio.setInioferta(rs.getString("Inioferta"));
                estagio.setFimoferta(rs.getString("Fimoferta"));
                estagio.setQuantidadeVagas(rs.getInt("quantidadeVagas"));
                estagios.add(estagio);
                
            }
            rs.close();
                ps.close();
                return estagios;
        } catch (Exception ex) {
            System.out.println("Error in busca() -->" + ex.getMessage());
            return null;
        }
    }
     public List<Estagio> getlista(String cidade, String estado) throws SQLException{
            List<Estagio> estagios = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement("select * from estagios where cidadeEmpresa like '%"+ cidade +"%' and estadoEmpresa like '%"+estado+"%'");
//            stmt.setString(1, cidade);
//            stmt.setString(2, estado);
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
                System.out.println("12345644 ? " + estagios.size());
                return estagios;
    }
     
    public int getQuantidadesInscritos(int idEstagio) throws SQLException {
        System.out.println("1111" + idEstagio);
        PreparedStatement stmt = connection.prepareStatement("select fn_quantidadeInscritos("+idEstagio+") as    total");
        ResultSet rs = stmt.executeQuery();
        if(rs.first())
            return rs.getInt("total");
        return 0;
    }
}
