import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testing_cases {
//jaspinder singh maan
@Test
        public void testSignInInvalidInput() {
            Integer[] floorInfo = {2, 5}; // Example floor information
            String input = "InvalidName\nNotAnInteger\n4\n"; // Example input for name, student ID, and computer usage
            InputStream in = new ByteArrayInputStream(input.getBytes());//converts the string into input stream to be put into the function
            System.setIn(in);

            assertThrows(StackOverflowError.class, () -> {
                Menu.SignIn(floorInfo); // Assuming SignIn method is in class SignIn
            });
            // No additional assertions needed because the expectation is that an exception is thrown
        }
    @Test
    public void testSignInValidInput() {
        Integer[] floorInfo = {1, 10}; // Example floor information
        int studentID = 123456789; // Example student ID
        String input = "John Doe\n" + studentID + "\n"+2+"\n"; // Example input for name, student ID, and computer usage
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int initialAvailableSeats = data.floor_value_finder("1"); // Get the initial available seats on floor 1
        
        Menu.signIn(floorInfo); // Assuming SignIn method is in class SignIn
        
        int updatedAvailableSeats = data.floor_value_finder("1"); // Get the updated available seats on floor 1

        assertEquals(initialAvailableSeats - 1, updatedAvailableSeats, "Available seats should decrease by 1 after sign-in");
    }




    //Navpreet   
    @Test
    public void validInputTest() {
        String input = "1\n1\n"; // Simulate user input: 1 (Ground Floor), 1 (Study Cubicles)
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Integer[] expected = {1, 1};
        Integer[] result = Menu.initalMenu();
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
    }
    
    @Test
    public void invalidFloorSelectionTest() {
        String input = "5\n4\n"; // Simulate user input: 5 (Invalid floor selection), 4 (Exit)
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Integer[] expected = {4, 0}; // User chooses to exit
        Integer[] result = Menu.initalMenu();
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
    }

    //Yadwinder Singh Dhaliwal
    @Test
        public void testSignOutWithInvalidInput() {
        // Prepare test environment
        String input = "InvalidName\nNotAnInteger\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(Exception.class, () -> {
            Menu.SignOut();
        });
        // Add assertions here to verify the expected behavior
        }
    
    @Test
    public void testSignOutWithValidInput() {
        // Prepare test environment
        String input = "John Doe\n123456789\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        // Execute SignOut method
        SignOut.signOut();
        
        // Assertions
        // Here we can assert that the user is successfully signed out or that the reserved space is released
        assertFalse(data.floor_occupancy.containsKey(123456789), "User should no longer have a reservation after signing out");
    }

    @Test
    public void testSignOutWithInvalidInput() {
        // Prepare test environment
        String input = "InvalidName\nNotAnInteger\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(Exception.class, () -> {
            SignOut.signOut();
        });

        // No additional assertions needed because the expectation is that an exception is thrown
    }


}

