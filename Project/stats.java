import java.util.HashMap;

public class stats {
    /**
     * This class contains methods for displaying vacancy information.
     */

    /**
     * This method displays the vacancy information for a given area.
     *
     * @param area The area for which vacancy information is required. It can be either "all floors" or a specific floor name.
     * @return A string containing the vacancy information for the specified area.
     */
    public static String show_vacancy(String area) {
        String output = ""; // Initialize an empty string to store the vacancy information
        int vacant = 0;
        switch (area) {
            case "all floors":
                for (String floor : data.floor_vacancy.keySet()) { // Iterate through all the floors
                    vacant = data.floor_vacancy.get(floor); // Get the vacancy count for the current floor

                    // Add the vacancy information for the current floor to the output string
                    output += ("Floor" + floor + ": " + vacant) ;
                }
                break;
            case "all comps":
            for (String floor : data.computer_vacancy.keySet()) { // Iterate through all the floors
                vacant = data.computer_vacancy.get(floor); // Get the vacancy count for the current floor

                // Add the vacancy information for the current floor to the output string
                output += ("Floor" + floor + ": " + vacant) ;
                }
            break;
            case "floor1":
                vacant = data.floor_vacancy.get("1");
                output += ("Floor 1: " + vacant);
                break;
            case "floor2":
                vacant = data.floor_vacancy.get("1");
                output += ("Floor 1: " + vacant);
                break;
            case "floor3":
                vacant = data.floor_vacancy.get("1");
                output += ("Floor 1: " + vacant);
                break;
            case "comp1":
                vacant = data.computer_vacancy.get("1");
                output += ("Floor 1: " + vacant);
                break;
            case "comp2":
                vacant = data.computer_vacancy.get("1");
                output += ("Floor 1: " + vacant);
                break;
            case "comp3":
                vacant = data.computer_vacancy.get("1");
                output += ("Floor 1: " + vacant);
                break;
        }

        // Return the output string containing vacancy information for all floors
        return output;
    }
}
