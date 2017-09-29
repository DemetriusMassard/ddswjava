import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import dao.DaoContatos;
import java.util.*;
import javaBeans.BeansContato;

public class Contatos extends JInternalFrame implements ActionListener {
	JTable tabela;
    DefaultTableModel model;
    JScrollPane scroll;
	
    public Contatos(){
    	super("Contatos", false,true,false);
    	addInternalFrameListener(new InternalFrameAdapter() {
    		public void internalFrameClosing(InternalFrameEvent e){

    			dispose();
    		}
		});
		tabela = new JTable();
		tabela.setBounds(10,10, 500,190);
        scroll = new JScrollPane();
        scroll.setViewportView(tabela);
        scroll.setBounds(10,10, 500, 190);
        add(montatabela());
        setBounds(100,100,520,300);
		setLayout(null);
		
	}
    
    
    public JScrollPane montatabela(){
        String[] colunas = new String[]{"empresa","nome", "email"};
        String[][] dados = new String[][]{};
        DaoContatos dao = new DaoContatos();
        ArrayList<BeansContato> Lista = dao.listacont();
        int i = 0;
        dados = new String[Lista.size()][4];
        for(BeansContato cont : Lista){
        	dados[i][0] = String.valueOf(cont.getCod());
        	dados[i][1] = String.valueOf(cont.getEmpresa());
        	dados[i][2] = String.valueOf(cont.getNome());
        	dados[i][3] = String.valueOf(cont.getEmail());
        	i++;
        }

        model = new DefaultTableModel(dados , colunas);
        tabela.setModel(model);
        return scroll;
    }
	
	public void actionPerformed(ActionEvent AE) {
	
	}

}
