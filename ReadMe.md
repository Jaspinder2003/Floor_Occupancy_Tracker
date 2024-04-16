Certainly! Here's a more detailed version of the README file that includes information about the classes and how the application components are interconnected:

---

# TFDL Occupancy Tracker

## Description
The TFDL Occupancy Tracker is a JavaFX application designed for the management and monitoring of occupancy and resource usage within the Taylor Family Digital Library at the University of Calgary. It allows users to sign in, select specific floors and areas, and check the availability of resources such as computers and study spaces.

## Features
- **Resource Management**: Tracks the availability of computers and seating areas across multiple floors of the library.
- **Dynamic UI**: Updates the interface in real-time based on user interactions and resource availability.
- **Data Handling**: Manages persistent storage and retrieval of user and resource data through CSV files.

## Architecture Overview

### Classes and Controllers
- **Main**: The entry point of the application that sets up the primary stage and loads the main window.
- **MainController**: Manages interactions from the main application window, handling navigation, user sessions, and file operations.
- **SignInController**: Handles the sign-in process, including validation of user credentials and updating resource availability.
- **SignOutController**: Manages the user sign-out process, ensuring that resources are updated accordingly upon user departure.
- **statsController**: Provides a statistical view of resource usage, such as current occupancy rates and availability of computers. We have added the 4 main features : Least and busiest floors, bar graph for every floor, pie chart demonstrating the current usage and the user list telling the names and ids of all the users
- **data**: Serves as the core data model, managing reading and writing of data, and maintaining up-to-date resource states.
- **Computers**: Specialized class for tracking the availability and usage of computers within the library.
- **floor**: Manages information related to different floors of the library, including their specific areas and overall occupancy.
- **SignIn**: this class is the one that makes use of comparator to sort the objects in data objects and floor objects.
### Interactions
- **FXML Files**: Each controller is linked to an FXML file that defines the layout of the GUI. These files are loaded by their respective controllers.
- **Resource Management**: The `data`, `Computers`, and `floor` classes interact with the controllers to update the GUI based on real-time changes and user interactions.
- **Data Persistence**: Data regarding user sessions and resource status is continuously updated and persisted in CSV files to ensure accuracy across sessions.

## Installation

### Prerequisites
- Java 21 or above
- JavaFX SDK
- An IDE that supports Java (e.g., IntelliJ IDEA, Eclipse)

### Setup
1. Clone the repository:
   ```
   git clone https://csgit.ucalgary.ca/yadwinder.dhaliwal/cpsc-233-group-proeject-w24.git
   ```
2. Open the project in your IDE.
3. Configure the JavaFX SDK:
    - Ensure that the JavaFX library is added to your project settings.
    - Configure your run/debug configurations to include the necessary VM options:
      ```
      --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml, javafx.graphics
      ```

## Usage
Execute the `Main.java` class to run the application. Navigate through the application using the GUI to sign in, manage resources, or view statistics.

## Contributing
Contributions are welcome! Please fork the repository, create a feature branch, and submit a pull request.


## Contact
- **Jaspinder Singh** - JaspinderSingh.maan@ucalgary.ca
- **Navpreet Singh** - Navpreet.singh3@ucalgary.ca
- **Yadwinder Singh** - Yadwinder.dhaliwal@ucalgary.ca

---

This enhanced README provides a comprehensive overview of our application, detailing the functional roles of different classes and their interactions, and should serve as a useful guide for new users or developers.