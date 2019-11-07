public class Pessoa {

	
	private String Nome;
	private String Senha;
	
	public Pessoa(String nome, String senha) {

		Nome = nome;
		Senha = senha;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	
}
