
package bankmanagement;

import java.sql.*;
public class Conn {
    public Connection c;
       public  Statement s;
       public Conn() {
       
        
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Lakshya@150903");
           s = c.createStatement();
        }  catch (Exception e) {
           System.out.println(e);
        }
    }
    
    public void close() {
        try {
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e);
        }
    }

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
