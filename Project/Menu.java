import java.util.Scanner;

public abstract class Menu {
    protected Scanner scanner;
    
    public enum Area {
        STUDY_CUBICLES, OPEN_STUDY_AREA, GROUP_STUDY_ROOMS, PRINT_COPY_CENTER, BOOKSHELVES_AREA, COMPUTER_STATIONS, 
        TFDL_2ND_FLR_EAST_GROUP_STUDY, TFDL_2ND_FLR_GROUP_AND_QUIET_STUDY, 
        TFDL_3RD_FLR_NE_CORNER, STUDY_ROOMS, SCHOLARS_LOUNGE,NONE
    }
     
    public enum Floor {
        GROUND_FLOOR, SECOND_FLOOR, THIRD_FLOOR, EXIT
    }



    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    protected int getIntegerInput() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // consume the non-integer input
            System.out.println("Invalid input. Please enter a number.");
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        return input;
    }

    // Abstract method to be implemented by subclasses
    // This replaces the need for a separate MenuAction interface
    public abstract Integer[] execute();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("Welcome to TFDL Library!\nHere is list of free spaces in the building;\nTotal free spaces on each floor:\n" + stats.show_vacancy("all floors") + "\nFree computer spaces on each floor;\n" + stats.show_vacancy("all comps"));
            System.out.println("Do your want to:\n1.Check In\n2. Check Out\n3. Exit");
            int selected = input.nextInt();
            
            switch (selected) {
                case 1: // Check In
                    InitialMenu initialMenu = new InitialMenu();
                    Integer[] floorInfo = initialMenu.execute();
                    SignIn signIn = new SignIn(floorInfo);
                    signIn.execute();
                    break;
                case 2: // Check Out
                  //  SignOut signOut = new SignOut();
                   // signOut.execute();

                    break;
                case 3: // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        
        input.close();
        System.out.println("Thank you for using the system.");
    }

}