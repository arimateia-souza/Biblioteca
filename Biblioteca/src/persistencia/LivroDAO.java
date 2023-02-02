package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dominio.Livro;

public class LivroDAO {
	    private Conexao conexao;
	    private final String LISTAR = "select * from livro";
	    private final String BUSCAR = "select * from livro where id=?";
	    private final String INCLUIR = "insert into livro (titulo, autor, ano_publicacao) values ( ?, ?, ?)";
	    private final String EXCLUIR = "delete from livro where id=?";
	    private final String ALTERAR = "update livro set titulo=?,"
	    		+ " autor=?, ano_publicacao=? where id=?";

	    public LivroDAO() {
	        conexao = new Conexao();
	    }
	    
	    
	    public List<Livro> listar() {
	        List<Livro> livros = new ArrayList<>();

	        try {
	            conexao.conectar();
	            Statement instrucao = (Statement) conexao.getConexao().createStatement();
	            ResultSet resultSet =((java.sql.Statement) instrucao).executeQuery(LISTAR);
	            while (resultSet.next()) {
	            	Livro liv = new Livro(resultSet.getInt("id"), resultSet.getString("titulo"), resultSet.getString("autor"), resultSet.getString("ano_publicacao"));
	                livros.add(liv);
	            }

	        } catch (SQLException e) {
	            System.out.println("Erro na lista: "+e.getMessage());
	        }

	        return livros;

	    }
	    
	    
	    public void insert(Livro livro){
	        try{
	            conexao.conectar();
	            PreparedStatement instrucao =
	                    conexao.getConexao().prepareStatement(INCLUIR);
	            instrucao.setString(1, livro.getTitulo());
	            instrucao.setString(2, livro.getAutor());
	            instrucao.setString(3, livro.getAnoPublicacao());
	            instrucao.execute();
	            conexao.desconectar();

	        }catch(Exception e){
	            System.out.println("Erro no cadastro: "+e.getMessage());
	        }
	    }

	   public void alteracao(Livro l, int id){
		   try{
			    conexao.conectar();
			    PreparedStatement instrucao =
				    conexao.getConexao().prepareStatement(ALTERAR);
			    instrucao.setString(1, l.getTitulo());
			    instrucao.setString(2, l.getAutor());
			    instrucao.setString(3, l.getAnoPublicacao());
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
				System.out.println("|--------------------------------------------------------|");
	            System.out.println("|   NÃO FOI POSSÍVEL EXCLUIR, O LIVRO ESTÁ EMPRESTADO    |");
	            System.out.println("|--------------------------------------------------------|");
			    //System.out.println("Erro na exclusão: "+e.getMessage());
			}
	    }

	    public Livro buscar(int id){
			Livro livro = null;
			try{
			    conexao.conectar();
			    PreparedStatement instrucao =
				    conexao.getConexao().prepareStatement(BUSCAR);
			    instrucao.setInt(1, id);
			    ResultSet rs = instrucao.executeQuery();
			    if(rs.next()){
			    	livro = new Livro (rs.getInt("id"), rs.getString("titulo"), rs.getString("autor"),
			    			rs.getString("ano_publicacao"));
			    }
	
			    conexao.desconectar();
			}catch(SQLException e){
			    System.out.println("Erro na busca: "+e.getMessage());
			}
			return livro;
	    }
}
