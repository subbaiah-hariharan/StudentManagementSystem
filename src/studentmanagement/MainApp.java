package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainApp {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "dhiva1206"   // unga MySQL password
            );
            System.out.println("✅ Database Connected Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}