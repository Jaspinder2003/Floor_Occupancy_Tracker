package project.app.cpsc233project;
import java.util.ArrayList;
import java.util.Arrays;
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

    private String area;
 
    public static HashMap<Integer, Integer> floor_vacancy = new HashMap<Integer, Integer>();//stores and manages availability on each floor.

    static {
        floor_vacancy.put(1, 87);
        floor_vacancy.put(2, 134);
        floor_vacancy.put(3, 200);
    }//static because it needs to be used multiple times

    public static HashMap<Integer, Integer> computer_vacancy = new HashMap<Integer, Integer>();//stores and manages availability of computers on each floor.
    
    static{
        computer_vacancy.put(1, 30);
        computer_vacancy.put(2, 60);
        computer_vacancy.put(3, 75);
    }//static because it needs to be used multiple times
 
    static HashSet<data> dataObjects = new HashSet<data>(); // Set to store objects


    public data(String name,int id, int floor, String area){
        this.name=name;
        this.id=id;
        this.ufloor=floor;
        this.area=area;

    }//constructor



    public static void AddUser(data data) {
        dataObjects.add(data);
    }//used to add user to a hashset

    public String toCsvString() {
        return "Data," + id + "," + name + ","+ ufloor+","+area;
    }//used to convert the object to a csv string

    public static <T extends data> void writer(HashSet<T> set, String fileName, String ElementType) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (T element : set) {
                String line = element.toCsvString();
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/**
 * this is the main writer function used to save
 */

    public static String reader(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
                String[] values = line.split(",");
                String elementType = values[0];
                int id = Integer.parseInt(values[1]);
                String name = values[2];
                int ufloor = Integer.parseInt(values[3]);
                String area = values[4];

                switch (elementType) {//used to check if the object is a floor,computer or data
                    case "Data":
                        data userData = new data(name, id, ufloor, area);
                        data.AddUser(userData);
                        break;
                    case "Floor":
                        floor userFloor = new floor(name, id, ufloor, area);
                        floor.AddUser(userFloor);
                        if (ufloor == 1) {
                            floor_vacancy.put(1, floor_vacancy.get(1) - 1);
                        } else if (ufloor == 2) {
                            floor_vacancy.put(2, floor_vacancy.get(2) - 1);
                        } else if (ufloor == 3) {
                            floor_vacancy.put(3, floor_vacancy.get(3) - 1);
                        }
                        break;
                    case "Computers":
                        Computers userComputer = new Computers(name, id, ufloor, area);
                        Computers.AddUser(userComputer);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
/**
 * used to load objects and is the mani reader file
 */

    public static boolean ucidExists(String fileName, int searchUcid) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 1) { // Ensure there are enough columns
                    int id = Integer.parseInt(values[1]);
                    if (id == searchUcid) {
                        return true; // UCID found
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // UCID not found
    }
    /**
     * used to check if the ucid exists
     * and is mainly used in sign out controller while the user is trying to sign out
     */

    public String getName(){
        return name;
    }//used to get name

    public String getarea(){
        return area;
    }//used to get area




    public int getfloor(){
        return ufloor;
    }//used to get floor

    public Integer getID(){
        return id;
    }//used to get id

    public HashMap<Integer, Integer> getFloor_vacancy() {
        return floor_vacancy;
    }//used to get floor vacancy

    protected void set_floor_vacancy(Integer key,int value){
        if (key == null || value < 0) {
            throw new IllegalArgumentException("Key cannot be null and value must be non-negative.");
        }
        floor_vacancy.put(key,value);//putting the new value in place of the given key
    }//used to set the floor vacancy and is used in floor class

    public HashMap<Integer, Integer> getComputer_vacancy() {
        return computer_vacancy;
    }//used to get computer vacancy

    protected void set_computer_vacancy(Integer key,int value){
        if (key == null || value < 0) {
            throw new IllegalArgumentException("Key cannot be null and value must be non-negative.");
        }
        computer_vacancy.put(key,value);//putting the value for the given key
    }//used to set computer vacancy and is used in computers class

}

