package main.java.Model;

import main.java.Interface.IPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                //Calculate the total points for the strike frame by adding 3 more bowls.
                for(int x = 0; x < 3; x++) {
                    if( i + x <= pinfalls.size() -1 ) {
                        runningScore += Integer.parseInt(pinfalls.get(i + x));
                    }
                }
                scores.add(runningScore);
            }
            //If current index plus following index equals 10, then a spare has been achieved.
            else if(MAX_PINS - (Integer.parseInt(pinfalls.get(i)) + Integer.parseInt(pinfalls.get(i+1))) == 0) {
                //Spare
                scoringFrame.add(new ScoringFrame(String.valueOf(pinfalls.get(i)), "/"));
                //Calculate the total points for the spare frame by adding 1 more bowl.
                runningScore += MAX_PINS + Integer.parseInt(pinfalls.get(i + 2));
                scores.add(runningScore);
                i++;
            }
            else {
                //No strikes nor spares achieved, add frame normally.
                scoringFrame.add(new ScoringFrame(pinfalls.get(i), pinfalls.get(i+1)));
                runningScore += Integer.parseInt(pinfalls.get(i)) + Integer.parseInt(pinfalls.get(i + 1));
                scores.add(runningScore);
                i++;
            }
        }
        //Removing last index
        scores.remove(scores.size()-1);

        return scores;
    }


}
