package dao;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexao {
 
   
    private String statusConexao = "N�o conectado";
 
    public Connection getConexao() {
        Connection conexao = null;

        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
 
            String servidor = "localhost";
            String dataBaseName = "ddsw";
            String url = "jdbc:mysql://" + servidor + "/" + dataBaseName;

            String usuario = "root";
            String senha = "";  
 
            conexao = (Connection) DriverManager.getConnection(url, usuario, senha);
 
            if (conexao != null) {
                statusConexao = ("Conetado");
            } else {
                statusConexao = ("N�o conectado");
            }
            return conexao;
 
        } catch (ClassNotFoundException e) {
            System.out.println("Driver de conex�o n�o encontrado    ");
            return null;
        } catch (SQLException e) {
            System.out.println("Falha na conex�o: ");
            System.out.println(e.getMessage());
            return null;
        }
    }
 
    public String getStatusConexao() {
        return statusConexao;
    }
    public boolean FechaConexao() {
        try {
            getConexao().close();
            statusConexao = "Conex�o fechada";
            return true;
        } catch (SQLException e) {          
            System.out.println(e.getMessage());
            return false;
        }
    }
 

    public Connection ReiniciaConexao() {
        FechaConexao(); 
        return getConexao();
    }
}