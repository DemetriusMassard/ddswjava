import javax.swing.*;
import javax.swing.border.Border;

import sun.rmi.server.Activation.DefaultExecPolicy;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;


public class MDIpai extends JFrame implements ActionListener{
	JMenuBar barra;
	JMenu menu;
	JMenuItem Contatos,Func,Contato,Projeto,CadastroLogin;
	JDesktopPane desktop;
	public MDIpai(){
		desktop = new JDesktopPane();
		setContentPane(desktop);
		barra = new JMenuBar();

		
		Contatos = new JMenuItem("Contato");
		Contatos.addActionListener(this);
        Dimension d = Contatos.getPreferredSize();
        d.setSize(100, 100);
        Contatos.setMaximumSize(d);
		barra.add(Contatos);

		Func = new JMenuItem("Funcionarios");
        d = Func.getPreferredSize();
        d.setSize(100, 100);
        Func.setMaximumSize(d);
		barra.add(Func);
		
		Func.addActionListener(this);
		
		Contato = new JMenuItem("Editar Contato");
        d = Contato.getPreferredSize();
        d.setSize(100, 100);
        Contato.setMaximumSize(d);
		barra.add(Contato);
		Contato.addActionListener(this);
		
		Projeto = new JMenuItem("Editar Projeto");
        d = Projeto.getPreferredSize();
        d.setSize(100, 100);
        Projeto.setMaximumSize(d);
		barra.add(Projeto);
		Projeto.addActionListener(this);
		
		CadastroLogin = new JMenuItem("CasdatroLogin");
        d = CadastroLogin.getPreferredSize();
        d.setSize(100, 100);
        CadastroLogin.setMaximumSize(d);
		barra.add(CadastroLogin);
		CadastroLogin.addActionListener(this);
		
		setJMenuBar(barra);
		setBounds(100,100,800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		desktop.setBackground(Color.LIGHT_GRAY);
		
		
	}
	
	public void actionPerformed(ActionEvent AE) {
		if(AE.getSource()== Func){
			EditaFunc teste = new EditaFunc();
			desktop.add(teste);
			teste.setVisible(true);
				
			
		}
		if(AE.getSource() == Contatos){
			Contatos cont = new Contatos();
			desktop.add(cont);
			cont.setVisible(true);
		}
		
		if(AE.getSource() == Contato){
			EditaContato Contato =  new EditaContato();
			desktop.add(Contato);
			Contato.setVisible(true);
			
		}
		if(AE.getSource() == Projeto){
			EditaProjeto teste =  new EditaProjeto();
			desktop.add(teste);
			Contato.setVisible(true);
		}
		if(AE.getSource() == CadastroLogin){
			CadastroLogin teste =  new CadastroLogin();
			desktop.add(teste);
			CadastroLogin.setVisible(true);
		}
	}

}
