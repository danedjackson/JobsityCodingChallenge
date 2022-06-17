package main.java.Model;

import main.java.Interface.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer {
    private String name;
    private List<String> pinfalls;
    private List<Integer> scores;

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

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pinfalls=" + pinfalls +
                ", scores=" + scores +
                '}';
    }

    @Override
    public int[] calculateScore() {
        return new int[0];
    }
}
