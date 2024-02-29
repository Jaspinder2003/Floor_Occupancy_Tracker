import java.util.InputMismatchException;
import java.util.Scanner; // Import the Scanner class

class Menu {

   public static int[] initalMenu() {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        int[] returnArray = new int[2]; 

        // Flag to check if the correct option has been chosen
        boolean correctOptionChosen = false;

        // Welcome message
        System.out.println("Welcome to TFDL Library!");
        System.out.println("Please Select the Floor and Area you want to use");
        int floorAreaSection = 0;
        int floorSelection = 0;
        // Loop until the user chooses a valid option
        while (!correctOptionChosen) {
            try {
                // Display floor options
                System.out.println("1. Ground Floor\n2. Second Floor\n3. Third Floor\n4. To Exit the form");
                floorSelection = scanner.nextInt(); // Read user input for floor selection

                // Switch-case to handle floor selection
                switch (floorSelection) {
                    case 1:
                        // Prompt for specific area on the 1st floor
                        System.out.println("Please Select the Specific area you will be using on the 1st floor");
                        System.out.println(
                                "1. Study Cubicles\n2. Open Study Area\n3. Group Study Rooms\n4. Print/Copy Center\n5. Bookshelves Area\n6. Computer Stations");
                        floorAreaSection = scanner.nextInt(); // Read user input for section selection
                        correctOptionChosen = true; // Set flag to true to exit loop
                        break;
                    case 2:
                        // Prompt for specific area on the 2nd floor
                        System.out.println("Please Select the Specific area you will be using on the 2nd floor");
                        System.out.println(
                                "1. TFDL 2nd FLR East Group Study\n2. Computer Stations\n3. TFDL 2nd FLR Group and Quiet Study");
                        floorAreaSection = scanner.nextInt(); // Read user input for section selection
                        correctOptionChosen = true; // Set flag to true to exit loop
                        break;
                    case 3:
                        // Prompt for specific area on the 3rd floor
                        System.out.println("Please Select the Specific area you will be using on the 3rd floor");
                        System.out.println(
                                "1. Computer Stations\n2. Open Study Area\n3. TFDL 3rd FLR NE Corner\n4. Study Rooms\n5. Scholars Lounge");
                        floorAreaSection = scanner.nextInt(); // Read user input for section selection
                        correctOptionChosen = true; // Set flag to true to exit loop
                        break;
                    case 4:
                        // Exit the application
                        correctOptionChosen = true; // Set flag to true to exit loop
                        break;

                    default:
                        // Handle invalid floor selection
                        System.out.println(
                                "Invalid Choice. Please Choose the correct Floor or Press 4 to exit the form.");
                        break;
                }
            } catch (InputMismatchException e) {
                // Handle exception when input is not an integer
                System.out.println("Invalid input. Please choose from the following options.");
                scanner.nextLine(); // Clear the buffer by reading the line
            }
        }

        returnArray[0] = floorSelection;
        returnArray[1] = floorAreaSection;

        return returnArray;


    }

    public static void SignIn(Integer[] FloorInfo){
            Scanner scanner = new Scanner(System.in);
            try{
                String Name = fill_in("your name: ");

                String UCID = fill_in("your UCID: ");
                int StudentID = Integer.valueOf(UCID);

                data.floor_add(data.floor_occupancy, StudentID, FloorInfo);//uses the add function from data.java to add new kay and value to the hashmap.

                int ComputerAsk = 0;
                boolean ComputerUsage = false; // will use this variable in assessing the data of available seats and computers
                boolean stop = true; // to stop the while loop

                if (FloorInfo[0]==1&&FloorInfo[1]==6||FloorInfo[0]==2&&FloorInfo[1]==2||FloorInfo[0]==3&&FloorInfo[1]==1){
                    System.out.println(
                            "Are you planning to use the computers at the Computer Staions\n 1.Yes\n 2. No \n 3. Exit");
                    ComputerAsk = scanner.nextInt(); // asking for computer usage and taking the input

                    while (stop) {
                        switch (ComputerAsk) {
                            case 1:
                                ComputerUsage = true;// true if the user wants to use the computer
                                stop = false;
                                break;

                            case 2:
                                ComputerUsage = false;// stays false if the user does not intend to use the computers
                                stop = false;
                                break;

                            case 3:
                                stop = false;
                                break;// if the user wants to exit the file

                            default: // used to catch any other input other than 1,2,3
                                System.out.println("Invalid input, Please try again.");
                                SignIn(FloorInfo);
                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, Please try again.");
                SignIn(FloorInfo);
            } // used for error catching

        }

    public static void SignOut(int[] FloorInfo){
        Scanner input = new Scanner(System.in);

        try{
            // Asks user to enter full name.
            System.out.println("Please enter your full name: ");
            String Name = input.nextLine();

            // Asks user to enter UCID.
            System.out.println("Please enter your UCID: ");
            int UCID = input.nextInt();

            // Asks for space release confirmation.
            System.out.println("Do you confirm to release the reserved space?\n1. Yes\n2. No");
            int release = input.nextInt();
            
            if(release == 1){
                // Asks for a optional feedback.
                System.out.println("Send us a feedback. (Optional)");
                String feedback = input.nextLine();

                // Asks for final sign out confirmation.
                System.out.println("Confirm to sign out?\n1. Yes\n2. No");
                int confirmation = input.nextInt();

                // Updates the user for successful signout.
                if(confirmation == 1){
                    System.out.println("You are successfully signed out.");
                }
                else if(confirmation == 2){
                    System.out.println("Sign out process cancelled.");
                }
                else{
                    System.out.println("Please choose only from 1 and 2.");
                }
            }
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. Please try again.");
            SignOut(FloorInfo);
        }
    }

}
