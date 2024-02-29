import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap; //Imports the hashmap class.

public class data {
    static HashMap<Integer, Integer> floor_occupancy = new HashMap<Integer,Integer>(); //HashMap created for further usage.
    
    public static HashMap<Integer, Integer> floor_add(HashMap<Integer, Integer> floor_filled, int key, int value){ //method used to add information (key to be studentID, value as the floor-area chosen.)
        floor_filled.put(key, value);
        return floor_filled;
    }
}
