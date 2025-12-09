import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem{
    static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";      // MySQL username
    static final String PASS = "dhiva1206";  // MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            while(choice != 0) {
                System.out.println("===== Student Management System (DB) =====");
                System.out.println("1. Insert Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                if(sc.hasNextInt()) {
                    choice = sc.nextInt();
                    sc.nextLine(); // consume newline
                } else {
                    System.out.println("Invalid input! Enter a number.");
                    sc.nextLine();
                    continue;
                }

                switch(choice) {
                    case 1: // Insert
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        String insertSQL = "INSERT INTO students(name, age, course) VALUES (?, ?, ?)";
                        PreparedStatement psInsert = conn.prepareStatement(insertSQL);
                        psInsert.setString(1, name);
                        psInsert.setInt(2, age);
                        psInsert.setString(3, course);
                        psInsert.executeUpdate();
                        System.out.println("Student inserted successfully!");
                        break;

                    case 2: // View
                        String viewSQL = "SELECT * FROM students";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(viewSQL);
                        System.out.println("ID\tName\tAge\tCourse");
                        while(rs.next()) {
                            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" 
                                + rs.getInt("age") + "\t" + rs.getString("course"));
                        }
                        break;

                    case 3: // Update
                        System.out.print("Enter ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new Age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Course: ");
                        String newCourse = sc.nextLine();

                        String updateSQL = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
                        PreparedStatement psUpdate = conn.prepareStatement(updateSQL);
                        psUpdate.setString(1, newName);
                        psUpdate.setInt(2, newAge);
                        psUpdate.setString(3, newCourse);
                        psUpdate.setInt(4, updateId);
                        int updated = psUpdate.executeUpdate();
                        if(updated > 0) System.out.println("Student updated successfully!");
                        else System.out.println("Student ID not found!");
                        break;

                    case 4: // Delete
                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();
                        String deleteSQL = "DELETE FROM students WHERE id=?";
                        PreparedStatement psDelete = conn.prepareStatement(deleteSQL);
                        psDelete.setInt(1, deleteId);
                        int deleted = psDelete.executeUpdate();
                        if(deleted > 0) System.out.println("Student deleted successfully!");
                        else System.out.println("Student ID not found!");
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Enter 0-4.");
                }

                System.out.println();
            }

            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}