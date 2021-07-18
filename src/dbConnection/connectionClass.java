package dbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;


public class connectionClass {
    public Connection connection;
    public Connection getConnection(){
//        String dbName = "students";
        String userName = "root";
        String password = "";
        String dburl = "jdbc:mysql://localhost:3306/Students?useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(dburl,userName,password);
            System.out.println("Database Connected");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
