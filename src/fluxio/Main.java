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
        HomePage HomePage = new HomePage();
        HomePage.setVisible(true);
        HomePage.pack();
        HomePage.setLocationRelativeTo(null);

        Connection connection = DBConnection.getConnection();
        DBConnection.printInfo(connection);

        if (connection != null) {
            String sqlFilePath = "src/util/inventorydatabase.sql"; 
            DBConnection.runSQLScript(sqlFilePath);
        }
    }
}
    

