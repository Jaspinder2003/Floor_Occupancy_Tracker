public class InitialMenu extends Menu {

 @Override
 public Integer[] execute() {
        Integer[] FloorAndAreaSelection = new Integer[2];
        System.out.println("Welcome to TFDL Library!");
        System.out.println("Please Select the Floor and Area you want to use");
        System.out.println("Note: Least busiest- Floor " + stats.max_min("floors")[1] + " recommended.");


        Floor floorSelection = getFloorSelection();
        Area areaSelection = getAreaSelection(floorSelection);
        FloorAndAreaSelection[0] = floorSelection;
        FloorAndAreaSelection[1] = areaSelection;

        return FloorAndAreaSelection;
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

  private Area getAreaSelection(Floor floor) {
      switch (floor) {
            case GROUND_FLOOR:
                System.out.println("Please Select the Specific area you will be using on the 1st floor");
                System.out.println("1. Study Cubicles\n2. Open Study Area\n3. Group Study Rooms\n4. Print/Copy Center\n5. Bookshelves Area\n6. Computer Stations");
                return chooseAreaGroundFloor();
            case SECOND_FLOOR:
                System.out.println("Please Select the Specific area you will be using on the 2nd floor");
                System.out.println("1. TFDL 2nd FLR East Group Study\n2. Computer Stations\n3. TFDL 2nd FLR Group and Quiet Study");
                return chooseAreaSecondFloor();
            case THIRD_FLOOR:
                System.out.println("Please Select the Specific area you will be using on the 3rd floor");
                System.out.println("1. Computer Stations\n2. Open Study Area\n3. TFDL 3rd FLR NE Corner\n4. Study Rooms\n5. Scholars Lounge");
                return chooseAreaThirdFloor();
            case EXIT:
                return Area.NONE;
            default:
                System.out.println("Invalid selection, please try again.");
                return getAreaSelection(floor);
        }

  }

  private Area chooseAreaGroundFloor() {
        int selection = getIntegerInput();
        switch (selection) {
            case 1:
                return Area.STUDY_CUBICLES;
            case 2:
                return Area.OPEN_STUDY_AREA;
            case 3:
                return Area.GROUP_STUDY_ROOMS;
            case 4:
                return Area.PRINT_COPY_CENTER;
            case 5:
                return Area.BOOKSHELVES_AREA;
            case 6:
                return Area.COMPUTER_STATIONS;
            default:
                System.out.println("Invalid selection, please try again.");
                return chooseAreaGroundFloor();
        }

  }

  private Area chooseAreaSecondFloor() {
        int selection = getIntegerInput();
        switch (selection) {
            case 1:
                return Area.TFDL_2ND_FLR_EAST_GROUP_STUDY;
            case 2:
                return Area.COMPUTER_STATIONS;
            case 3:
                return Area.TFDL_2ND_FLR_GROUP_AND_QUIET_STUDY;
            default:
                System.out.println("Invalid selection, please try again.");
                return chooseAreaSecondFloor();
        }
  }

  private Area chooseAreaThirdFloor() {
            int selection = getIntegerInput();
        switch (selection) {
            case 1:
                return Area.COMPUTER_STATIONS;
            case 2:
                return Area.OPEN_STUDY_AREA;
            case 3:
                return Area.TFDL_3RD_FLR_NE_CORNER;
            case 4:
                return Area.STUDY_ROOMS;
            case 5:
                return Area.SCHOLARS_LOUNGE;
            default:
                System.out.println("Invalid selection, please try again.");
                return chooseAreaThirdFloor();
        }
  }

}


