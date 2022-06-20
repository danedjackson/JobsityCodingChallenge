package main.java.Service;

import java.util.Scanner;

public class UserPromptService {

    public String readFilePath() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the full path to your file. . .\n" +
                "For example: C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt\n:\t");
        return scanner.nextLine();
    }
}
