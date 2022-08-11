import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    private String username = "Mysql database username";
    private String password = "Mysql Password";
    private String dbUrl = "jdbc:mysql://localhost:3306/databasename"; // localhost kısmı değişiklik gösterebilir

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);

    }

    public void ShowErrorMessage(SQLException exception) {
        System.out.println("Error : " + exception.getMessage());
        System.out.println("Error code : " + exception.getErrorCode());
    }
}
