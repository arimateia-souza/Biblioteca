package dominio;

public class Login {
	private String usuario;
    private String senha;
    private int id_funcionario;
    private boolean ativo;
    
    public Login(String usuario, String senha) {
	    this.usuario = usuario;
	    this.senha = senha; 
	}

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public String getUsuario() {
	   return usuario;
	}

	public String setUsuario(String usuario) {
	  return this.usuario = usuario;
	}
	
	
	public String getSenha() {
	   return senha;
	}

	public void setSenha(String senha) {
	   this.senha = senha;		
	}
	
	
	public int getIdFuncionario() {
	   return id_funcionario;
	}

	public void setIdFuncionario(int id_funcionario) {
	   this.id_funcionario = id_funcionario;				
	}
	
	  
	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;				
	}
		
}
