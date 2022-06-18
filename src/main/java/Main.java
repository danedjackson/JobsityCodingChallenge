package main.java;

import main.java.Service.FileVerificationService;
import main.java.Service.ReaderService;

public class Main {
    public static void main(String args[]) {
        ReaderService reader = new ReaderService("C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt");
        new FileVerificationService().createBowlerList(reader.readRawData());
    }
}