package main.java;

import main.java.Service.BowlerDataService;
import main.java.Service.FileReaderService;
import main.java.Service.ConsoleWriterService;
import main.java.Service.Validation.FrameSizeValidator;
import main.java.Service.Validation.PinfallContentValidator;

public class Main {
    public static void main(String args[]) {
        FileReaderService reader = new FileReaderService("C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt");

        FrameSizeValidator frameSizeValidator = new FrameSizeValidator();
        PinfallContentValidator pinfallContentValidator = new PinfallContentValidator();

        System.out.println(pinfallContentValidator.validate(reader.readRawData()));

        ConsoleWriterService writer = new ConsoleWriterService(new BowlerDataService().createBowlerList(reader.readRawData()));
        writer.writeScores();
    }
}