import java.util.ArrayList;
import java.util.Scanner;

public class studentManagement {
    private static ArrayList<student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        students.add(new student(id, name, marks));
        System.out.println("Student Added Successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        for (student s : students) {
            if (s.getId() == id) {
                sc.nextLine();
                System.out.print("Enter New Name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter New Marks: ");
                s.setMarks(sc.nextDouble());
                System.out.println("Student Updated!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();
        students.removeIf(s -> s.getId() == id);
        System.out.println("Student Deleted (if found).");
    }
}
