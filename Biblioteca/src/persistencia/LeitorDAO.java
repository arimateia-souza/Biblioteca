package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.Leitor;

public class LeitorDAO {

    private final String LISTAR = "select * from leitor";
    private final String BUSCAR = "select * from leitor where id=?";
    private final String INCLUIR = "insert into leitor (nome, endereco, telefone) values (?, ?, ?)";
    private final String EXCLUIR = "delete from leitor where id=?";
    private final String ALTERAR = "update leitor set nome=?, endereco=?, "
            + "telefone=? where id=?";
  
    public LeitorDao() {
        conexao = new Conexao();
    }
  
    public List<Leitor> listar(){
        List<Leitor> lista = new ArrayList<>();
        try{
            conexao.conectar();
            java.sql.Statement instrucao = (Statement) conexao.getConexao().createStatement();
            ResultSet rs =((java.sql.Statement) instrucao).executeQuery(LISTAR);
            while(rs.next()){
                Leitor leitor = new Leitor (rs.getInt("id"), rs.getString("nome"), rs.getString("enederco"),
                        rs.getString("telefone"));
                lista.add(leitor);
            }
            conexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro no relatorio: "+e.getMessage());
        }
        return lista;
     }
  
    public void insert(Leitor leitor){
        try{
            conexao.conectar();
            PreparedStatement instrucao =
                    conexao.getConexao().prepareStatement(INCLUIR);
            instrucao.setString(1, leitor.getNome());
            instrucao.setString(2, leitor.getEndereco());
            instrucao.setString(3, leitor.getTelefone());
            instrucao.execute();
            conexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na inclusão: "+e.getMessage());
        }
    }
  
   public void alteracao(Leitor l, int id){
        try{
            conexao.conectar();
            PreparedStatement instrucao =
                    conexao.getConexao().prepareStatement(ALTERAR);
            instrucao.setString(1, l.getNome());
            instrucao.setString(2, l.getEndereco());
            instrucao.setString(3, l.getTelefone());
            instrucao.setInt(4, id);
            instrucao.execute();
            conexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na alteração: "+e.getMessage());
        }
    }

    public void exclusao(int id){
        try{
            conexao.conectar();
            PreparedStatement instrucao =
                    conexao.getConexao().prepareStatement(EXCLUIR);
            instrucao.setInt(1, id);
            instrucao.execute();
            conexao.desconectar();
        }catch(Exception e){
            System.out.println("Erro na exclusão: "+e.getMessage());
        }
    }

    public Leitor buscar(int id){
        Leitor leitor = null;
        try{
            conexao.conectar();
            PreparedStatement instrucao =
                    conexao.getConexao().prepareStatement(BUSCAR);
            instrucao.setInt(1, id);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                leitor = new Leitor (rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"),
                        rs.getString("telefone"));
            }
            conexao.desconectar();
        }catch(SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }
        return leitor;
    }
}
