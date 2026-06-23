/**
  Student class represents a student in the hostel management system.
  Stores personal information.
 */
public class Student {
    private String studentId;
    private String name;
    private String department;
    private Room allocatedRoom;  // null if not allocated any room
    
    // Constructor
    public Student(String studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.allocatedRoom = null;  // Initially no room allocated
    }
    
    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }
    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public Room getAllocatedRoom() {
        return allocatedRoom;
    }
    
    public void setAllocatedRoom(Room allocatedRoom) {
        this.allocatedRoom = allocatedRoom;
    }
    
    // Check if student already has a room
    public boolean hasRoom() {
        return allocatedRoom != null;
    }
    
    @Override
    public String toString() {
        return "Student ID: " + studentId + " | Name: " + name + 
               " | Department: " + department + 
               " | Room: " + (allocatedRoom != null ? allocatedRoom.getRoomNumber() : "Not Allocated");
    }
}