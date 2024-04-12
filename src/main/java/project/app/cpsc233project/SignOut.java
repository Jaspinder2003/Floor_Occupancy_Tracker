package project.app.cpsc233project;
public class SignOut extends Menu {

    @Override
    public void execute(String name, int studentID, boolean ComputerUsage) {
        System.out.println("Please enter your UCID to sign out:");
        int ucid = getIntegerInput();

        data userFloor = findUser(ucid);
        Computers c=findComp(ucid);
        if (userFloor != null) {
            data.dataObjects.remove(userFloor); // Remove the user's floor from the tracking set
            floor userFloor1 = new floor(userFloor.getName(), userFloor.getID(), userFloor.getfloor());
            int currentFloorAvailability = userFloor1.getFloorAvailability(userFloor.getfloor(), userFloor);
            userFloor1.new_flr_ava(userFloor.getfloor(), currentFloorAvailability + 1, userFloor);

            if(c!=null){
                Computers.ComputerObjects.remove(c);
                int currentComputerAvailability = c.getComputerAvailability(c.getFloor(), userFloor);
                c.new_computer_ava(c.getFloor(), currentComputerAvailability + 1, userFloor);
            }
            System.out.println("You have successfully signed out. Thank you!");
            
            // Further logic to update floor and computer availability can be added here

        } else {
            System.out.println("UCID not found in the db.");
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
}
