package main.java;

import main.java.Service.FileVerificationService;
import main.java.Service.ReaderService;
import main.java.Service.WriterService;

public class Main {
    public static void main(String args[]) {
        ReaderService reader = new ReaderService("C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt");


        WriterService writer = new WriterService(new FileVerificationService().createBowlerList(reader.readRawData()));
        writer.printScores();
    }
}