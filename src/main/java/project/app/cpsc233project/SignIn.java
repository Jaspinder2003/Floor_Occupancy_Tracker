package project.app.cpsc233project;

import java.util.Objects;

public class SignIn extends Menu {
    private int floorNumber;

    

    @Override
    public void execute(String name, int studentID, boolean computerUsage, String floorN, String area) {

        System.out.println("Executing sign-in sequence...");
        if (Objects.equals(floorN, "GROUND_FLOOR")){
            floorNumber = 1;
        }
        else if(Objects.equals(floorN, "SECOND_FLOOR")){
            floorNumber = 2;
        }
        else{
            floorNumber = 3;
        }
        /**
         * used to check which floor the user has chosen
         */

        // Create a data object for the user
        data userData = new data(name, studentID, floorNumber, area);
        data.AddUser(userData);
        data.writer(data.dataObjects, "ProjectDB.csv", "Data");

        // Update floor availability
        floor userFloor = new floor(name, studentID, floorNumber, area);
        floor.AddUser(userFloor);
        data.writer(floor.floorObjects, "ProjectDB.csv", "Floor");

        int currentFloorAvailability = userFloor.getFloorAvailability(floorNumber, userData);
        userFloor.new_flr_ava(floorNumber, currentFloorAvailability - 1, userData); // Assuming each sign-in reduces availability by 1

        // Check for computer usage and update accordingly
        if (computerUsage) {
            Computers userComputer = new Computers(name, studentID, floorNumber,area);
            Computers.AddUser(userComputer);
            data.writer(Computers.ComputerObjects, "ProjectDB.csv", "Computers");

            int currentComputerAvailability = userComputer.getComputerAvailability(floorNumber, userData);
            if(currentComputerAvailability > 0){
            userComputer.new_computer_ava(floorNumber, currentComputerAvailability - 1, userData); 
            }

        }
    }
}