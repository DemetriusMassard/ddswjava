import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javaBeans.BeansProjeto;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import sun.applet.Main;
import dao.DaoContatos;
import dao.Daoprojeto;

public class EditaContato extends JInternalFrame implements ActionListener{
	
	private JButton btnexcluir;
	private JButton btnincluir;
	private JButton btnalterar;
	private JLabel lblnome;
	private JLabel lblempresa;
	private JLabel lblcargo;
	private JLabel lblemail;
	private JLabel lblobsadc;
	private JLabel lbldata;
	private JTextField txtnome;
	private JTextField txtempresa;
	private JTextField txtemail;
	private JTextField txtnomedoproj;
	private JTextField txtobsadc;
	private JTextField txtcargo;
	private JTextField txtdata;
	
	public EditaContato() {
		super("Editar Contato", false,true,false);
    	addInternalFrameListener(new InternalFrameAdapter() {
    		public void internalFrameClosing(InternalFrameEvent e){

    			dispose();
    		}
		});
	
		setBounds(100, 50, 600, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
			
		btnexcluir = new JButton("Excluir");
		btnexcluir.setBounds(340, 470, 100, 35);
		btnexcluir.addActionListener(this);
		add (btnexcluir);
		
		btnincluir = new JButton("Incluir");
		btnincluir.setBounds(460, 470, 100, 35);
		btnincluir.addActionListener(this);
		add (btnincluir);
		
		btnalterar = new JButton("Alterar");
		btnalterar.setBounds(220, 470, 100, 35);
		btnalterar.addActionListener(this);
		add (btnalterar);
		
		
		lblnome = new JLabel ("Nome");
		lblnome.setBounds(15, 5, 100, 45);
		add (lblnome);
		
		lblempresa = new JLabel ("Empresa");
		lblempresa.setBounds(15, 75, 100, 45);
		add (lblempresa);
		
		lblemail = new JLabel ("Email");
		lblemail.setBounds(15, 145, 100, 45);
		add (lblemail);
		
		lblcargo = new JLabel ("Nome do Projeto");
		lblcargo.setBounds(15, 220, 100, 45);
		add (lblcargo);
			
		lblobsadc = new JLabel ("Obs. adicionanais");
		lblobsadc.setBounds(10, 295, 120, 45);
		add (lblobsadc);
		
		txtnome = new JTextField ();
		txtnome.setBounds(15, 45, 350, 30);
		add (txtnome);
		
		txtempresa = new JTextField ();
		txtempresa.setBounds(15, 115, 350, 30);
		add (txtempresa);
		
		txtemail = new JTextField ();
		txtemail.setBounds(15, 185, 350, 30);
		add (txtemail);
		
		txtnomedoproj = new JTextField ();
		txtnomedoproj.setBounds(15, 255, 350, 30);
		add (txtnomedoproj);
		
		txtobsadc = new JTextField ();
		txtobsadc.setBounds(10, 350, 550, 100);
		add (txtobsadc);
	
		txtcargo = new JTextField ();
		txtcargo.setBounds(10, 350, 550, 100);
		add (txtcargo);

		
		
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setVisible(true);
	}
		
	public void actionPerformed(ActionEvent AE) {
		
	String nome = txtnome.getText();
	String empresa = txtempresa.getText();
	String email = txtemail.getText();
	String cargo = txtcargo.getText();
	String obs = txtobsadc.getText();

	
	//double cpf = Double.parseDouble(txtcpf.getText());
		
		
		
		if (AE.getSource()== btnincluir ){
			try{
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ddsw","root","");
				String sql = "insert into contato (Nome,empresa,cargo,Email,Obs) VALUES (?,?,?,?,?)";
				PreparedStatement smt = conn.prepareStatement(sql);
				smt.setString(1,nome );
				smt.setString(2,empresa );
				smt.setString(3,email );
				smt.setString(4,obs );
				smt.setString(5,cargo );
				smt.execute();
				smt.close();
				JOptionPane.showMessageDialog(null,"Salvo com sucesso");
			}catch(SQLException e1){
				JOptionPane.showMessageDialog(null,"erro"+ e1.getMessage());
			}
			
		}
		if (AE.getSource()== btnexcluir ){
			try{
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ddsw","root","");
				String sql = "DELETE FROM contato WHERE empresa=(?) ";
				PreparedStatement smt = conn.prepareStatement(sql);
				smt.setString(1,empresa);	
				smt.execute();
				smt.close();
				JOptionPane.showMessageDialog(null,"Excluido com sucesso");
			}catch(SQLException e1){
				JOptionPane.showMessageDialog(null,"erro"+ e1.getMessage());
			}
			
		}
	}
	}
