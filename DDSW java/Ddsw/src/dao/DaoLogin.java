package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javaBeans.BeansLogin;
import dao.Conexao;

public class DaoLogin {

	public boolean login(BeansLogin login){
		boolean result = false;
		ArrayList<BeansLogin> lista = new ArrayList<BeansLogin>();
        try {
            Conexao con = new Conexao();
            con.getConexao();

            String sql = "select * from  users where user = ? and pass = ?;";

            PreparedStatement comando = con.getConexao().prepareStatement(sql);
            comando.setString(1, login.getLogin());
            comando.setString(2, login.getSenha());
            ResultSet resultado = comando.executeQuery();
 
            ArrayList<BeansLogin> listaDeFuncionarios = new ArrayList<BeansLogin>();

            while (resultado.next()) {
            	BeansLogin newLogin = new BeansLogin();
            	newLogin.setLogin(resultado.getString("user"));
            	newLogin.setSenha(resultado.getString("pass"));
            	lista.add(newLogin);
            }
            if(lista.size()==1){
            	result = true;
            }
            
            resultado.close();
            comando.close();
            con.getConexao().close();
 

    		return result;
        } catch (Exception e) { //Se der algum exceção...
            System.out.println(e.getMessage());
            return result;
        }
		
	}
}
