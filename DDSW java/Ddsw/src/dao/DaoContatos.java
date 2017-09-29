package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javaBeans.BeansContato;

import javax.swing.JOptionPane;


import dao.Conexao;

public class DaoContatos {
	public ArrayList<BeansContato> listacont(){
		Conexao conn = new Conexao();
		conn.getConexao();
		ArrayList<BeansContato> Lista = new ArrayList<BeansContato>();
		
		String sql = "select * from contato";
		try{
			PreparedStatement comando = conn.getConexao().prepareStatement(sql);
	        ResultSet resultado = comando.executeQuery();
	        while(resultado.next()){
	        	BeansContato newCont = new BeansContato();
	        	newCont.setCod(resultado.getInt("cod"));
	        	newCont.setNome(resultado.getString("nome"));
	        	newCont.setEmpresa(resultado.getString("empresa"));
	        	newCont.setCargo(resultado.getString("cargo"));
	        	newCont.setEmail(resultado.getString("email"));
	        	newCont.setObs(resultado.getString("obs"));
	        	Lista.add(newCont);
	        }
		}catch(Exception e){

			JOptionPane.showMessageDialog(null, "Erro ao conectar-se com banco de dados");
		}
		return Lista;
	}
}
