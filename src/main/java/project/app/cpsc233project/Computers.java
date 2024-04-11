package project.app.cpsc233project;
import java.util.HashMap;
import java.util.HashSet;

class Computers extends data{
    private int computers_availability;
    private String name;
    private int id;
    private int floor;

    static HashSet<Computers> ComputerObjects = new HashSet<Computers>(); // Set to store reported fighter spaceships

    public Computers(String name,int id,int floor){
        super(name,id, floor);
        this.name=name;
        this.id=id;
        this.floor=floor;

    }

    public Integer getFloor(){
        return floor;
    }

    public static void AddUser(Computers computers) {
        ComputerObjects.add(computers);
    }

    public int getComputerAvailability(Integer floor,data data){
        HashMap<Integer,Integer> m =data.getFloor_vacancy();
        if (!m.containsKey(floor)) {
            throw new IllegalArgumentException("Floor does not exist.");
        }
        this.computers_availability=m.get(floor);
        return computers_availability;
    }
    public void new_computer_ava(Integer floor,int computer_ava,data data){
        data.set_computer_vacancy(floor,computer_ava);
    }

}