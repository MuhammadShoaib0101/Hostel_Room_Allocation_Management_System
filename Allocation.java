import java.util.*;

/**
  Manages the relationship between students and rooms.
 */
public class Allocation {
    private Map<Student, Room> studentRoomMap;
    private Map<Room, List<Student>> roomOccupantsMap;

    public Allocation() {
        studentRoomMap = new HashMap<>();
        roomOccupantsMap = new HashMap<>();
    }

    public boolean allocateStudentToRoom(Student student, Room room) {
        if (student.hasRoom()) {
            System.out.println("Error: Student " + student.getStudentId() + " already has a room.");
            return false;
        }
        if (!room.isAvailable()) {
            System.out.println("Error: Room #" + room.getRoomNumber() + " is full.");
            return false;
        }

        if (room.addStudent(student)) {
            studentRoomMap.put(student, room);
            roomOccupantsMap.computeIfAbsent(room, k -> new ArrayList<>()).add(student);
            System.out.println("Success: Student " + student.getStudentId() +
                               " allocated to Room #" + room.getRoomNumber());
            return true;
        }
        return false;
    }

    public boolean deallocateStudent(Student student) {
        if (!student.hasRoom()) {
            System.out.println("Error: Student " + student.getStudentId() + " has no room.");
            return false;
        }

        Room room = student.getAllocatedRoom();
        if (room.removeStudent(student)) {
            studentRoomMap.remove(student);
            List<Student> occupants = roomOccupantsMap.get(room);
            if (occupants != null) {
                occupants.remove(student);
                if (occupants.isEmpty()) roomOccupantsMap.remove(room);
            }
            System.out.println("Success: Student " + student.getStudentId() +
                               " deallocated from Room #" + room.getRoomNumber());
            return true;
        }
        return false;
    }

    public Room getStudentRoom(Student student) {
        return studentRoomMap.get(student);
    }

    public List<Student> getRoomStudents(Room room) {
        return roomOccupantsMap.getOrDefault(room, new ArrayList<>());
    }

    public Map<Student, Room> getAllAllocations() {
        return new HashMap<>(studentRoomMap);
    }

    public void displayAllAllocations() {
        if (studentRoomMap.isEmpty()) {
            System.out.println("No allocations found.");
            return;
        }
        System.out.println("\n========== Current Allocations ==========");
        for (Map.Entry<Student, Room> entry : studentRoomMap.entrySet()) {
            Student s = entry.getKey();
            Room r = entry.getValue();
            System.out.println(s.getStudentId() + " - " + s.getName() +
                               " -> Room #" + r.getRoomNumber());
        }
        System.out.println("========================================\n");
    }
}