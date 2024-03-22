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
    private int floor;
 
    public static HashMap<Integer, Integer> floor_vacancy = new HashMap<Integer, Integer>();//stores and manages availability on each floor.
    
 
    private static HashSet<data> dataObjects = new HashSet<data>(); // Set to store objects


    public data(String name,int id){
        this.name=name;
        this.id=id;

    }

    public static void AddUser(data data) {
        dataObjects.add(data);
    }

    public static void writer(HashSet<Object> set, String fileName, String ElementType) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write headers
            writer.write("ID,Name,Floor\n");
            for (Object elements : set) {
                if (elements instanceof data) { // data and its subclasses have ID and Name
                    data d = (data) elements;
                    String line = ElementType + "," + d.getID() + "," + d.getName();
                    writer.write(line + "\n");}
                    // Check for floor attribute
                else if (elements instanceof floor) { // If it's an instance of floor, it has floor information
                    floor f = (floor) elements;
                    String line = ElementType + "," + f.getID() + "," + f.getName()+ "," + f.getFloor();
                    writer.write(line + "\n"); } 
                else if (elements instanceof Computers) { // Similarly for Computers
                    Computers C = (Computers) elements;
                   String  line = ElementType + "," + C.getID() + "," + C.getName()+ "," + C.getFloor();
                   writer.write(line + "\n"); } 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reader(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String elementType = values[0];
                int id = Integer.parseInt(values[1]);
                String name = values[2];
                int floor = Integer.parseInt(values[3]);

                switch (elementType) {
                    case "Data":
                     //   dataObjects.add(new data(name, id));
                        break;
                    case "Floor":
                     // floorObjects.add(new floor(name, id, floor));
                        break;
                    case "Computers":
                      // ComputerObjects.add(new Computers(name, id, floor));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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