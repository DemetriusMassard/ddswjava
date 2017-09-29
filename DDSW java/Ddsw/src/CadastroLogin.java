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

	public class CadastroLogin extends JFrame implements ActionListener{

		private JButton btnCadastra;
		private JLabel lblCpf;
		private JLabel lblLogin;
		private JLabel lblSenha;
		private JLabel lblConfSenha;
		private JTextField txtCpf;
		private JTextField txtLogin;
		private JTextField txtSenha;
		private JTextField txtConfSenha;
		
		public CadastroLogin() {
			super("Cadastro Login");
	    	addInternalFrameListener(new InternalFrameAdapter() {
	    		public void internalFrameClosing(InternalFrameEvent e){

	    			dispose();
	    		}
			});
		
			setBounds(100, 50, 300, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(null);
			
			btnCadastra = new JButton("Cadastra");
			btnCadastra.setBounds(150, 300, 100, 35);
			btnCadastra.addActionListener(this);
			add (btnCadastra);
			
			
			lblCpf = new JLabel ("Cpf");
			lblCpf.setBounds(20, 25, 100, 45);
			add (lblCpf);
			
			lblLogin = new JLabel ("Login");
			lblLogin.setBounds(20, 85, 100, 45);
			add (lblLogin);
			
			lblSenha = new JLabel ("Senha");
			lblSenha.setBounds(20, 145, 100, 45);
			add (lblSenha);
			
			lblConfSenha = new JLabel ("Confimar Senha");
			lblConfSenha.setBounds(20, 205, 100, 45);
			add (lblConfSenha);
			
			txtCpf = new JTextField ();
			txtCpf.setBounds(20, 60, 250, 25);
			add (txtCpf);

			txtLogin = new JPasswordField();
			txtLogin.setBounds(20, 120, 250, 25);
			add (txtLogin);
			
			txtSenha = new JPasswordField();
			txtSenha.setBounds(20, 180, 250, 25);
			add (txtSenha);
			
			txtConfSenha = new JPasswordField();
			txtConfSenha.setBounds(20, 240, 250, 25);
			add (txtConfSenha);
			
			
			
			
			setResizable(false);
			getContentPane().setBackground(Color.LIGHT_GRAY);
			setVisible(true);
		}
		private void addInternalFrameListener(
				InternalFrameAdapter internalFrameAdapter) {
		
			
		}
		public void actionPerformed(ActionEvent AE) {
			
			String Cpf = txtCpf.getText();
			String Login = txtLogin.getText();
			String Senha = txtSenha.getText();
			String ConfSenha = txtConfSenha.getText();
			
			if (AE.getSource()== btnCadastra ){
				try{
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ddsw","root","");
					String sql = "insert into contato (user,senha) VALUES (?,?)";
					PreparedStatement smt = conn.prepareStatement(sql);
					smt.setString(1,Login );
					smt.setString(2,Senha );
					
					smt.execute();
					smt.close();
					JOptionPane.showMessageDialog(null,"Salvo com sucesso");
				}catch(SQLException e1){
					JOptionPane.showMessageDialog(null,"erro"+ e1.getMessage());
				}
				
			}
			
		}
		}
