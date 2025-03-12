import java.util.*;

// Model: Student class with fields and methods
class Student {
    private int studentID;
    private String name;
    private String department;
    private int marks;

    public Student(int studentID, String name, String department, int marks) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    // Getters and setters
    public int getStudentID() { return studentID; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setMarks(int marks) { this.marks = marks; }

    @Override
    public String toString() {
        return String.format("%d | %s | %s | %d", studentID, name, department, marks);
    }
}

// Controller: Handles CRUD operations on the Student model
class StudentController {
    private List<Student> studentList;

    public StudentController() {
        studentList = new ArrayList<>();
    }

    // Create a new student
    public void createStudent(int studentID, String name, String department, int marks) {
        Student student = new Student(studentID, name, department, marks);
        studentList.add(student);
    }

    // Read all students
    public List<Student> readAllStudents() {
        return studentList;
    }

    // Update an existing student
    public boolean updateStudent(int studentID, String name, String department, int marks) {
        for (Student student : studentList) {
            if (student.getStudentID() == studentID) {
                student.setName(name);
                student.setDepartment(department);
                student.setMarks(marks);
                return true;
            }
        }
        return false;
    }

    // Delete a student
    public boolean deleteStudent(int studentID) {
        return studentList.removeIf(student -> student.getStudentID() == studentID);
    }

    // Find a student by ID
    public Student findStudentById(int studentID) {
        for (Student student : studentList) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }
}

// View: Handles user input and displays output
class StudentView {
    public static void printMenu() {
        System.out.println("\nStudent Management System Menu:");
        System.out.println("1. Create Student");
        System.out.println("2. Read All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    public static void printStudentList(List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\nStudentID | Name | Department | Marks");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printStudentDetails(int studentID, String name, String department, int marks) {
        System.out.println("Enter student details:");
        System.out.print("StudentID: " + studentID);
        System.out.print("Name: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Department: ");
        department = new Scanner(System.in).nextLine();
        System.out.print("Marks: ");
        marks = new Scanner(System.in).nextInt();
    }
}

// Main class (Driver)
public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentController controller = new StudentController();
        int choice;

        while (true) {
            StudentView.printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Create Student
                    System.out.print("Enter StudentID: ");
                    int createID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String createName = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String createDepartment = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    int createMarks = scanner.nextInt();

                    controller.createStudent(createID, createName, createDepartment, createMarks);
                    StudentView.printMessage("Student created successfully.");
                    break;

                case 2:
                    // Read All Students
                    List<Student> students = controller.readAllStudents();
                    StudentView.printStudentList(students);
                    break;

                case 3:
                    // Update Student
                    System.out.print("Enter StudentID to update: ");
                    int updateID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new Department: ");
                    String updateDepartment = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    int updateMarks = scanner.nextInt();

                    boolean updateSuccess = controller.updateStudent(updateID, updateName, updateDepartment, updateMarks);
                    if (updateSuccess) {
                        StudentView.printMessage("Student updated successfully.");
                    } else {
                        StudentView.printMessage("Student not found.");
                    }
                    break;

                case 4:
                    // Delete Student
                    System.out.print("Enter StudentID to delete: ");
                    int deleteID = scanner.nextInt();
                    boolean deleteSuccess = controller.deleteStudent(deleteID);
                    if (deleteSuccess) {
                        StudentView.printMessage("Student deleted successfully.");
                    } else {
                        StudentView.printMessage("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    StudentView.printMessage("Invalid choice. Please try again.");
            }
        }
    }
}
