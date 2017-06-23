package Outros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author cristovao
 */
@ManagedBean
public class ClienteDAO {
    private Connection connection;
    public ClienteDAO(){
        this.connection = new Conexao().getConnection();
    }
    public void adiciona(Cliente cliente){
        String sql = "insert into clientes"+"(cpf,nome,email,dataNascimento,endereco,"
                + "estado,cidade,senha)"+"values(?,?,?,?,?,?,?,?)";
        try{
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, cliente.getCpf());
                stmt.setString(2, cliente.getNome());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getDataNascimento());
                stmt.setString(5, cliente.getEndereco());
                stmt.setString(6, cliente.getEstado());
                stmt.setString(7, cliente.getCidade());
                stmt.setString(8, cliente.getSenha());
                
                stmt.execute();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void remove(Cliente cliente){
        try{
            PreparedStatement stmt = connection.prepareStatement("delete from clientes where cpf=?");
            stmt.setInt(1, cliente.getCpf());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void altera(Cliente cliente,int cpf){
        String sql = "update clientes set email=?,"+
                "estado=?, cidade=?, endereco=? where cpf=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getEmail());
            stmt.setString(2, cliente.getEstado());
            stmt.setString(3, cliente.getCidade());
            stmt.setString(4, cliente.getEndereco());
            stmt.setInt(5,cpf);
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        
    }
}
