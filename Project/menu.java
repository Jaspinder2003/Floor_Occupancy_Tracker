import java.util.Scanner;  // Import the Scanner class

class menu {

  public static void main(String[] args) {
    System.out.println("Welcome to TFDL Library!"); 
    System.out.println("Please Select the Floor and Area do you want to use"); 
    Scanner scanner = new Scanner(System.in);
    System.out.println("1. Ground Floor\n2. Second Floor\n3. Third Floor\n4. Fourth Floor"); 
    int floorSelection = scanner.nextInt();
    System.out.println("Please Select the Specfic area you will be using on " + floorSelection + " floor");
    switch (floorSelection) {
      case 1:
        System.out.println("1. Study Cubicles\n2. Open Study Area\n3. Group Study Rooms\n4. Print/Copy Center\n5. Bookshelves Area");
        int floorSection = scanner.nextInt();
        break;
      case 2:
        System.out.println("1. TFDL 2nd FLR East Group Study\n2. Computer Stations\n3. TFDL 2nd FLR Group and Quiet Study");
        int floor1Section = scanner.nextInt();
        break;
      case 3:
        System.out.println("1. Computer Stations\n2. Open Study Area\n3. TFDL 3rd FLR NE Corner\n4. Study Rooms\n5. Scholars Lounge");
        int floor2Section = scanner.nextInt();
        break;
      default:
        System.out.println("Invaid Choice. Please Choose correct Floor.");
        break;
      
    }



  }
}