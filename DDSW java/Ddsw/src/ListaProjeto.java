import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


import javaBeans.BeansProjeto;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import sun.applet.Main;



import dao.DaoContatos;
import dao.Daoprojeto;


public class ListaProjeto extends JFrame implements ActionListener {
	 
	ListaProjeto tp;
	
    JButton btnBuscar, btnExcluir, btnEditar;
    JLabel lblId, lblNome, lblTelefone, lblSexo, lblRenda, lblCadastro;
    JTextField txtNome;
    JFormattedTextField txtTelefone, txtId, txtRenda;
    MaskFormatter mskTelefone, mskId;
    ButtonGroup gruSexo;
    JRadioButton rdoMasculino, rdoFeminino;
    JComboBox<String> cbxTurno;
    
    //Variáveis para montar a grid
    JTable tabela;
    DefaultTableModel model;
    JScrollPane scroll;
    
    public ListaProjeto() {
    	int x = 30;
    	int y = 30;
    	setTitle("Consulta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(x+400, y+200, 650, 450);
        
        lblCadastro = new JLabel("Consulta ______________________________________________________________________");
        lblCadastro.setBounds(x+10, 10, 550, 30);
        add(lblCadastro);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(x+10, y+10, 50, 30);
        add(lblNome);
 
        txtNome = new JTextField(40);
        txtNome.setBounds(x+10, y+40, 550, 30);
        add(txtNome);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(x+10, y+80, 120, 30);
        btnBuscar.addActionListener(this);
        add(btnBuscar);
        
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(x+310, y+80, 120, 30);
        btnEditar.addActionListener(this);
        add(btnEditar);
        
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(x+440, y+80, 120, 30);
        btnExcluir.addActionListener(this);
        add(btnExcluir);
        
        tabela = new JTable();
        scroll = new JScrollPane();
        scroll.setViewportView(tabela);
        scroll.setBounds(x+10, y+130, 550, 210);
        //add(montarGrid());
        
    }
    /*
    public static void main(String args[]) {
    	ListaProjeto tela = new ListaProjeto();
        tela.setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e) {
        String mensagem;
        if (e.getSource() == btnEditar) {
            //JTable tabela;
            //DefaultTableModel model;
        	
        	int linha = tabela.getSelectedRow();
        	if(linha!=-1){
	        	BeanAluno aluno = getBeanAlunoFromGrid(linha);	        	
	        	TelaCadastroAluno tc = new TelaCadastroAluno();
	        	TelaPrincipal tp = getTelaPrincipal();
	        	tp.setContentPane(tc.getContentPane());
	        	tp.setVisible(true);
	        	tc.preencherCampos(aluno);
        	}else{
        		JOptionPane.showMessageDialog(null, "Selecione uma linha para editar!", "Atenção!", JOptionPane.PLAIN_MESSAGE);
        	}
        }else if (e.getSource() == btnExcluir) {
        	int linha = tabela.getSelectedRow();
        	DaoAluno da = new DaoAluno();
        	da.conectar();
        	if (da.excluir(Integer.parseInt(model.getValueAt(linha, 0).toString()))){
        		JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!", "Atenção!", JOptionPane.PLAIN_MESSAGE);
        	}else{
        		JOptionPane.showMessageDialog(null, "Não foi possível excluir o registro!", "Atenção!", JOptionPane.PLAIN_MESSAGE);
        	}
        	txtNome.setText("");
        	montarGrid("");
        }else if (e.getSource() == btnBuscar) {
        	montarGrid(txtNome.getText());        	
        }            
    }

   
    
    
    public JScrollPane montarGrid(){
    	return montarGrid(null);
    }
    
    public JScrollPane montarGrid(String nome){
        String[] colunas = new String[]{"id","nome","telefone","sexo","renda","turno","curso","area"};
        String[][] dados = new String[][]{};        
        if (nome!=null){
            DaoAluno da = new DaoAluno();
            int r = da.conectar();
            if (r == 2) {
                JOptionPane.showMessageDialog(null,"Driver de conexão não foi encontrado");
            } else if (r == 3) {
                JOptionPane.showMessageDialog(null,"Os dados de conexão com o banco de dados estão incorretos");
            }            
            ArrayList<BeansProjeto> listaDeAlunos = da.buscar(nome);
            
            dados = new String[listaDeAlunos.size()][8];
            int i=0;
            for (BeansProjeto aluno : listaDeAlunos){
            	dados[i][0] = String.valueOf(aluno.getCod());
            	dados[i][1] = String.valueOf(aluno.getCodcontato());
            	dados[i][2] = String.valueOf(aluno.getNomeProj());
            	dados[i][3] = String.valueOf(aluno.getObs());
            	     	
            	i++;
            }           
            /* Exemplo de dados populados na matriz dados
            dados = new String[][]{            		
            	{"1","João","1183750981","masculino","1000","noite","TADS","sim"},
            	{"2","Maria","1195480598","feminino","1200","manhã","TGTI","não"},
            	{"3","Ana","1129294857","feminino","2000","noite","TBDB","não"},
            	{"4","Pedro","1195848273","masculino","1750","manhã","TSEG","sim"},
            	{"5","Joaquim","1110394872","masculino","3400","tarde","TADS","sim"},
            	{"6","Cristina","1118374657","feminino","7500","tarde","TSIN","sim"}
             };
                     
        }else{
        	dados = new String[][]{};
        }    	        
        model = new DefaultTableModel(dados , colunas);//Adiciona os dados na grid
        tabela.setModel(model);
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(130);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(60);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(7).setPreferredWidth(60);
        
        return scroll;
    }*/

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
    //TODO Terminar form de listar projs
}
