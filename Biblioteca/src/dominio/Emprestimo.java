package dominio;

public class Emprestimo {
	  private int id;
	  private int leitor;
	  private int livro;
	  private int funcionario;
	  private String dataEmprestimo;
	  private String dataDevolucao;

	  public Emprestimo(int id, int leitor, int livro, int funcionario, String dataEmprestimo, String dataDevolucao) {
	    this.id = id;
	    this.leitor = leitor;
	    this.livro = livro;
	    this.funcionario = funcionario;
	    this.dataEmprestimo = dataEmprestimo;
	    this.dataDevolucao = dataDevolucao;
	  }

	  public Emprestimo() {
		// TODO Auto-generated constructor stub
	  }
	
	  public int getId() {
	    return id;
	  }
	
	  public void setId(int id) {
	    this.id = id;
	  }
	
	  public int getLeitor() {
	    return leitor;
	  }
	
	  public void setLeitor(int leitor) {
	    this.leitor = leitor;
	  }
	
	  public int getLivro() {
	    return livro;
	  }
	
	  public void setLivro(int livro) {
	    this.livro = livro;
	  }
	
	  public int getFuncionario() {
	    return funcionario;
	  }
	
	  public void setFuncionario(int funcionario) {
	    this.funcionario = funcionario;
	  }
	
	  public String getDataEmprestimo() {
	    return dataEmprestimo;
	  }
	
	  public void setDataEmprestimo(String dataEmprestimo) {
	    this.dataEmprestimo = dataEmprestimo;
	  }
	
	  public String getDataDevolucao() {
	    return dataDevolucao;
	  }
	
	  public void setDataDevolucao(String dataDevolucao) {
	    this.dataDevolucao = dataDevolucao;
	  }
}
