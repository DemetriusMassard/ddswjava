package javaBeans;

public class BeansFuncionario {

	private String Nome;
	private String Email;
	private String Complemento;
	private String Rg;
	private  int Cep;
	private int numero;
	private double Cpf;
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getComplemento() {
		return Complemento;
	}
	public void setComplemento(String complemento) {
		Complemento = complemento;
	}
	public String getRg() {
		return Rg;
	}
	public void setRg(String rg) {
		Rg = rg;
	}
	public int getCep() {
		return Cep;
	}
	public void setCep(int cep) {
		Cep = cep;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getCpf() {
		return Cpf;
	}
	public void setCpf(double cpf) {
		Cpf = cpf;
	}
}
