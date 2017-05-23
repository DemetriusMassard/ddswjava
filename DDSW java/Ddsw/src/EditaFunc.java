import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Complement;

public class EditaFunc extends JFrame implements ActionListener{
	
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
	
public EditaFunc() {

	setBounds(100, 50, 600, 600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	
	btnincluir = new JButton("Incluir");
	btnincluir.setBounds(470, 520, 100, 35);
	btnincluir.addActionListener(this);
	add (btnincluir);

	btnexcluir = new JButton("Excluir");
	btnexcluir.setBounds(370, 520, 100, 35);
	btnexcluir.addActionListener(this);
	add (btnexcluir);
	
	lblnome = new JLabel ("Nome");
	lblnome.setBounds(10, 5, 100, 45);
	add (lblnome);
	
	lblcpf = new JLabel ("Cpf");
	lblcpf.setBounds(60, 75, 100, 45);
	add (lblcpf);
	
	lblcep = new JLabel ("Cep");
	lblcep.setBounds(10, 145, 100, 45);
	add (lblcep);
	
	lblnumero = new JLabel ("Numero");
	lblnumero.setBounds(10, 220, 100, 45);
	add (lblnumero);
		
	lblcomplemento = new JLabel ("Complento");
	lblcomplemento.setBounds(10, 295, 120, 45);
	add (lblcomplemento);
	
	lblemail = new JLabel ("Email");
	lblemail.setBounds(10, 220, 100, 45);
	add (lblemail);
		
	lblrg = new JLabel ("Rg");
	lblrg.setBounds(10, 295, 120, 45);
	add (lblrg);
	
	txtnome = new JTextField ();
	txtnome.setBounds(10, 45, 250, 30);
	add (txtnome);
	
	txtcpf = new JTextField ();
	txtcpf.setBounds(10, 115, 250, 30);
	add (txtcpf);
	
	txtcep = new JTextField ();
	txtcep.setBounds(10, 350, 550, 100);
	add (txtcep);
	
	txtnumero = new JTextField ();
	txtnumero.setBounds(10, 185, 250, 30);
	add (txtnumero);
	
	txtcomplemento = new JTextField ();
	txtcomplemento.setBounds(10, 255, 250, 30);
	add (txtcomplemento);
	
	txtemail = new JTextField ();
	txtemail.setBounds(10, 255, 250, 30);
	add (txtemail);
	
	txtrg = new JTextField ();
	txtrg.setBounds(10, 350, 550, 100);
	add (txtrg);
	
	setResizable(false);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setVisible(true);
	}
		
	public static void main(String[] args) {
		EditaFunc prin = new EditaFunc();
		prin.setVisible(true);
	}


public void actionPerformed(ActionEvent arg0) {
	
}
}