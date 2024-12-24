package fluxio;

import GUI.OrderPage;
import GUI.ProductPage;
import GUI.HomePage;
import GUI.SignUpPage;
import util.DBConnection;
import java.sql.Connection;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        HomePage home = new HomePage();
        home.setVisible(true);
        home.pack();
        home.setLocationRelativeTo(null);
        home.setResizable(true);
        
        
//        ProductPage product = new ProductPage();
//        product.setVisible(true);
//        product.pack();
//        product.setLocationRelativeTo(null);
//        product.setResizable(true);
        

        
//        SignUpPage signUpPage = new SignUpPage();
//        signUpPage.setVisible(true);
//        signUpPage.pack();
//        signUpPage.setLocationRelativeTo(null);

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
    

