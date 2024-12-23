package fluxio;

import GUI.SignUpScreen;
import util.DBConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        SignUpScreen signUpFrame = new SignUpScreen();
        signUpFrame.setVisible(true);
        signUpFrame.pack();
        signUpFrame.setLocationRelativeTo(null);

        Connection connection = DBConnection.getConnection();
        DBConnection.printInfo(connection);

        if (connection != null) {
            String sqlFilePath = "src/util/inventorydatabase.sql"; 
            DBConnection.runSQLScript(sqlFilePath);
        }

        // Close the connection when the application is exiting, if needed
        // Runtime.getRuntime().addShutdownHook(new Thread(() -> DBConnection.closeConnection(connection)));
    }
}
    

