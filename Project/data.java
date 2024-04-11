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
    private Integer ufloor;
 
    public static HashMap<Integer, Integer> floor_vacancy = new HashMap<Integer, Integer>();//stores and manages availability on each floor.
    
 
    static HashSet<data> dataObjects = new HashSet<data>(); // Set to store objects


    public data(String name,int id, int floor){
        this.name=name;
        this.id=id;
        this.ufloor=floor;

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
    

    public static void reader(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String elementType = values[0];
                int id = Integer.parseInt(values[1]);
                String name = values[2];
                int ufloor = Integer.parseInt(values[3]);

                switch (elementType) {
                    case "Data":
                        data userData = new data(name, id, ufloor);
                        data.AddUser(userData);
                        break;
                    case "Floor":
                        floor userFloor = new floor(name, id, ufloor);
                        floor.AddUser(userFloor);
                        break;
                    case "Computers":
                        Computers userComputer = new Computers(name, id, ufloor);
                        Computers.AddUser(userComputer);
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

    public int getfloor(){
        return ufloor;
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

