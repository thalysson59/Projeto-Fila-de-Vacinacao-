
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SqlConnection {

    private static String host = "localhost";
    private static String porta = "digite a porta aqui";
    private static String bd = "Nome do banco de dados";
    private static String usuario = "usuário do banco de dados";
    private static String senha = "Senha do banco de dados";

    public static Connection obterConexao() throws Exception {

        Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd + "?userTimezone=true&serverTimezone=America/Sao_Paulo", usuario, senha);

        return c;
    }

}
