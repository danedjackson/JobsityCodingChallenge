package main.java.Service;

import java.util.Scanner;

public class UserPromptService {
    Scanner scanner = new Scanner(System.in);

    public String readFilePath() {
        System.out.print("Enter the full path to your file. . .\n" +
                "For example: C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt\n:\t");
        return scanner.nextLine();
    }

    public boolean writeToFile() {
        System.out.println("\n\nDo you want to generate a file from this score output?\nPlease enter Y for yes, or N for no)");
        String response = scanner.nextLine();
        if (response.toLowerCase().startsWith("y")) return true;
        else if (response.toLowerCase().startsWith("n")) {
            System.out.println("\nThank you for using the bowling score program! Goodbye!");
            return false;
        }
        else{
            System.out.println("\nInvalid option, exiting the program.");
            return false;
        }
    }
}
