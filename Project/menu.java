import java.util.InputMismatchException;
import java.util.Scanner; // Import the Scanner class

class Menu {

    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

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
        }}

public static void SignIn(int[][] FloorInfo){
        System.out.println("Please enter your Full Name: ");
        String Name = scanner.nextLine();
        // asks the user for the credentials like name

        System.out.println("Please enter your User ID");
        int StudentID = scanner.nextInt();
        // asks the user to enter the User ID

        System.out.println("Please enter your expected duration of stay");
        String Stay = scanner.nextLine();
        // asks the user the expected time of stay

        int ComputerAsk = 0;
        boolean ComputerUsage = false; // will use this variable in assessing the data of available seats and computers
        boolean stop = true; // to stop the while loop

        if (FloorInfo[0]==1&&FloorInfo[1]==6||FloorInfo[0]==2&&FloorInfo[1]==2||FloorInfo[0]==3&&FloorInfo[1]==1) {
            try {
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
                            System.out.println(
                                    "Invalid Input. Please Choose from the following options.\n 1. Yes\n 2. No");
                            ComputerAsk = scanner.nextInt();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please Choose from the following options.\n 1. Yes\n 2. No");
                ComputerAsk = scanner.nextInt();
            } // used for error catching

        }

}

}
