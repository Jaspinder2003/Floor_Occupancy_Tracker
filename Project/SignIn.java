public class SignIn extends Menu {
    private final Integer[] floorInfo; // Array containing floor and area selections

    public SignIn(Integer[] floorInfo) {
        this.floorInfo = floorInfo;
    }

    @Override
    public Integer[] execute() {
        System.out.println("Please enter your full name:");
        String name = scanner.nextLine();

        System.out.println("Please enter your UCID:");
        int studentID = getIntegerInput();

        // Create a data object for the user
        data userData = new data(name, studentID, floorInfo[0]);

        // Update floor availability
        floor userFloor = new floor(name, studentID, floorInfo[0]);
        int currentFloorAvailability = userFloor.getFloorAvailability(floorInfo[0], userData);
        userFloor.new_flr_ava(floorInfo[0], currentFloorAvailability - 1, userData); // Assuming each sign-in reduces availability by 1

        // Check for computer usage and update accordingly
        if (askForComputerUsage()) {
            Computers userComputer = new Computers(name, studentID, floorInfo[0]);
            int currentComputerAvailability = userComputer.getComputerAvailability(floorInfo[0], userData);
            if(currentComputerAvailability > 0){
            userComputer.new_computer_ava(floorInfo[0], currentComputerAvailability - 1, userData); 
            System.out.println("Computer usage has been confirmed.");}
            else{
                System.out.println("No Computer is currently available to use.");
            }
        }
     
        System.out.println("You have successfully signed in.");

        return null;
    }


    private boolean askForComputerUsage() {
        // Logic to determine if the selected area has computer stations
        boolean willUseComputer = false;
        System.out.println("Are you planning to use the computers at the Computer Stations?\n1. Yes\n2. No\n3. Exit");
        int choice = getIntegerInput();

        switch (choice) {
            case 1:
            willUseComputer = true;
            case 2:
            willUseComputer = false;
            case 3:
                break;
            default:
                System.out.println("Invalid input, please try again.");
                return askForComputerUsage();
        }
        return willUseComputer;
    }
}
