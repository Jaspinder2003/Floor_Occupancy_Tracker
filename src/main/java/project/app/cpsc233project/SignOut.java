package project.app.cpsc233project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SignOut extends Menu {

    public void execute(String name, int studentID, boolean computerUsage, String floorN, String area){}

    public void executeS(int ucid) {



        data userFloor = findUser(ucid);

        Computers c=findComp(ucid);

        if (userFloor != null) {
            data.dataObjects.remove(userFloor); // Remove the user's floor from the tracking set
            floor.floorObjects.remove(userFloor);
            floor userFloor1 = new floor(userFloor.getName(), userFloor.getID(), userFloor.getfloor(), userFloor.getarea());
            int currentFloorAvailability = userFloor1.getFloorAvailability(userFloor.getfloor(), userFloor);
            userFloor1.new_flr_ava(userFloor.getfloor(), currentFloorAvailability + 1, userFloor);




            if(c!=null){
                Computers.ComputerObjects.remove(c);
                int currentComputerAvailability = c.getComputerAvailability(c.getFloor(), userFloor);
                c.new_computer_ava(c.getFloor(), currentComputerAvailability + 1, userFloor);


            }

            clearFile("C:/Users/Randh/Desktop/cpsc-233-group-proeject-w24-master/ProjectDB.csv");

            // Further logic to update floor and computer availability can be added here

        }
    }

    private data findUser(int ucid) {
        // Iterate over the reportList to find the user's floor object by UCID
        for (data f : data.dataObjects) {
            if (f.getID() == ucid) {
                return f; // Return the found floor object
            }
        }
        return null; // Return null if the user's floor object is not found
    }

    private Computers findComp(int ucid) {
        // Iterate over the reportList to find the user's floor object by UCID
        for (Computers f : Computers.ComputerObjects) {
            if (f.getID() == ucid) {
                return f; // Return the found floor object
            }
        }
        return null; // Return null if the user's floor object is not found
    }

    public static void clearFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            // File is automatically cleared by opening it in overwrite mode
        } catch (IOException e) {
            System.err.println("Failed to clear the file: " + fileName);
            e.printStackTrace();
        }
    }


}
