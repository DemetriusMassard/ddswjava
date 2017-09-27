import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
		
			setBounds(100, 50, 600, 600);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(null);
			
			btnCadastra = new JButton("Cadastra");
			btnCadastra.setBounds(100, 150, 100, 35);
			btnCadastra.addActionListener(this);
			add (btnCadastra);
			
			
			lblCpf = new JLabel ("Cpf");
			lblCpf.setBounds(20, 5, 100, 45);
			add (lblCpf);
			
			lblLogin = new JLabel ("Senha");
			lblLogin.setBounds(20, 75, 100, 45);
			add (lblLogin);
			
			lblSenha = new JLabel ("Senha");
			lblSenha.setBounds(20, 150, 100, 45);
			add (lblSenha);
			
			lblConfSenha = new JLabel ("Senha");
			lblConfSenha.setBounds(20, 220, 100, 45);
			add (lblSenha);
			
			txtCpf = new JTextField ();
			txtCpf.setBounds(20, 45, 250, 25);
			add (txtCpf);

			txtLogin = new JPasswordField();
			txtLogin.setBounds(20, 113, 250, 25);
			add (txtLogin);
			
			txtSenha = new JPasswordField();
			txtSenha.setBounds(20, 213, 250, 25);
			add (txtSenha);
			
			txtConfSenha = new JPasswordField();
			txtConfSenha.setBounds(20, 413, 250, 25);
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
