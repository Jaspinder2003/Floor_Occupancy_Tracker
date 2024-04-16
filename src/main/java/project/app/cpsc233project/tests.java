package project.app.cpsc233project;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

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
    public void testMaxMinFloors() {
        // Assuming 'max_min' calculates occupancy, not vacancy
        double[] expected = new double[]{100 * (87 - 10) / 87, 100 * (87 - 30) / 87, 3, 1};
        // JUnit 4 does not have a direct method for comparing arrays with a delta, so you need to use a loop or a helper method.
        double[] result = stats.max_min("floors");
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i], 0.01);
        }
    }

    @Test
    public void testMaxMinComputers() {
        double[] expected = new double[]{100 * (75 - 5) / 75, 100 * (75 - 25) / 75, 3, 1};
        double[] result = stats.max_min("computers");
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i], 0.01);
        }
    }
}
