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

}
