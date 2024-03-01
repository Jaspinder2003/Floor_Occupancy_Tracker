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

}

