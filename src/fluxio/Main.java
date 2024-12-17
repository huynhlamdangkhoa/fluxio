package fluxio;

import GUI.LoginScreen;
import util.DBConnection;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        LoginScreen loginFrame = new LoginScreen();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
         
        Connection connection = DBConnection.getConnection();
        DBConnection.printInfo(connection);
        
        if (connection != null) {
            String sqlFilePath = "src/util/inventorydatabase.sql"; 
            DBConnection.runSQLScript(sqlFilePath);
        }
        
        DBConnection.closeConnection(connection);
    }
    
}
