package main.java;

import main.java.Model.Bowler;
import main.java.Service.BowlerDataService;
import main.java.Service.FileReaderService;
import main.java.Service.ConsoleWriterService;
import main.java.Service.PromptService;
import main.java.Service.Validation.FrameSizeValidator;
import main.java.Service.Validation.PinfallContentValidator;

import java.util.List;

public class Main {
    public static void main(String args[]) {

        //Prompt user to enter file path for processing
        PromptService promptService = new PromptService();
        FileReaderService reader = new FileReaderService(promptService.readFilePath());

        FrameSizeValidator frameSizeValidator = new FrameSizeValidator();
        PinfallContentValidator pinfallContentValidator = new PinfallContentValidator();

        //Checking pinfall input validity
        if(!pinfallContentValidator.validate(reader.readRawData())) return;

        //Create bowler object(s)
        List<Bowler> bowlerList = new BowlerDataService().createBowlerList(reader.readRawData());

        //Checking size of scores provided
        boolean isCorrectSize = true;
        for(Bowler bowler: bowlerList){
            if(!frameSizeValidator.validate(bowler.getScoringFrame())) {
                isCorrectSize = false;
                break;
            }
        }
        if (!isCorrectSize) return;

        //Displaying scores to output window
        ConsoleWriterService writer = new ConsoleWriterService(bowlerList);
        writer.writeScores();
    }
}