public class stats {
    /**
     * This class is designed to handle and display vacancy information in a building. It supports querying
     * for vacancies across different areas such as floors and computer stations.
     */
    
    /**
     * Displays vacancy information for a specified area.
     * 
     * @param area Specifies the area to query. Valid options include "all floors", "all comps", or a specific 
     * floor/computer station (e.g., "floor1", "comp1").
     * @return A formatted string containing the number of vacancies for the specified area.
     */
    public static String show_vacancy(String area) {
        String output = ""; // Used to accumulate the vacancy information to be returned.
        int vacant = 0; // Holds the vacancy count for the current area being processed.
        
        // Process the request based on the specified area.
        switch (area) {
            case "all floors":
                // Aggregate vacancy info across all floors.
                for (int floor : data.floor_vacancy.keySet()) {
                    vacant = data.floor_vacancy.get(floor);
                    output += ("Floor " + floor + ": " + vacant + "\n");
                }
                break;
            case "all comps":
                // Aggregate vacancy info for all computer stations.
                for (int floor : data.computer_vacancy.keySet()) {
                    vacant = data.computer_vacancy.get(floor);
                    output += ("Floor " + floor + ": " + vacant + "\n");
                }
                break;
            // The following cases handle specific floors or computer stations.
            case "floor1":
                vacant = data.floor_vacancy.get(1);
                output += ("Floor 1: " + vacant);
                break;
            case "floor2":
                vacant = data.floor_vacancy.get(2);
                output += ("Floor 2: " + vacant);
                break;
            case "floor3":
                vacant = data.floor_vacancy.get(3);
                output += ("Floor 3: " + vacant);
                break;
            case "comp1":
                vacant = data.computer_vacancy.get(1);
                output += ("Floor 1: " + vacant);
                break;
            case "comp2":
                vacant = data.computer_vacancy.get(2);
                output += ("Floor 2: " + vacant);
                break;
            case "comp3":
                vacant = data.computer_vacancy.get(3);
                output += ("Floor 3: " + vacant);
                break;
        }

        // Return the output string containing vacancy information for all floors
        return output;
    }

    /**
     * Determines the floors or computer stations with the maximum and minimum vacancies.
     * 
     * @param area Specifies whether to query "floors" or "computers".
     * @return An array containing two integers, the first represents the floor/station with the maximum vacancies, 
     * and the second with the minimum vacancies.
     */
    public static int[] max_min(String area) {
        int max = 0; // Track the floor with the maximum vacancy.
        int min = 0; // Track the floor with the minimum vacancy.

        int max_value = Integer.MIN_VALUE; // To compare value with different floors to find maximum.
        int min_value = Integer.MAX_VALUE; // To compare value with different floors to find minimum.

        int[] output = new int[2]; // Holds the result [max, min].
        // Switch statement to decide the operation based on the area specified
        switch (area) {
            case "floors":
                // Initialize max and min to 0 for the 'floors' case
                max = 0;
                min = 0;
                // Variable compare_value is not initialized in this snippet, it should hold the comparison value for vacancy counts

                // Iterate through each floor in the data.floor_vacancy HashMap
                for (int floor : data.floor_vacancy.keySet()) {
                    // If current floor's vacancy is higher than the last compared value, update compare_value and max floor
                    if (max_value < data.floor_vacancy.get(floor)) {
                        max_value = data.floor_vacancy.get(floor); // Update max to the new highest vacancy count
                        max = floor; // Update max to the current floor
                    }
                    // If current floor's vacancy is lower than the last compared value, update min floor
                    else if (min_value > data.floor_vacancy.get(floor)) {
                        min_value = data.floor_vacancy.get(floor); // Update min to the new least vacancy count
                        min = floor; // Update min to the current floor
                    }
                }
                break;
            case "computers":
                // Initialize max and min to 0 for the 'computers' case
                max = 0;
                min = 0;

                // Iterate through each floor in the data.computer_vacancy HashMap
                for (int floor : data.computer_vacancy.keySet()) {
                    // If current floor's computer vacancy is higher than the last compared value, update compare_value and max floor
                    if (max_value < data.computer_vacancy.get(floor)) {
                        max_value = data.computer_vacancy.get(floor); // Update max to the new highest computer vacancy count
                        max = floor; // Update max to the current floor
                    }
                    // If current floor's computer vacancy is lower than the last compared value, update min floor
                    else if (min_value > data.computer_vacancy.get(floor)) {
                        min_value = data.floor_vacancy.get(floor); // Update min to the new least vacancy count
                        min = floor; // Update min to the current floor
                    }
                }
                break;
        }

        // Assign the max floor to the first element and min floor to the second element of the output array
        output[0] = max;
        output[1] = min;

        // Return the output array containing the floors with the maximum and minimum vacancies
        return output;

    }
        public String formatAsGrid(ArrayList<data> names) {
        String nm="";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {

            data data = names.get(i);
            String[] n=data.getName().split(" ");
            if(n.length>1){
            char f=n[0].charAt(0);
            String l=n[n.length-1];
             nm=f+"."+l;//First initial.Last Name
            } else if (n.length==1) {
                 nm=n[0];//one length name
            }
            else{
                 nm="Unknown";//no name given
            }

            sb.append("[").append(nm).append("]");
            if ((i + 1) % 4 == 0) sb.append("\n"); // Break line after every 4 names
            else sb.append(" "); // Add a space between names on the same line
        }
        return sb.toString().trim(); // Trim to remove the last space or newline

    }
/**
 * this method is used to convert a grid into a string to better visualize the data that we have
 */
}
