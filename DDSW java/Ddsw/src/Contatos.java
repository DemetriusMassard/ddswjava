import java.awt.Component;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;



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
        scroll.setBounds(10,100, 500, 210);
        add(tabela);
		
        setBounds(100,100,520,300);
		setLayout(null);
		
	}
    
    
    public void montatabela(){
        String[] colunas = new String[]{"empresa","nome", "email"};
        String[][] dados = new String[][]{};
        
        
    }
	
	public void actionPerformed(ActionEvent AE) {
	
	}

}
