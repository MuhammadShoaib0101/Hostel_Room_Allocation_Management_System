import java.util.ArrayList;
import java.util.List;

/**
  Room class represents a hostel room.
 */
public class Room {
    private int roomNumber;
    private int capacity;
    private List<Student> occupants;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.occupants = new ArrayList<>();
    }

    public int getRoomNumber() { return roomNumber; }
    public int getCapacity() { return capacity; }
    public int getCurrentOccupancy() { return occupants.size(); }
    public int getAvailableSeats() { return capacity - occupants.size(); }

    public boolean isAvailable() {
        return occupants.size() < capacity;
    }

    public boolean addStudent(Student student) {
        if (isAvailable() && !occupants.contains(student)) {
            occupants.add(student);
            student.setAllocatedRoom(this);
            return true;
        }
        return false;
    }

    public boolean removeStudent(Student student) {
        if (occupants.remove(student)) {
            student.setAllocatedRoom(null);
            return true;
        }
        return false;
    }

    public List<Student> getOccupants() {
        return new ArrayList<>(occupants); // defensive copy
    }

    @Override
    public String toString() {
        return "Room #" + roomNumber + " | Capacity: " + capacity +
               " | Occupancy: " + getCurrentOccupancy() + "/" + capacity +
               " | Available: " + getAvailableSeats();
    }
}