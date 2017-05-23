import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Principal extends JFrame implements ActionListener{
	
	private JButton btnLogin;
	private JLabel lblnome;
	private JLabel lblsenha;
	private JTextField txtnome;
	private JTextField txtsenha;
	
public Principal() {

	setBounds(100, 50, 303, 300);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	
	btnLogin = new JButton("Login");
	btnLogin.setBounds(20, 200, 100, 35);
	btnLogin.addActionListener(this);
	add (btnLogin);
	
	
	lblnome = new JLabel ("Nome");
	lblnome.setBounds(20, 5, 100, 45);
	add (lblnome);
	
	lblsenha = new JLabel ("Senha");
	lblsenha.setBounds(20, 75, 100, 45);
	add (lblsenha);
	
	txtnome = new JTextField ();
	txtnome.setBounds(20, 45, 250, 20);
	add (txtnome);
	
	txtsenha = new JTextField ();
	txtsenha.setBounds(20, 113, 250, 20);
	add (txtsenha);
	setResizable(false);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setVisible(true);
	}
		
	public static void main(String[] args) {

		Principal prin = new Principal();
		prin.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	/*public void actionPerformed(ActionEvent AE) {
	if(AE.getSource() == btnLogin){
		BeansFuncionario paciente = new BeansFuncionario();
		paciente.setCodp(Integer.parseInt(txtsenha.getText()));
		paciente.setNome(txtnome.getText());
		
		Daofuncionario dao = new Daofuncionario();
		dao.inserirPaciente(paciente);
		
	}
	}
		*/

	
}
