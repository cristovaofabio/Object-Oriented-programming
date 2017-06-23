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
 * @author cristovao
 */
@ManagedBean
public class ClienteestagioDAO {
    private Connection connection;
    public ClienteestagioDAO(){
        this.connection = new Conexao().getConnection();
    }
    public void adiciona(int cpf, int idEstagio, String emailCliente){
        String sql = "insert into clienteEstagio"+"(idEstagio,idCliente,emailCliente)"+"values(?,?,?)";
        try{
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, idEstagio);
                stmt.setInt(2, cpf);
                stmt.setString(3, emailCliente);
                stmt.execute();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Estagio> getEstagio(List<Integer> lista) throws SQLException{
            List<Estagio> estagios = new ArrayList<>();
            for(int i=0;i<lista.size();i++){
            ResultSet rs;
            PreparedStatement stmt = connection.prepareStatement("select * from estagios where id=?");
            stmt.setLong(1, lista.get(i));
            rs = stmt.executeQuery();
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
            }
                return estagios;
    }
    public List<Integer> getIDsEstagio(int id) throws SQLException{
            List<Integer> estagios = new ArrayList<>();
            PreparedStatement stmt = connection.prepareStatement("select * from clienteEstagio where idCliente=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int numero;
                numero=rs.getInt("idEstagio");
                estagios.add(numero);
            }
          rs.close();
                stmt.close();
                return estagios;
    }
}
