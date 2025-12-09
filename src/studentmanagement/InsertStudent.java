package studentmanagement;

import java.util.Scanner;

public class InsertStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    InsertStudent.main(new String[]{});
                    break;
                case 2:
                    ViewStudents.main(new String[]{});
                    break;
                case 3:
                    UpdateStudent.main(new String[]{});
                    break;
                case 4:
                    DeleteStudent.main(new String[]{});
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("⚠ Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}