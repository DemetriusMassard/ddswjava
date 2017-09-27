import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener; 
import java.sql.*;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;


public class EditaFunc extends JInternalFrame implements ActionListener{
	
	private JButton btnincluir;
	private JButton btnexcluir;
	private JLabel lblnome;
	private JLabel lblcpf;
	private JLabel lblcep;
	private JLabel lblnumero;
	private JLabel lblcomplemento;
	private JLabel lblemail;
	private JLabel lblrg;
	private JTextField txtnome;
	private JTextField txtcpf;
	private JTextField txtcep;
	private JTextField txtnumero;
	private JTextField txtcomplemento;
	private JTextField txtemail;
	private JTextField txtrg;
	
public EditaFunc(){
	super("Editar Funcionario", false,true,false);
	addInternalFrameListener(new InternalFrameAdapter() {
		public void internalFrameClosing(InternalFrameEvent e){

			dispose();
		}
	});
	setBounds(100, 50, 525, 300);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	
	
	btnincluir = new JButton("Incluir");
	btnincluir.setBounds(275, 230, 100, 35);
	btnincluir.addActionListener(this);
	add (btnincluir);

	btnexcluir = new JButton("Excluir");
	btnexcluir.setBounds(400, 230, 100, 35);
	btnexcluir.addActionListener(this);
	add (btnexcluir);
	
	lblnome = new JLabel ("Nome");
	lblnome.setBounds(15, 5, 100, 45);
	add (lblnome);
	
	lblcpf = new JLabel ("Cpf");
	lblcpf.setBounds(350, 5, 100, 45);
	add (lblcpf);
	
	lblcep = new JLabel ("Cep");
	lblcep.setBounds(15, 75, 100, 45);
	add (lblcep);
	
	lblnumero = new JLabel ("Numero");
	lblnumero.setBounds(150, 75, 100, 45);
	add (lblnumero);
		
	lblcomplemento = new JLabel ("Complemento");
	lblcomplemento.setBounds(350, 75, 120, 45);
	add (lblcomplemento);
	
	lblemail = new JLabel ("Email");
	lblemail.setBounds(15, 150, 100, 45);
	add (lblemail);
		
	lblrg = new JLabel ("Rg");
	lblrg.setBounds(350, 150, 100, 45);
	add (lblrg);
	
	txtnome = new JTextField ();
	txtnome.setBounds(15, 45, 300, 30);
	add (txtnome);
	
	txtcpf = new JTextField ();
	txtcpf.setBounds(350, 45, 150, 30);
	add (txtcpf);
	
	txtcep = new JTextField ();
	txtcep.setBounds(15, 115, 120, 30);
	add (txtcep);
	
	txtnumero = new JTextField ();
	txtnumero.setBounds(150, 115, 160, 30);
	add (txtnumero);
	
	txtcomplemento = new JTextField ();
	txtcomplemento.setBounds(350, 115, 150, 30);
	add (txtcomplemento);
	
	txtemail = new JTextField ();
	txtemail.setBounds(15, 190, 300, 30);
	add (txtemail);
	
	txtrg = new JTextField ();
	txtrg.setBounds(350, 190, 150, 30);
	add (txtrg);
	
	setResizable(false);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setVisible(true);
	}

public void actionPerformed(ActionEvent e) {
	String nome = txtnome.getText();
	double cpf = Double.parseDouble(txtcpf.getText());
	String cep = txtcep.getText();
	String num = txtnumero.getText();
	String copm = txtcomplemento.getText();
	String email = txtemail.getText();
	String rg = txtrg.getText();
	
	
	if (e.getSource()== btnincluir ){
		try{
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ddsw","root","");
			String sql = "insert into func (Nome,CPF,CEP,num,comp,Email,RG) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement smt = conn.prepareStatement(sql);
			smt.setString(1,nome );
			smt.setDouble(2,cpf );
			smt.setString(3,cep );
			smt.setString(4,num );
			smt.setString(5,copm );
			smt.setString(6,email );
			smt.setString(7,rg );
			smt.execute();
			smt.close();
			JOptionPane.showMessageDialog(null,"Salvo com sucesso");
		}catch(SQLException e1){
			JOptionPane.showMessageDialog(null,"erro"+ e1.getMessage());
		}
		
	}
	if (e.getSource()== btnexcluir ){
		try{
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ddsw","root","");
			String sql = "DELETE FROM func WHERE cpf=(?)";
			PreparedStatement smt = conn.prepareStatement(sql);
			smt.setDouble(1,cpf );
			smt.execute();
			smt.close();
			JOptionPane.showMessageDialog(null,"Excluido com sucesso");
		}catch(SQLException e1){
			JOptionPane.showMessageDialog(null,"erro"+ e1.getMessage());
		}
		
	}
	
}
}