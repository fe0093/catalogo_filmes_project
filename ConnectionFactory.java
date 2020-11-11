
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "admin123";
    private String host = "localhost";
    private String porta = "3306";
    private String db = "db_filmes";
    
    public Connection obterConexao (){
        
        try{
            Connection c = DriverManager.getConnection(
                //jdbc:mysql://localhost:3306/usjt_db_pessoas    
                "jdbc:mysql://" + host + ":" + porta + "/" + db + "?useTimezone=true&serverTimezone=UTC",
                usuario,
                senha
            );
            return c;
                                    
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }      
    }
    
    
}
