package test.java;

import main.java.Model.Bowler;
import main.java.Model.ScoringFrame;
import main.java.Service.BowlerDataService;
import main.java.Service.FileReaderService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BowlerScoreTest {
    @Test
    void perfectScoreAmountsTo300() {
        FileReaderService fileReaderService = new FileReaderService(
                "C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\perfect.txt");

        List<Bowler> bowlerList = new BowlerDataService().createBowlerList(fileReaderService.readRawData());
        List<Integer> scores = bowlerList.get(0).calculateScore();

        assert scores.get(scores.size()-1) == 300;
    }

    @Test
    void jeffFirstFrameEqualsStrikeFromDoubleScoreFile() {
        FileReaderService fileReaderService = new FileReaderService(
                "C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt");

        List<Bowler> bowlerList = new BowlerDataService().createBowlerList(fileReaderService.readRawData());
        List<Bowler> bowler = bowlerList.stream().filter(b -> b.getName().equalsIgnoreCase("jeff")).collect(Collectors.toList());

        ScoringFrame scoringFrame = bowler.get(0).getScoringFrame().get(0);

        assert scoringFrame.getSecondScore().equalsIgnoreCase("x");
    }

    @Test
    void johnTotalPointsEquals151FromDoubleScoreFile() {
        FileReaderService fileReaderService = new FileReaderService(
                "C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt");

        List<Bowler> bowlerList = new BowlerDataService().createBowlerList(fileReaderService.readRawData());
        List<Bowler> bowler = bowlerList.stream().filter(b -> b.getName().equalsIgnoreCase("john")).collect(Collectors.toList());

        Bowler john = bowler.get(0);

        assert john.getScores().get(john.getScores().size()-1) == 151;
    }
}
