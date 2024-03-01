import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testing_cases {

    @Test
    public void testSignInInvalidInput() {
        Integer[] floorInfo = {2, 5}; // Example floor information
        String input = "InvalidName\nNotAnInteger\n4\n"; // Example input for name, student ID, and computer usage
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(StackOverflowError.class, () -> {
            Menu.SignIn(floorInfo); // Assuming SignIn method is in class SignIn
        });
        // No additional assertions needed because the expectation is that an exception is thrown
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


}

