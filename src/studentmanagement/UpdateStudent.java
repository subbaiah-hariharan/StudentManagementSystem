package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        System.out.print("Enter new name: ");
        String name = sc.next();

        System.out.print("Enter new age: ");
        int age = sc.nextInt();

        System.out.print("Enter new course: ");
        String course = sc.next();

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "dhiva1206"
            );

            String sql = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setString(3, course);
            pst.setInt(4, id);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student Updated Successfully!");
            } else {
                System.out.println("⚠ Student ID not found!");
            }

            pst.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}