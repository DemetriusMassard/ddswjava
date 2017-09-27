package dao;
import dao.Conexao;

public class DaoContatos {
	public String[][] listacont(){
		String[][] List = new String[][]{};
		Conexao conn = new Conexao();
		conn.getConexao();
		
		return List;
	}
}
