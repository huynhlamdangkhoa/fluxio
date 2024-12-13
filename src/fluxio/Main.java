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
         
        //Connect to database
        Connection conn = DBConnection.getConnection();
        
        if (conn != null) {
            String sqlFilePath = "src/util/inventorydatabase.sql"; // Đảm bảo đường dẫn chính xác
            DBConnection.runSQLScript(sqlFilePath);
        }
        
        // Đóng kết nối
        DBConnection.closeConnection();
    }
    
}
