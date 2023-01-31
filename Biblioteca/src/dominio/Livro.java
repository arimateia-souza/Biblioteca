package dominio;

import java.util.Date;

public class Livro {
	  private int id;
	  private String titulo;
	  private String autor;
	  private Date anoPublicacao;
	  

	  public Livro(int id, String titulo, String autor, Date anoPublicacao) {
	    this.id = id;
	    this.titulo = titulo;
	    this.autor = autor;
	    this.anoPublicacao = anoPublicacao;
	    
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getTitulo() {
	    return titulo;
	  }

	  public void setTitulo(String titulo) {
	    this.titulo = titulo;
	  }

	  public String getAutor() {
	    return autor;
	  }

	  public void setAutor(String autor) {
	    this.autor = autor;
	  }

	  public Date getAnoPublicacao() {
	    return anoPublicacao;
	  }

	  public void setAnoPublicacao(Date anoPublicacao) {
	    this.anoPublicacao = anoPublicacao;
	  }

	 
	}
