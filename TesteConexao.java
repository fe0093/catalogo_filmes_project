
import java.sql.Connection;

public class TesteConexao {
    
    public static void main(String[] args) {
        ConnectionFactory fabrica = new ConnectionFactory();
        Connection c = fabrica.obterConexao();
        if (c != null)
            System.out.println("Beleza, deu certo");
        else
            System.out.println ("Não deu certo");
    }
    
}
