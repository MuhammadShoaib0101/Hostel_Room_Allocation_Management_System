//import java.util.ArrayList;
import java.util.List;

public class rooms {
    private int roomNumber;
    private int capacity;
    private List<students> occupants;

    public rooms(int r, int c){
        this.roomNumber = r;
        this.capacity = c;
    }

    public void setRoomNo(int r){
        this.roomNumber = r;
    }

    public int getRoomNo(){
        return roomNumber;
    }

    public void setcapacity(int c){
        this.capacity = c;
    }
    public int getcapacity(){
        return capacity;
    }
    public int getCurrentOccupancy(){
        return occupants.size();
    }
    public int getAvailableSeats(){
        return capacity - occupants.size();
    }

    boolean isAvailable(){
        return occupants.size() < capacity;
    }

    public boolean addStudent(students student)


}
