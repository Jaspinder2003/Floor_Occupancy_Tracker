import java.util.InputMismatchException;
import java.util.Scanner; // Import the Scanner class

class Menu {
    //Navpreet Singh
    public static Integer[] initalMenu() {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        Integer[] returnArray = new Integer[2]; 

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
                System.out.println("1. Ground Floor\n2. Second Floor\n3. Third Floor\n4. To Exit the form");// Display floor options
                floorSelection = scanner.nextInt(); // Read user input for floor selection

                switch (floorSelection) {// Switch-case to handle floor selection
                    case 1:
                        System.out.println("Please Select the Specific area you will be using on the 1st floor");// Prompt for specific area on the 1st floor
                        System.out.println(
                                "1. Study Cubicles\n2. Open Study Area\n3. Group Study Rooms\n4. Print/Copy Center\n5. Bookshelves Area\n6. Computer Stations");
                        floorAreaSection = scanner.nextInt(); // Read user input for section selection
                        correctOptionChosen = true; // Set flag to true to exit loop
                        break;
                    case 2:
                        System.out.println("Please Select the Specific area you will be using on the 2nd floor");// Prompt for specific area on the 2nd floor
                        System.out.println(
                                "1. TFDL 2nd FLR East Group Study\n2. Computer Stations\n3. TFDL 2nd FLR Group and Quiet Study");
                        floorAreaSection = scanner.nextInt(); // Read user input for section selection
                        correctOptionChosen = true; // Set flag to true to exit loop
                        break;
                    case 3:
                        System.out.println("Please Select the Specific area you will be using on the 3rd floor");// Prompt for specific area on the 3rd floor
                        System.out.println(
                                "1. Computer Stations\n2. Open Study Area\n3. TFDL 3rd FLR NE Corner\n4. Study Rooms\n5. Scholars Lounge");
                        floorAreaSection = scanner.nextInt(); // Read user input for section selection
                        correctOptionChosen = true; // Set flag to true to exit loop
                        break;
                    case 4:                        // Exit the application
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

    //Jaspinder Singh Maan
    public static void SignIn(Integer[] FloorInfo){
            Scanner scanner = new Scanner(System.in);
            try{//First it will try this part of code.
                System.out.println("Please enter your full name: ");//Asks user to input name.
                String Name = scanner.nextLine();

                System.out.println("Please enter your UCID: ");//Asks user to input Student ID.
                int StudentID = scanner.nextInt();

                data.floor_add(data.floor_occupancy, StudentID, FloorInfo);//uses the add function from data.java to add new kay and value to the hashmap.
                String floor_num = Integer.toString(FloorInfo[0]);
                int floor_ava = data.floor_value_finder(floor_num) - 1;
                data.floor_vacancy.put(floor_num, floor_ava);

                int ComputerAsk = 0;
                boolean ComputerUsage = false; // will use this variable in assessing the data of available seats and computers

                if (FloorInfo[0]==1&&FloorInfo[1]==6||FloorInfo[0]==2&&FloorInfo[1]==2||FloorInfo[0]==3&&FloorInfo[1]==1){
                    System.out.println("Are you planning to use the computers at the Computer Staions\n 1.Yes\n 2. No \n 3. Exit");
                    ComputerAsk = scanner.nextInt(); // asking for computer usage and taking the input

                    switch (ComputerAsk) {
                        case 1:
                            ComputerUsage = true;// true if the user wants to use the computer
                            String computer_num = Integer.toString(FloorInfo[0]);
                            int computer_ava = data.computer_value_finder(computer_num) - 1;
                            data.computer_vacancy.put(computer_num, computer_ava);
                            System.err.println(data.computer_vacancy);
                            break;

                        case 2:
                            ComputerUsage = false;// stays false if the user does not intend to use the computers
                            break;

                        case 3:
                            break;// if the user wants to exit the file

                        default: // used to catch any other input other than 1,2,3
                            System.out.println("Invalid input, Please try again.");
                            SignIn(FloorInfo);
                    }
                }
            }
            catch (Exception e) {//Any kind of error results in running of this code.
                System.out.println("Invalid input, Please try again.");
                SignIn(FloorInfo);//Causes the SignIn() method to run again from start.
            }

            main(null);//Returns form to main menu, that asks for Check In/Check Out.
        }

    //Yadwinder Singh Dhaliwal
    public static String fill_in(String statement){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your " + statement + ": ");
        String input_data = input.nextLine();
        return input_data;
    }

    public static String confirm_it(String statement){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you confirm " + statement + "?\n1. Yes\n2. No ");
        String input_data = input.nextLine();
        return input_data;
    }

    public static void SignOut(){
        String Name = fill_in("your name");//Asks user to fill in name.

        try{
            int StudentID = Integer.valueOf(fill_in("your StudentID"));//Asks user to fill in student ID.

            boolean valid_release = true;
            if(data.floor_occupancy.containsKey(StudentID)){
                do{
                    String release = confirm_it("release of reserved space");
                    if(release.equals("1")){
                        Scanner input = new Scanner(System.in);
                        System.out.println("Send us a feedback. (Optional)");// Asks for a optional feedback.
                        String feedback = input.nextLine();
                        valid_release = true;

                        data.floor_occupancy.remove(StudentID);//removes the stored servation if confirmed to released.
                        System.out.println("You are successfully signed out.");
                    }
                    else if(release.equals("2")){
                        System.out.println("Release of reserved space cancelled. Signing out!");//if user decided to not release the space, form automatically signs out.
                        valid_release = true;
                    }
                    else{
                        System.out.println("Please choose only from 1 and 2.");//warns user about the mistake and asks to re-input.
                        valid_release = false;
                    }
                }while(!valid_release);
            }
            else{
                System.out.println("Sorry you don't have any reservation to release. Signing out!");//message to be displayed if reservation doesn't exist.
            }
        }
        catch(Exception e){//If any wrong data type input occurs, following code runs.
            System.out.println("Invalid input. Please try again.");
            SignOut();//Restarts the whole method if any error occurs.
        }

        main(null);//Starts the main menu again.
    }

}
