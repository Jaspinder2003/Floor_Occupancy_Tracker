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
    public abstract Integer[] execute();

}
