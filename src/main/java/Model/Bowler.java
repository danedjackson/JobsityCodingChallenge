package main.java.Model;

import main.java.Interface.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class Bowler implements IPlayer {
    private String name;
    private List<String> pinfalls;
    private List<Integer> scores;
    private List<ScoringFrame> scoringFrame;

    static final Integer MAX_PINS = 10;

    public Bowler(List<ScoringFrame> scoringFrame){
        this.scoringFrame = scoringFrame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPinfalls() {
        return pinfalls;
    }

    public void setPinfalls(List<String> pinfalls) {
        this.pinfalls = pinfalls;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public List<ScoringFrame> getScoringFrame() {
        return scoringFrame;
    }

    public void setScoringFrame(List<ScoringFrame> scoringFrame) {
        this.scoringFrame = scoringFrame;
    }

    @Override
    public String toString() {
        return "Bowler{" +
                "name='" + name + '\'' +
                ", pinfalls=" + pinfalls +
                ", scores=" + scores +
                '}';
    }

    @Override
    public List<Integer> calculateScore() {
        List<Integer> scores = new ArrayList<>();
        Integer runningScore = 0;
        for(int i = 0; i < pinfalls.size() - 1; i++) {
            if(MAX_PINS - Integer.parseInt(pinfalls.get(i)) == 0) {
                //Strike
                scoringFrame.add(new ScoringFrame(" ", "X"));
                for(int x = 0; x < 3; x++) {
                    if( i + x <= pinfalls.size() -1 ) {
                        runningScore += Integer.parseInt(pinfalls.get(i + x));
                    }
                }
                scores.add(runningScore);
            }
            else if(MAX_PINS - (Integer.parseInt(pinfalls.get(i)) + Integer.parseInt(pinfalls.get(i+1))) == 0) {
                //Spare
                scoringFrame.add(new ScoringFrame(String.valueOf(pinfalls.get(i)), "/"));
                runningScore += MAX_PINS + Integer.parseInt(pinfalls.get(i + 2));
                scores.add(runningScore);
                i++;
            }
            else {
                scoringFrame.add(new ScoringFrame(pinfalls.get(i), pinfalls.get(i+1)));
                runningScore += Integer.parseInt(pinfalls.get(i)) + Integer.parseInt(pinfalls.get(i + 1));
                scores.add(runningScore);
                i++;
            }

        }

//        scoringFrame.forEach(frame -> System.out.println(frame));
        return scores;
    }

}
