package persistencia;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Emprestimo;
import dominio.Livro;

public class LivroDAO {
	    private Conexao conexao;
	    private final String LISTAR = "select * from livro";
	    private final String BUSCAR = "select * from livro where id=?";
	    private final String INCLUIR = "insert into livro (id, titulo, autor, ano_publicacao) values (?, ?, ?, ?)";
	    private final String EXCLUIR = "delete from livro where id=?";
	    private final String ALTERAR = "update livro set id=?, titulo=,"
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
	            	Livro liv = new Livro(resultSet.getInt("id"), resultSet.getString("titulo"), resultSet.getString("autor"), resultSet.getString("anoPublicacao"));
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


}
