import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/library";
            String user      = "root";
            String password  = "ManuMishra#04";
            
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            
            System.out.println("Connection to the database has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}

    

