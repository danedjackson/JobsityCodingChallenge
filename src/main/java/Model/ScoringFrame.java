package main.java.Model;
import java.util.Map;

public class ScoringFrame {
    private String firstScore;
    private String secondScore;

    public ScoringFrame(String firstScore, String secondScore) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public ScoringFrame() {

    }

    public String getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(String firstScore) {
        this.firstScore = firstScore;
    }

    public String getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(String secondScore) {
        this.secondScore = secondScore;
    }

    @Override
    public String toString() {
        return "ScoringFrame{" +
                "firstScore='" + firstScore + '\'' +
                ", secondScore='" + secondScore + '\'' +
                '}';
    }
}
