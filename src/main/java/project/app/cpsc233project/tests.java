package project.app.cpsc233project;

/**
 * 
 * @author Yadwinder Singh Dhaliwal @tutorial T05
 * @author Jaspinder Singh Maan @tutorial T15
 * @author Navpreet Singh @tutorial T08
 * @created 2024-04-15
 * 
 */

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Optional;

public class tests {
  @Before
  public void setUp() {
    // Set up your test environment
    data.floor_vacancy = new HashMap<>();
    data.floor_vacancy.put(1, 87);
    data.floor_vacancy.put(2, 134);
    data.floor_vacancy.put(3, 200);

    data.computer_vacancy = new HashMap<>();
    data.computer_vacancy.put(1, 30);
    data.computer_vacancy.put(2, 60);
    data.computer_vacancy.put(3, 75);
  }

  @Test
  public void testShowVacancyAllFloors() {
    String expected = "Floor 1: 87\nFloor 2: 134\nFloor 3: 200\n";
    assertEquals(expected, stats.show_vacancy("all floors"));
  }

  @Test
  public void testShowVacancyAllComputers() {
    String expected = "Floor 1: 30\nFloor 2: 60\nFloor 3: 75\n";
    assertEquals(expected, stats.show_vacancy("all comps"));
  }

  @Test
  public void testShowVacancySpecificFloor() {
    assertEquals("Floor 1: 87", stats.show_vacancy("floor1"));
    assertEquals("Floor 2: 134", stats.show_vacancy("floor2"));
  }

  @Test
  public void testShowVacancySpecificComputer() {
    assertEquals("Floor 1: 30", stats.show_vacancy("comp1"));
    assertEquals("Floor 2: 60", stats.show_vacancy("comp2"));
  }
  @Test
  public void floorTest1(){
    data D1=new data("hi",1234, 2,"STUDY_CUBICLES");
    data D2=new data("hello",12345, 2,"STUDY_CUBICLES");
    D1.set_floor_vacancy(1,23);
    floor floor=new floor("hi",1234,1,"STUDY_CUBICLES");
    int a = floor.getFloorAvailability(2,D1);
    floor.new_flr_ava(2,24,D1);
    a=floor.getFloorAvailability(1,D2);
    int b=floor.getFloorAvailability(1,D1);
    assertEquals(23,a);
    assertEquals(23,b);
    /**
     * this test is to check that even if we acces the floor vacancy through different
     * data objects
     */
  }

  @Test
  public void testFloorAvailabilityUpdateDoesNotAffectOtherFloors() {
    // Setup
    data floorData = new data("Main Building", 1001, 3, "OFFICE");
    floor floor = new floor("Main Building", 1001, 3, "OFFICE");
    floor.set_floor_vacancy(3, 10);  // Set initial vacancy for floor 3
    floor.set_floor_vacancy(4, 20);  // Set initial vacancy for floor 4

    // Action
    floor.new_flr_ava(3, 15, floorData); // Update floor 3

    // Validation
    assertEquals(15, floor.getFloorAvailability(3, floorData));
    assertEquals(20, floor.getFloorAvailability(4, floorData));
  }




  @Test
  public void testComputerAvailabilityOnFloor() {
    // Setup
    data floorData = new data("Main Building", 1001, 3, "OFFICE");
    Computers computers = new Computers("Main Building", 1001, 3, "OFFICE");  // Assume 20 computers total
    floorData.set_computer_vacancy(3, 5);  // Allocate 5 computers to floor 3

    // Action and Validation
    assertEquals(5, computers.getComputerAvailability(3,floorData));
  }
  @Test
  public void testSignInDecreasesAvailability() {
    // Setup
    floor floor = new floor("Main Building", 1001, 1, "OFFICE");
    SignIn signIn = new SignIn();

    // Action
    data D1=new data("ja",123,1,"library");
    int a =D1.getFloorAvailability(1);
    signIn.execute("Library", 101, true, "GROUND_FLOOR", "STUDY_CUBICLES");
    System.out.println(data.dataObjects);
    data[] array = data.dataObjects.toArray(new data[0]);
    // Assert
    assertEquals(a-1, array[0].getFloorAvailability(1));
  }

  @Test
  public void testFloorAssignment() {
    SignIn signIn = new SignIn();
    data D1=new data("ja",123,1,"library");
    floor f=new floor("ja",123,1,"library");
    signIn.execute("John Doe", 12345, false, "GROUND_FLOOR", "Library");
    assertEquals(1, D1.getfloor());

    signIn.execute("Jane Doe", 12346, false, "SECOND_FLOOR", "Cafeteria");
    assertEquals(133, f.getFloorAvailability(2));

  }
  @Test
  public void testSignOutIncreasesAvailability() {
    // Setup
    floor floor = new floor("Main Building", 1001, 1, "OFFICE");
    SignOut signout = new SignOut();

    // Action\
    data D1=new data("Library", 101, 1, "STUDY_CUBICLES");
    int a =D1.getFloorAvailability(1);
    signout.execute("Library", 101, true, "GROUND_FLOOR", "STUDY_CUBICLES");

    data.dataObjects.add(D1);
    data[] array = data.dataObjects.toArray(new data[0]);
    // Assert
    assertEquals(a, array[0].getFloorAvailability(1));
  }

}
