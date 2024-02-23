import java.util.InputMismatchException;
import java.util.Scanner;  // Import the Scanner class

class Menu {

  public static void main(String[] args) {
    // Create a Scanner object to read input
    Scanner scanner = new Scanner(System.in);
    
    // Flag to check if the correct option has been chosen
    boolean correctOptionChosen = false;

    // Welcome message
    System.out.println("Welcome to TFDL Library!"); 
    System.out.println("Please Select the Floor and Area you want to use"); 

    // Loop until the user chooses a valid option
    while(!correctOptionChosen){
      try {
        // Display floor options
        System.out.println("1. Ground Floor\n2. Second Floor\n3. Third Floor\n4. To Exit the form"); 
        int floorSelection = scanner.nextInt(); // Read user input for floor selection
        
        // Switch-case to handle floor selection
        switch (floorSelection) {
          case 1:
            // Prompt for specific area on the 1st floor
            System.out.println("Please Select the Specific area you will be using on the 1st floor");
            System.out.println("1. Study Cubicles\n2. Open Study Area\n3. Group Study Rooms\n4. Print/Copy Center\n5. Bookshelves Area");
            int floor1Section = scanner.nextInt(); // Read user input for section selection
            correctOptionChosen = true; // Set flag to true to exit loop
            break;
          case 2:
            // Prompt for specific area on the 2nd floor
            System.out.println("Please Select the Specific area you will be using on the 2nd floor");
            System.out.println("1. TFDL 2nd FLR East Group Study\n2. Computer Stations\n3. TFDL 2nd FLR Group and Quiet Study");
            int floor2Section = scanner.nextInt(); // Read user input for section selection
            correctOptionChosen = true; // Set flag to true to exit loop
            break;
          case 3:
            // Prompt for specific area on the 3rd floor
            System.out.println("Please Select the Specific area you will be using on the 3rd floor");
            System.out.println("1. Computer Stations\n2. Open Study Area\n3. TFDL 3rd FLR NE Corner\n4. Study Rooms\n5. Scholars Lounge");
            int floor3Section = scanner.nextInt(); // Read user input for section selection
            correctOptionChosen = true; // Set flag to true to exit loop
            break;
          case 4:
            // Exit the application
            correctOptionChosen = true; // Set flag to true to exit loop
            break;

          default:
            // Handle invalid floor selection
            System.out.println("Invalid Choice. Please Choose the correct Floor or Press 4 to exit the form.");
            break;
        }
      } catch (InputMismatchException e) {
        // Handle exception when input is not an integer
        System.out.println("Invalid input. Please choose for the following options.");
        scanner.nextLine(); // Clear the buffer by reading the line
      }
    }

    // Close the scanner to prevent resource leaks
    scanner.close();
  }
}
