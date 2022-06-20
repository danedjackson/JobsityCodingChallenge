package main.java.Service;

import java.util.Scanner;

public class PromptService {

    public String readFilePath() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path to your file:");
        return scanner.nextLine();
    }
}
