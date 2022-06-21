package test.java;

import main.java.Model.Bowler;
import main.java.Model.ScoringFrame;
import main.java.Service.BowlerDataService;
import main.java.Service.FileReaderService;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class BowlerScoreTest {
    @Test
    void perfectScoreAmountsTo300() {
        FileReaderService fileReaderService = createFileReaderService(
                "C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\perfect.txt");

        List<Bowler> bowlerList = new BowlerDataService().createBowlerList(fileReaderService.readRawData());
        List<Integer> scores = bowlerList.get(0).calculateScore();

        assert scores.get(scores.size()-1) == 300;
    }

    @Test
    void jeffFirstFrameEqualsStrikeFromDoubleScoreFile() {
        FileReaderService fileReaderService = createFileReaderService(
                "C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt");

        List<Bowler> bowlerList = new BowlerDataService().createBowlerList(fileReaderService.readRawData());
        List<Bowler> bowler = bowlerList.stream().filter(b -> b.getName().equalsIgnoreCase("jeff")).collect(Collectors.toList());

        ScoringFrame scoringFrame = bowler.get(0).getScoringFrame().get(0);

        assert scoringFrame.getSecondScore().equalsIgnoreCase("x");
    }

    @Test
    void johnTotalPointsEquals151FromDoubleScoreFile() {
        FileReaderService fileReaderService = createFileReaderService(
                "C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt");

        List<Bowler> bowlerList = new BowlerDataService().createBowlerList(fileReaderService.readRawData());
        List<Bowler> bowler = bowlerList.stream().filter(b -> b.getName().equalsIgnoreCase("john")).collect(Collectors.toList());

        Bowler john = bowler.get(0);

        assert john.getScores().get(john.getScores().size()-1) == 151;
    }

    @Test
    void zeroTotalScoreFromZeroScoreFile() {
        FileReaderService fileReaderService =
                createFileReaderService("C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\custom\\dane-zero-scores.txt");
        Bowler bowler = new BowlerDataService().createBowler(fileReaderService.readRawData());

        assert bowler.getScores().get(bowler.getScores().size() - 1) == 0;
    }

    FileReaderService createFileReaderService(String path) {
        return new FileReaderService(path);
    }
}
