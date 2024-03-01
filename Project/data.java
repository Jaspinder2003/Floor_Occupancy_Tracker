import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap; //Imports the hashmap class.

public class data {
    //Jaspinder Singh
    public static HashMap<String, Integer> floor_vacancy = new HashMap<String, Integer>();//stores and manages availability on each floor.
    static{
            floor_vacancy.put("1", 87);
            floor_vacancy.put("2", 134);
            floor_vacancy.put("3", 200);
    }

    //Navpreet Singh
    static HashMap<Integer, String> floor_occupancy = new HashMap<Integer, String>(); //HashMap created for further usage.
    
    public static HashMap<Integer, String> floor_add(HashMap<Integer, String> floor_filled, int key, String value){ //method used to add information (key to be studentID, value as the floor-area chosen.)
        floor_filled.put(key, value);
        return floor_filled;
    }
}
