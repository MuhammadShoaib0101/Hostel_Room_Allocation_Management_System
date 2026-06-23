public class students{
    private String name;
    private String department;
    private Room allocatedRoom;

    //constructor 
    public students(String n, String d){
        this.name = n;
        this.department = d;
    }

    //getters and setters
    public  void setname(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }

}
