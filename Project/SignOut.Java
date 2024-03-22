public class SignOut extends Menu {

    @Override
    public Integer[] execute() {
        System.out.println("Please enter your UCID to sign out:");
        int ucid = getIntegerInput();

        data userFloor = findUser(ucid);

        if (userFloor != null) {
            data.dataObjects.remove(userFloor); // Remove the user's floor from the tracking set
            System.out.println("You have successfully signed out. Thank you!");

            // Further logic to update floor and computer availability can be added here
        } else {
            System.out.println("UCID not found in the db.");
        }

        return null; // This method does not need to return any specific result
    }

    private data findUser(int ucid) {
        // Iterate over the reportList to find the user's floor object by UCID
        for (data f : data.dataObjects) {
            if (f.getID() == ucid) {
                return f; // Return the found floor object
            }
        }
        return null; // Return null if the user's floor object is not found
    }
}
