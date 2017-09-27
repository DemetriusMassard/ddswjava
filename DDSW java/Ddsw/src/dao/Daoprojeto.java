package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javaBeans.BeansProjeto;

public class Daoprojeto {
    
    public boolean inserirProjeto(BeansProjeto proj) {
        try {
            Conexao conexao = new Conexao();
            conexao.getConexao();
 
            String sql = "";
            sql += "insert into proj (cod, Codcontato, NomeProj, Obs)";
            sql += " VALUES (?, ?, ?, ?)";
            sql += " (" + proj.getCod() +", '" + proj.getCodcontato() + " ,'" + proj.getNomeProj() + ",'" + proj.getObs() + ")";
            PreparedStatement comando = conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso !!!");
            return true;
		}
		catch(Exception E){
			JOptionPane.showMessageDialog(null, "Erro ao conectar-se com banco de dados");
		}
		return false;
    }
    public boolean excluirProjeto(BeansProjeto proj) {
        try {
            Conexao conexao = new Conexao();
            conexao.getConexao();
 
            String sql = "";
            sql += "delete from proj";
            sql += " where cod = " + proj.getCod();
 
            PreparedStatement comando = conexao.getConexao().prepareStatement(sql);
            comando.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
            return true;
		}
		catch(Exception E){
			JOptionPane.showMessageDialog(null, "Erro ao conectar-se com banco de dados");
		}
		return false;
    }
}