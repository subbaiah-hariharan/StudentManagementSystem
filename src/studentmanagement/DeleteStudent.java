package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        try {
            // 1. Connect to DB
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "dhiva1206"
            );

            // 2. Prepare DELETE query
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            // 3. Execute query
            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Student Deleted Successfully!");
            } else {
                System.out.println("⚠ Student ID not found!");
            }

            // 4. Close resources
            pst.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}