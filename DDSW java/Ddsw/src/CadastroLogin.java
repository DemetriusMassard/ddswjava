import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class CadastroLogin extends JInternalFrame implements ActionListener{

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
			super("Cadastro Login", false,true,false);
	    	addInternalFrameListener(new InternalFrameAdapter() {
	    		public void internalFrameClosing(InternalFrameEvent e){

	    			dispose();
	    		}
			});
		
			setBounds(100, 50, 390, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(null);
			
			btnCadastra = new JButton("Cadastra");
			btnCadastra.setBounds(265, 300, 100, 35);
			btnCadastra.addActionListener(this);
			add (btnCadastra);
			
			
			lblCpf = new JLabel ("Cpf");
			lblCpf.setBounds(15, 5, 100, 45);
			add (lblCpf);
			
			lblLogin = new JLabel ("Senha");
			lblLogin.setBounds(15, 75, 100, 45);
			add (lblLogin);
			
			lblSenha = new JLabel ("Senha");
			lblSenha.setBounds(15, 145, 100, 45);
			add (lblSenha);
			
			lblConfSenha = new JLabel ("Senha");
			lblConfSenha.setBounds(15, 220, 100, 45);
			add (lblConfSenha);
			
			txtCpf = new JTextField ();
			txtCpf.setBounds(15, 45, 350, 30);
			add (txtCpf);

			txtLogin = new JTextField();
			txtLogin.setBounds(15, 115, 350, 30);
			add (txtLogin);
			
			txtSenha = new JPasswordField();
			txtSenha.setBounds(15, 185, 350, 30);
			add (txtSenha);
			
			txtConfSenha = new JPasswordField();
			txtConfSenha.setBounds(15, 255, 350, 30);
			add (txtConfSenha);
			
			
			
			
			setResizable(false);
			getContentPane().setBackground(Color.LIGHT_GRAY);
			setVisible(true);
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
