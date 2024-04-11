package project.app.cpsc233project;
public class InitialMenu extends Menu {


public Integer[] execute() {
    Integer[] FloorAndArea_GROUND_FLOORSelection = new Integer[2];
    System.out.println("Welcome to TFDL Library!");
    System.out.println("Please Select the Floor and Area_GROUND_FLOOR you want to use");
    System.out.println("Note: Least busiest- Floor " + stats.max_min("floors")[1] + " recommended.");

    Floor floorSelection = getFloorSelection();
    Area_GROUND_FLOOR Area_GROUND_FLOORSelection = getArea_GROUND_FLOORSelection(floorSelection);
 
    FloorAndArea_GROUND_FLOORSelection[0] = floorSelection.ordinal() +1;
    FloorAndArea_GROUND_FLOORSelection[1] = Area_GROUND_FLOORSelection.ordinal()+1;

    return FloorAndArea_GROUND_FLOORSelection;
}

  private Floor getFloorSelection() {
        System.out.println("1. Ground Floor\n2. Second Floor\n3. Third Floor\n4. Exit");
        int choice = getIntegerInput();
        switch (choice) {
            case 1:
                return Floor.GROUND_FLOOR;
            case 2:
                return Floor.SECOND_FLOOR;
            case 3:
                return Floor.THIRD_FLOOR;
            case 4:
                return Floor.EXIT;
            default:
                System.out.println("Invalid selection, please try again.");
                return getFloorSelection();
        }
  }

  private Area_GROUND_FLOOR getArea_GROUND_FLOORSelection(Floor floor) {
      switch (floor) {
            case GROUND_FLOOR:
                System.out.println("Please Select the Specific Area_GROUND_FLOOR you will be using on the 1st floor");
                System.out.println("1. Study Cubicles\n2. Open Study Area_GROUND_FLOOR\n3. Group Study Rooms\n4. Print/Copy Center\n5. Bookshelves Area_GROUND_FLOOR\n6. Computer Stations");
                return chooseArea_GROUND_FLOORGroundFloor();
            case SECOND_FLOOR:
                System.out.println("Please Select the Specific Area_GROUND_FLOOR you will be using on the 2nd floor");
                System.out.println("1. TFDL 2nd FLR East Group Study\n2. Computer Stations\n3. TFDL 2nd FLR Group and Quiet Study");
                return chooseArea_GROUND_FLOORSecondFloor();
            case THIRD_FLOOR:
                System.out.println("Please Select the Specific Area_GROUND_FLOOR you will be using on the 3rd floor");
                System.out.println("1. Computer Stations\n2. Open Study Area_GROUND_FLOOR\n3. TFDL 3rd FLR NE Corner\n4. Study Rooms\n5. Scholars Lounge");
                return chooseArea_GROUND_FLOORThirdFloor();
            case EXIT:
               // return Area_GROUND_FLOOR.NONE;
            default:
                System.out.println("Invalid selection, please try again.");
                return getArea_GROUND_FLOORSelection(floor);
        }

  }

  private Area_GROUND_FLOOR chooseArea_GROUND_FLOORGroundFloor() {
        int selection = getIntegerInput();
        switch (selection) {
            case 1:
                return Area_GROUND_FLOOR.STUDY_CUBICLES;
            case 2:
               // return Area_GROUND_FLOOR.OPEN_STUDY_Area_GROUND_FLOOR;
            case 3:
                return Area_GROUND_FLOOR.GROUP_STUDY_ROOMS;
            case 4:
                return Area_GROUND_FLOOR.PRINT_COPY_CENTER;
            case 5:
               // return Area_GROUND_FLOOR.BOOKSHELVES_Area_GROUND_FLOOR;
            case 6:
                return Area_GROUND_FLOOR.COMPUTER_STATIONS;
            default:
                System.out.println("Invalid selection, please try again.");
                return chooseArea_GROUND_FLOORGroundFloor();
        }

  }

  private Area_GROUND_FLOOR chooseArea_GROUND_FLOORSecondFloor() {
        int selection = getIntegerInput();
        switch (selection) {
            case 1:
              //  return Area_GROUND_FLOOR.TFDL_2ND_FLR_EAST_GROUP_STUDY;
            case 2:
                return Area_GROUND_FLOOR.COMPUTER_STATIONS;
            case 3:
                //return Area_GROUND_FLOOR.TFDL_2ND_FLR_GROUP_AND_QUIET_STUDY;
            default:
                System.out.println("Invalid selection, please try again.");
                return chooseArea_GROUND_FLOORSecondFloor();
        }
  }

  private Area_GROUND_FLOOR chooseArea_GROUND_FLOORThirdFloor() {
            int selection = getIntegerInput();
        switch (selection) {
            case 1:
                return Area_GROUND_FLOOR.COMPUTER_STATIONS;
            case 2:
               // return Area_GROUND_FLOOR.OPEN_STUDY_Area_GROUND_FLOOR;
            case 3:
               // return Area_GROUND_FLOOR.TFDL_3RD_FLR_NE_CORNER;
            case 4:
              //  return Area_GROUND_FLOOR.STUDY_ROOMS;
            case 5:
              //  return Area_GROUND_FLOOR.SCHOLARS_LOUNGE;
            default:
                System.out.println("Invalid selection, please try again.");
                return chooseArea_GROUND_FLOORThirdFloor();
        }
  }

}


