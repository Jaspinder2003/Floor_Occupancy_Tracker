import java.util.ArrayList;
import java.util.HashMap; //Imports the hashmap class.

public class data {
    private Integer id;
    private String name;
    private int floor;
    public static HashMap<Integer, Integer> floor_vacancy = new HashMap<Integer, Integer>();//stores and manages availability on each floor.

    public data(String name,int id){
        this.name=name;
        this.id=id;

    }

    static {
        floor_vacancy.put(1, 87);
        floor_vacancy.put(2, 134);
        floor_vacancy.put(3, 200);
    }

    public String getName(){
        return name;
    }

    public Integer getID(){
        return id;
    }
    public HashMap<Integer, Integer> getFloor_vacancy() {
        return floor_vacancy;
    }
    protected void set_floor_vacancy(Integer key,int value){
        if (key == null || value < 0) {
            throw new IllegalArgumentException("Key cannot be null and value must be non-negative.");
        }
        floor_vacancy.put(key,value);//putting the new value in place of the given key
    }


    public static HashMap<Integer, Integer> computer_vacancy = new HashMap<Integer, Integer>();//stores and manages availability of computers on each floor.
    static{
        computer_vacancy.put(1, 30);
        computer_vacancy.put(2, 60);
        computer_vacancy.put(3, 75);
    }
    public HashMap<Integer, Integer> getComputer_vacancy() {
        return computer_vacancy;
    }
    protected void set_computer_vacancy(Integer key,int value){
        if (key == null || value < 0) {
            throw new IllegalArgumentException("Key cannot be null and value must be non-negative.");
        }
        computer_vacancy.put(key,value);//putting the value for the given key
    }

}

