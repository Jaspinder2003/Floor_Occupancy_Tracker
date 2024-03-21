import java.util.HashMap;

class Computers extends data{
    private int computers_availability;
    private String name;
    private int id;
    public Computers(String name,int id,String floor){
        super(name,id);
    }

    public int getComputerAvailability(String floor,data data){
        HashMap<String,Integer> m =data.getFloor_vacancy();
        this.computers_availability=m.get(floor);
        return computers_availability;
    }
    public void new_computer_ava(String floor,int computer_ava,data data){
        data.set_computer_vacancy(floor,computer_ava);
    }

}