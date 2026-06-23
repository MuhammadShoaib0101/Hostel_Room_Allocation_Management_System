import java.util.Scanner;

public class Application {
    private static Manager manager = new Manager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample Data
        manager.addRoom(101, 2);
        manager.addRoom(102, 3);
        manager.addRoom(103, 1);
        manager.registerStudent("S001", "Ali", "CS");
        manager.registerStudent("S002", "Ahmed", "SE");

        int choice;
        do {
            printMenu();
            choice = getIntInput("Enter Choice: ");

            switch (choice) {
                case 1 -> registerStudent();
                case 2 -> addRoom();
                case 3 -> allocateRoom();
                case 4 -> deallocateRoom();
                case 5 -> viewStudents();
                case 6 -> viewRooms();
                case 7 -> manager.viewAllAllocations();
                case 8 -> manager.displaySystemStats();
                case 0 -> System.out.println("Thank you for using the system. Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println("\n===== HOSTEL ROOM ALLOCATION SYSTEM =====");
        System.out.println("1. Register Student");
        System.out.println("2. Add Room");
        System.out.println("3. Allocate Room");
        System.out.println("4. Deallocate Room");
        System.out.println("5. View Students");
        System.out.println("6. View Rooms");
        System.out.println("7. View Allocations");
        System.out.println("8. System Statistics");
        System.out.println("0. Exit");
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    private static void registerStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();

        manager.registerStudent(id, name, dept);
    }

    private static void addRoom() {
        int roomNo = getIntInput("Enter Room Number: ");
        int capacity = getIntInput("Enter Capacity: ");
        manager.addRoom(roomNo, capacity);
    }

    private static void allocateRoom() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        int roomNo = getIntInput("Enter Room Number: ");
        manager.allocateRoom(id, roomNo);
    }

    private static void deallocateRoom() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        manager.deallocateRoom(id);
    }

    private static void viewStudents() {
        System.out.println("\n===== REGISTERED STUDENTS =====");
        for (Student s : manager.getAllStudents()) {
            String room = s.hasRoom() ? String.valueOf(s.getAllocatedRoom().getRoomNumber()) : "Not Allocated";
            System.out.println("ID: " + s.getStudentId() +
                               " | Name: " + s.getName() +
                               " | Dept: " + s.getDepartment() +
                               " | Room: " + room);
        }
    }

    private static void viewRooms() {
        System.out.println("\n===== ROOMS =====");
        for (Room r : manager.getAllRooms()) {
            System.out.println(r);
        }
    }
}