package Model;

public class Usuario {
	
	private int idade;
	private LoginUser loginUser;
	private String nome; 
	
	public int getIdade() {
		return idade;
	}
	public LoginUser getLoginUser() {
		return loginUser;
	}
	public String getNome() {
		return nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
