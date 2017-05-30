import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditaProj extends JFrame implements ActionListener{
	
	private JButton btntarefas;
	private JButton btnexcluir;
	private JButton btnincluir;
	private JLabel lblnome;
	private JLabel lblempresa;
	private JLabel lblemail;
	private JLabel lblnomedoproj;
	private JLabel lblobsadc;
	private JTextField txtnome;
	private JTextField txtempresa;
	private JTextField txtemail;
	private JTextField txtnomedoproj;
	private JTextField txtobsadc;
	
public EditaProj() {


	setBounds(100, 50, 600, 550);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
	
	btntarefas = new JButton("Tarefas");
	btntarefas.setBounds(220, 470, 100, 35);
	btntarefas.addActionListener(this);
	add (btntarefas);
	
	btnexcluir = new JButton("Excluir");
	btnexcluir.setBounds(340, 470, 100, 35);
	btnexcluir.addActionListener(this);
	add (btnexcluir);
	
	btnincluir = new JButton("Incluir");
	btnincluir.setBounds(460, 470, 100, 35);
	btnincluir.addActionListener(this);
	add (btnincluir);
	
	
	lblnome = new JLabel ("Nome");
	lblnome.setBounds(15, 5, 100, 45);
	add (lblnome);
	
	lblempresa = new JLabel ("Empresa");
	lblempresa.setBounds(15, 75, 100, 45);
	add (lblempresa);
	
	lblemail = new JLabel ("Email");
	lblemail.setBounds(15, 145, 100, 45);
	add (lblemail);
	
	lblnomedoproj = new JLabel ("Nome do Projeto");
	lblnomedoproj.setBounds(15, 220, 100, 45);
	add (lblnomedoproj);
		
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

	setResizable(false);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	setVisible(true);
	}
		
	public static void main(String[] args) {
		EditaProj prin = new EditaProj();
		prin.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	/*public void actionPerformed(ActionEvent AE) {
	if(AE.getSource() == btnLogin){
		BeansFuncionario funcionario = new BeansFuncionario();
		paciente.setCodp(Integer.parseInt(txtsenha.getText()));
		paciente.setNome(txtnome.getText());
		
		Daofuncionario dao = new Daofuncionario();
		dao.inserirPaciente(paciente);
		
	}
	}
		*/

	
}
