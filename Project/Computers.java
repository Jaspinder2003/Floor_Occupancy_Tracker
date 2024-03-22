import java.util.ArrayList;
import java.util.HashMap;

class Computers extends data{
    private int computers_availability;
    private String name;
    private int id;
    public Computers(String name,int id,int floor){
        super(name,id);
        this.name=name;
        this.id=id;

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