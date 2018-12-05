package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sineek
 */
public class JavaApplication1 {
    static final String JDBC_DRIVER="org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/lista8";
    
    public static void main(String[] args) throws Exception {
        Class.forName(JDBC_DRIVER);
        Connection conexao = DriverManager.getConnection(DATABASE_URL, "postgres", "postgres");
        System.out.println("Conexão efetuada com sucesso \n");
        
        Statement stm = conexao.createStatement();
        String SQL = "INSERT INTO Vendas VALUES (6, 2018-11-05, 200, 12263994602)";
        stm.executeQuery(SQL);
        stm.close();
        System.out.println("uhul");
    }

}
