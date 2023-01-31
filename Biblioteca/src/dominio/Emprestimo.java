package dominio;

import java.util.Date;

public class Emprestimo {
  private int id;
  private Leitor leitor;
  private Livro livro;
  private Funcionario funcionario;
  private Date dataEmprestimo;
  private Date dataDevolucao;

  public Emprestimo(int id, Leitor leitor, Livro livro, Funcionario funcionario, Date dataEmprestimo, Date dataDevolucao) {
    this.id = id;
    this.leitor = leitor;
    this.livro = livro;
    this.funcionario = funcionario;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Leitor getLeitor() {
    return leitor;
  }

  public void setLeitor(Leitor leitor) {
    this.leitor = leitor;
  }

  public Livro getLivro() {
    return livro;
  }

  public void setLivro(Livro livro) {
    this.livro = livro;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public Date getDataEmprestimo() {
    return dataEmprestimo;
  }

  public void setDataEmprestimo(Date dataEmprestimo) {
    this.dataEmprestimo = dataEmprestimo;
  }

  public Date getDataDevolucao() {
    return dataDevolucao;
  }

  public void setDataDevolucao(Date dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }
}
