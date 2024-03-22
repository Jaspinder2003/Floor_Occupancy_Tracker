import java.util.ArrayList;
import java.util.HashMap;

class Computers extends data{
    private int computers_availability;
    private String name;
    private int id;
    private int floor;
    public Computers(String name,int id,int floor){
        super(name,id);
        this.name=name;
        this.id=id;
        this.floor=floor;
    }

    public int getComputerAvailability(data data){
        HashMap<Integer,Integer> m =data.getComputer_vacancy();
        if (!m.containsKey(this.floor)) {
            throw new IllegalArgumentException("Floor does not exist.");
        }
        this.computers_availability=m.get(this.floor);
        return computers_availability;
    }
    public void new_computer_ava(int computer_ava,data data){
        data.set_computer_vacancy(this.floor,computer_ava);
    }




}