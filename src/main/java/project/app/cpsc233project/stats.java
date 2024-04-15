package project.app.cpsc233project;
import java.util.ArrayList;

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
     * Determines the floors or computer stations with the maximum and minimum occupancies.
     * 
     * @param area Specifies whether to query "floors" or "computers".
     * @return An array containing two integers, the first represents the floor/station with the maximum occupancies, 
     * and the second with the minimum occupancies.
     */
    public static double[] max_min(String area) {

        // Initialize the output array
        double[] output = new double[4];

        double floor_1 = 0;
        double floor_2 = 0;
        double floor_3 = 0;

        switch (area) {
            case "floors":
                for (int floor : data.floor_vacancy.keySet()) {
                    if (floor == 1) {
                        double f1 = 87 - data.floor_vacancy.get(floor);
                        floor_1 = (f1/87)*100;
                    } else if (floor == 2) {
                        double f2 = 134 - data.floor_vacancy.get(floor);
                        floor_2 = (f2/134)*100;
                    } else {
                        double f3 = 200 - data.floor_vacancy.get(floor);
                        floor_3 = (f3/200)*100;
                    }
                }
                break;
        
            case "computers":
                for (int floor : data.computer_vacancy.keySet()) {
                    if (floor == 1) {
                        double f1 = 30 - data.computer_vacancy.get(floor);
                        floor_1 = (f1/30)*100;
                    } else if (floor == 2) {
                        double f2 = 60 - data.computer_vacancy.get(floor);
                        floor_2 = (f2/60)*100;
                    } else {
                        double f3 = 75 - data.computer_vacancy.get(floor);
                        floor_3 = (f3/75)*100;
                    }
                }
                break;
        }

        // Initialize the maximum and minimum vacancies
        double max = Math.max(Math.max(floor_1, floor_2), floor_3);
        double min = Math.min(Math.min(floor_1, floor_2), floor_3);

        if (max == floor_1) {
            output[2] = 1;
        } else if (max == floor_2) {
            output[2] = 2;
        } else {
            output[2] = 3;
        }

        if (min == floor_1) {
            output[3] = 1;
        } else if (min == floor_2) {
            output[3] = 2;
        } else {
            output[3] = 3;
        }

        output[0] = max;
        output[1] = min;

        return output;
    }

    public static int num_comp_user() {
        int num_comp_user = Computers.ComputerObjects.size();
        return num_comp_user;
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
