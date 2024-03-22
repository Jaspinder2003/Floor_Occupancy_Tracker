import java.util.Scanner;

public class Main {

    public static 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to TFDL!\n");
        System.out.println("Do you want to:\n1. Check In\n2. Check Out\n3. Statistics");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                SignIn();
                break;
        }

    }

    public static void SignIn() {
        System.out.println("\nHere is some data that might help choose correct space:\nOverall Spaces free:\n" + stats.show_vacancy("all floors") + "\nComputer spaces free:\n" + stats.show_vacancy("all comps"));

    }
}
