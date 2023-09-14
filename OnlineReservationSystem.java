import java.util.Scanner;

public class OnlineReservationSystem {
    // Dummy database for demonstration purposes
    private static String username = "user123";
    private static String password = "password123";
    private static String trainNumber = "12345";
    private static String trainName = "Sample Train";
    private static String classType = "First Class";
    private static String dateOfJourney = "2023-09-15";
    private static String source = "Source";
    private static String destination = "Destination";
    private static String pnrNumber = "PNR123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login Form
        System.out.println("Welcome to the Online Reservation System");
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (isValidLogin(enteredUsername, enteredPassword)) {
            System.out.println("Login successful!\n");

            // Reservation System
            System.out.println("Reservation System");
            System.out.print("Enter your basic details: ");
            String userDetails = scanner.nextLine();

            System.out.print("Enter class type: ");
            String enteredClassType = scanner.nextLine();

            System.out.print("Enter from (place): ");
            String enteredSource = scanner.nextLine();

            System.out.print("Enter destination: ");
            String enteredDestination = scanner.nextLine();

            // Automatically fill train name and number
            String enteredTrainName = trainName;
            String enteredTrainNumber = trainNumber;

            System.out.print("Enter date of journey: ");
            String enteredDateOfJourney = scanner.nextLine();

            // Insert button functionality (add data to the central database)
            System.out.println("Reservation details:");
            System.out.println("User Details: " + userDetails);
            System.out.println("Train Number: " + enteredTrainNumber);
            System.out.println("Train Name: " + enteredTrainName);
            System.out.println("Class Type: " + enteredClassType);
            System.out.println("Date of Journey: " + enteredDateOfJourney);
            System.out.println("Source: " + enteredSource);
            System.out.println("Destination: " + enteredDestination);
            System.out.println("Ticket booked successfully!\n");

            //


            // Cancellation Form
            System.out.println("Cancellation Form");
            System.out.print("Enter PNR number to cancel the ticket: ");
            String enteredPNR = scanner.nextLine();

            if (enteredPNR.equals(pnrNumber)) {
                System.out.println("Ticket with PNR " + enteredPNR + " has been canceled successfully.");
            } else {
                System.out.println("Invalid PNR number. Ticket cancellation failed.");
            }
        } else {
            System.out.println("Invalid login credentials. Please try again.");
        }
    }

    private static boolean isValidLogin(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }
}
