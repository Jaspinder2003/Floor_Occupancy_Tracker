import java.util.ArrayList;
import java.util.HashMap; //Imports the hashmap class.
import java.util.HashSet;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class data {
    private Integer id;
    private String name;
    private Integer floor;
 
    public static HashMap<Integer, Integer> floor_vacancy = new HashMap<Integer, Integer>();//stores and manages availability on each floor.
    
 
    static HashSet<data> dataObjects = new HashSet<data>(); // Set to store objects


    public data(String name,int id, int floor){
        this.name=name;
        this.id=id;
        this.floor=floor;

    }

    public static void AddUser(data data) {
        dataObjects.add(data);
    }

    public static <T> void writer(HashSet<T> set, String fileName, String ElementType) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // true for appending to the file
            for (T element : set) {
                if (element instanceof data) {
                    data d = (data) element;
                    String line = ElementType + "," + d.getID() + "," + d.getName();
                    writer.write(line + "\n");
                } else if (element instanceof floor) {
                    floor f = (floor) element;
                    String line = ElementType + "," + f.getID() + "," + f.getName() + "," + f.getFloor();
                    writer.write(line + "\n");
                } else if (element instanceof Computers) {
                    Computers c = (Computers) element;
                    String line = ElementType + "," + c.getID() + "," + c.getName() + "," + c.getFloor();
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}