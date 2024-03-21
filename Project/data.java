import java.util.ArrayList;
import java.util.HashMap; //Imports the hashmap class.

public class data {
    private int id;
    private String name;
    public static HashMap<String, Integer> floor_vacancy = new HashMap<String, Integer>();//stores and manages availability on each floor.

    public data(String name,int id){
        this.name=name;
        this.id=id;

    }
    static {
        floor_vacancy.put("1", 87);
        floor_vacancy.put("2", 134);
        floor_vacancy.put("3", 200);
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return id;
    }
    public HashMap<String, Integer> getFloor_vacancy() {
        return floor_vacancy;
    }
    public void set_floor_vacancy(String key,int value){
        floor_vacancy.put(key,value);
    }


    public static HashMap<String, Integer> computer_vacancy = new HashMap<String, Integer>();//stores and manages availability of computers on each floor.
    static{
        computer_vacancy.put("1", 30);
        computer_vacancy.put("2", 60);
        computer_vacancy.put("3", 75);
    }
    public HashMap<String, Integer> getComputer_vacancy() {
        return floor_vacancy;
    }
    public void set_computer_vacancy(String key,int value){
        computer_vacancy.put(key,value);
    }
    public static int floor_value_finder(String num){//stores and manages availability on each floor.
        int floor_num = floor_vacancy.get(num);
        return floor_num;
    }

    public static int computer_value_finder(String num){//stores and manages availability on each floor.
        int computer_num = computer_vacancy.get(num);
        return computer_num;
    }


    public static HashMap<Integer, Integer[]> floor_occupancy = new HashMap<Integer, Integer[]>(); //HashMap created for further usage.

    public static HashMap<Integer, Integer[]> floor_add(HashMap<Integer, Integer[]> floor_filled, int key, Integer[] value){ //method used to add information (key to be studentID, value as the floor-area chosen.)
        floor_filled.put(key, value);
        return floor_filled;
    }

    public static HashMap<Integer, Integer[]> computer_occupancy = new HashMap<Integer, Integer[]>(); //HashMap created for further usage.

    public static HashMap<Integer, Integer[]> computer_add(HashMap<Integer, Integer[]> computer_filled, int key, Integer[] value){ //method used to add information (key to be studentID, value as the floor and area chosen.)
        computer_filled.put(key, value);
        return computer_filled;
    }

    public static ArrayList<Integer> computer_area_users = new ArrayList<>();

    public static ArrayList<Integer> computer_area_add(Integer studentID){
        computer_area_users.add(studentID);
        return computer_area_users;
    }

    public static int computer_area_counter(){
        int count = computer_area_users.size();
        return count;
    }

}

