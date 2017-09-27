package javaBeans;


public class BeansProjeto implements java.io.Serializable{
	
	public int getCod() {
		return Cod;
	}
	public void setCod(int cod) {
		Cod = cod;
	}
	public int getCodcontato() {
		return codcontato;
	}
	public void setCodcontato(int codcontato) {
		this.codcontato = codcontato;
	}
	public String getNomeProj() {
		return NomeProj;
	}
	public void setNomeProj(String nomeProj) {
		NomeProj = nomeProj;
	}
	public String getObs() {
		return Obs;
	}
	public void setObs(String obs) {
		Obs = obs;
	}
	private int Cod;
	private int codcontato;
	private String NomeProj;
	private String Obs;
	
}