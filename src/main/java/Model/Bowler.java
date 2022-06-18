package main.java.Model;

import main.java.Interface.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class Bowler implements IPlayer {
    private String name;
    private List<String> pinfalls;
    private List<Integer> scores;
    private List<ScoringFrame> scoringFrame;

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
            if(10 - Integer.parseInt(pinfalls.get(i)) == 0) {
                //Strike
                scoringFrame.add(new ScoringFrame(" ", "X"));
                for(int x = 0; x < 3; x++) {
                    runningScore += Integer.parseInt(pinfalls.get(i + x));
                }
                scores.add(runningScore);
            }
            else if(10 - (Integer.parseInt(pinfalls.get(i)) + Integer.parseInt(pinfalls.get(i+1))) == 0) {
                //Spare
                scoringFrame.add(new ScoringFrame(String.valueOf(pinfalls.get(i)), "/"));
                runningScore += 10+Integer.parseInt(pinfalls.get(i + 2));
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

        scoringFrame.forEach(frame -> System.out.println(frame));
        return scores;
    }

//    @Override
//    public List<Integer> calculateScore() {
//        List<Integer> scores = new ArrayList<>();
//        int frameScore = 0;
//        //Calculating total points for each round
//        for(int x = 0; x < pinfalls.size()-1; x++) {
//            Integer value = Integer.parseInt(pinfalls.get(x));
//            int pins = 10;
//            if ((pins - value) == 0){
//                //Strike
//                for(int i = x; i < x+3; i++) {
//                    frameScore = frameScore + Integer.parseInt(pinfalls.get(i));
//                }
//                scores.add(frameScore);
//                frameScore = 0;
//            }
//            else if ((pins - (value + Integer.parseInt(pinfalls.get(x+1)))) == 0){
//                //Spare
//                for(int y = x; y < x+1; y++) {
//                    frameScore = frameScore + Integer.parseInt(pinfalls.get(y));
//                }
//                scores.add(frameScore);
//                frameScore = 0;
//            }
//            else {
//                scores.add(value + Integer.parseInt(pinfalls.get(x + 1)));
//            }
//        }
//        return scores;
//    }
}
