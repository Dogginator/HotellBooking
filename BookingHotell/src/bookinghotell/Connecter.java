
package bookinghotell;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface Connecter {
     
    
    List<PassWord> passWord = new ArrayList<>();
        public static class Help {

        private static Statement sqlStatement = null;

        
        protected static Connection con(String url, String user, String password) throws SQLException {

            Connection connection = DriverManager.getConnection(url, user, password);
            sqlStatement = connection.createStatement();
            return connection;
            
        }
        

    }  
}

