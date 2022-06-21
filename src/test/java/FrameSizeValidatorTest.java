package test.java;

import main.java.Model.Bowler;
import main.java.Service.BowlerDataService;
import main.java.Service.FileReaderService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FrameSizeValidatorTest {
    @Test
    void frameSizeFromDaneScoresEqualsEleven(){
        FileReaderService fileReaderService =
                new FileReaderService("C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\custom\\dane-scores.txt");

        Bowler bowler = new BowlerDataService().createBowler(fileReaderService.readRawData());
        assert bowler.getScoringFrame().size() == 11;
    }
}
