import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Model Class for Product
class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return String.format("%d | %s | %.2f | %d", productId, productName, price, quantity);
    }
}

// Model Class for Student
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

public class Main {
    private static List<Product> productList = new ArrayList<>();
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Product CRUD Operations");
            System.out.println("2. Student CRUD Operations");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    productCRUD(scanner);
                    break;
                case 2:
                    studentCRUD(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Product CRUD Operations
    public static void productCRUD(Scanner scanner) {
        int choice;
        while (true) {
            System.out.println("\nProduct Menu:");
            System.out.println("1. Create Product");
            System.out.println("2. Read Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createProduct(scanner);
                    break;
                case 2:
                    readProducts();
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Student CRUD Operations
    public static void studentCRUD(Scanner scanner) {
        int choice;
        while (true) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. Create Student");
            System.out.println("2. Read Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createStudent(scanner);
                    break;
                case 2:
                    readStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // CRUD Methods for Product
    public static void createProduct(Scanner scanner) {
        System.out.print("Enter ProductID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter ProductName: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(productId, productName, price, quantity);
        productList.add(product);
        System.out.println("Product created successfully.");
    }

    public static void readProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\nProductID | ProductName | Price | Quantity");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.print("Enter ProductID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = findProductById(productId);
        if (product != null) {
            System.out.print("Enter new ProductName: ");
            String productName = scanner.nextLine();
            System.out.print("Enter new Price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter new Quantity: ");
            int quantity = scanner.nextInt();

            product.setProductName(productName);
            product.setPrice(price);
            product.setQuantity(quantity);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.print("Enter ProductID to delete: ");
        int productId = scanner.nextInt();

        Product product = findProductById(productId);
        if (product != null) {
            productList.remove(product);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static Product findProductById(int productId) {
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    // CRUD Methods for Student
    public static void createStudent(Scanner scanner) {
        System.out.print("Enter StudentID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();

        Student student = new Student(studentId, name, department, marks);
        studentList.add(student);
        System.out.println("Student created successfully.");
    }

    public static void readStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("\nStudentID | Name | Department | Marks");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static void updateStudent(Scanner scanner) {
        System.out.print("Enter StudentID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = findStudentById(studentId);
        if (student != null) {
            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Department: ");
            String department = scanner.nextLine();
            System.out.print("Enter new Marks: ");
            int marks = scanner.nextInt();

            student.setName(name);
            student.setDepartment(department);
            student.setMarks(marks);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void deleteStudent(Scanner scanner) {
        System.out.print("Enter StudentID to delete: ");
        int studentId = scanner.nextInt();

        Student student = findStudentById(studentId);
        if (student != null) {
            studentList.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudentById(int studentId) {
        for (Student student : studentList) {
            if (student.getStudentID() == studentId) {
                return student;
            }
        }
        return null;
    }
}
