package Project1;

import java.util.Scanner;

public class Main {
    private static final String UNIVERSAL_PASSWORD = "admin123"; // Set your universal password here

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Get Student by Name");
            System.out.println("3. Delete Student by Name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    studentDAO.addStudent(name, age, course, email);
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    studentDAO.getStudentByName(searchName);
                    break;

                case 3:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    System.out.print("Enter universal password: ");
                    String password = scanner.nextLine();

                    if (password.equals(UNIVERSAL_PASSWORD)) {
                        studentDAO.deleteStudentByName(deleteName);
                    } else {
                        System.out.println("Incorrect universal password. Deletion failed.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
