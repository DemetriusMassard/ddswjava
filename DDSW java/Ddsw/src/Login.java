import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javaBeans.BeansLogin;

import javax.swing.*;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import dao.DaoLogin;

public class Login extends JFrame implements ActionListener{

	private JButton btnLogin;
	private JLabel lblnome;
	private JLabel lblsenha;
	private JTextField txtnome;
	private JPasswordField txtsenha;
	
	public Login() {
	
		setBounds(100, 50, 300, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(100, 150, 100, 35);
		btnLogin.addActionListener(this);
		add (btnLogin);
		
		
		lblnome = new JLabel ("Nome");
		lblnome.setBounds(20, 5, 100, 45);
		add (lblnome);
		
		lblsenha = new JLabel ("Senha");
		lblsenha.setBounds(20, 75, 100, 45);
		add (lblsenha);
		
		txtnome = new JTextField ();
		txtnome.setBounds(20, 45, 250, 25);
		add (txtnome);

		txtsenha = new JPasswordField();
		txtsenha.setBounds(20, 113, 250, 25);
		add (txtsenha);
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		}
	
 
	public String md5(String senha) throws NoSuchAlgorithmException {
		 senha  = txtsenha.getText();
			
		MessageDigest md = MessageDigest.getInstance("MD5");
		 md.update(senha.getBytes());
		 BigInteger hash = new BigInteger(1, md.digest());
		 return hash.toString(16);
		 //txtsenha.Text = senha ;
		}
	public void actionPerformed(ActionEvent AE) {
		
		
		if(AE.getSource() == btnLogin){
			BeansLogin login = new BeansLogin();
			login.setLogin(txtnome.getText());
			try {
				login.setSenha(md5(txtsenha.getText()));
			} catch (NoSuchAlgorithmException e) {
				
				e.printStackTrace();
			}
			DaoLogin dao = new DaoLogin();
			//JOptionPane.showMessageDialog(null, "oi");
			if(dao.login(login)){
				MDIpai mdi = new MDIpai();
				mdi.setVisible(true);
				this.setVisible(false);
			}
				
		}
	}

}
