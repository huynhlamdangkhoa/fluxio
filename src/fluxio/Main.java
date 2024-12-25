package fluxio;

import GUI.OrderPage;
import GUI.ProductPage;
import GUI.HomePage;
import GUI.SignUpPage;
import util.DBConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.setVisible(true);
        signUpPage.pack();
        signUpPage.setLocationRelativeTo(null);
        
        Connection connection = DBConnection.getConnection();
        DBConnection.printInfo(connection);

        if (connection != null) {
            String sqlFilePath = "src/util/inventorydatabase.sql"; 
            DBConnection.runSQLScript(sqlFilePath);
        }
    }
}
    

