import java.util.*;

/**
  Central manager for students, rooms, and allocations.
 */
public class Manager {
    private List<Student> students;
    private List<Room> rooms;
    private Allocation allocation;

    public Manager() {
        students = new ArrayList<>();
        rooms = new ArrayList<>();
        allocation = new Allocation();
    }

    // ==================== Student Management ====================
    public boolean registerStudent(String studentId, String name, String department) {
        if (findStudentById(studentId) != null) {
            System.out.println("Error: Student ID " + studentId + " already exists.");
            return false;
        }
        students.add(new Student(studentId, name, department));
        System.out.println("Success: Student " + studentId + " registered.");
        return true;
    }

    public Student findStudentById(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) return s;
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // defensive copy
    }

    // ==================== Room Management ====================
    public boolean addRoom(int roomNumber, int capacity) {
        if (findRoomByNumber(roomNumber) != null) {
            System.out.println("Error: Room #" + roomNumber + " already exists.");
            return false;
        }
        rooms.add(new Room(roomNumber, capacity));
        System.out.println("Success: Room #" + roomNumber + " added.");
        return true;
    }

    public Room findRoomByNumber(int roomNumber) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) return r;
        }
        return null;
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    // ==================== Allocation Operations ====================
    public boolean allocateRoom(String studentId, int roomNumber) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Error: Student " + studentId + " not found.");
            return false;
        }
        Room room = findRoomByNumber(roomNumber);
        if (room == null) {
            System.out.println("Error: Room #" + roomNumber + " not found.");
            return false;
        }
        return allocation.allocateStudentToRoom(student, room);
    }

    public boolean deallocateRoom(String studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Error: Student " + studentId + " not found.");
            return false;
        }
        return allocation.deallocateStudent(student);
    }

    public void viewAllAllocations() {
        allocation.displayAllAllocations();
    }

    // ==================== Statistics ====================
    public void displaySystemStats() {
        int totalCapacity = rooms.stream().mapToInt(Room::getCapacity).sum();
        int totalOccupancy = rooms.stream().mapToInt(Room::getCurrentOccupancy).sum();

        System.out.println("\n========== System Statistics ==========");
        System.out.println("Total Students     : " + students.size());
        System.out.println("Total Rooms        : " + rooms.size());
        System.out.println("Total Capacity     : " + totalCapacity);
        System.out.println("Current Occupancy  : " + totalOccupancy);
        System.out.println("Available Seats    : " + (totalCapacity - totalOccupancy));
        System.out.println("Allocated Students : " + allocation.getAllAllocations().size());
        System.out.println("=======================================\n");
    }
}