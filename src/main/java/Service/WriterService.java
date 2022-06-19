package main.java.Service;

import main.java.Model.Bowler;
import main.java.Model.ScoringFrame;

import java.util.List;

public class WriterService {
    private List<Bowler> bowlers;

    public WriterService(List<Bowler> bowlers) {
        this.bowlers = bowlers;
    }

    public void printScores() {
        bowlers.forEach(bowler -> {
            System.out.print("Frame\t\t\t");
            for(int x = 0; x < bowler.getScoringFrame().size() -1; x++) {
                System.out.print(x+1 + "\t\t");
                if ((x+1) %10 == 0) {
                    System.out.print("\n");
                    System.out.println(bowler.getName());
                    System.out.print("Pinfalls\t\t");
                    for(int i = 0; i < bowler.getScoringFrame().size(); i++) {
                        System.out.print(bowler.getScoringFrame().get(i).getFirstScore() + "\t" + bowler.getScoringFrame().get(i).getSecondScore() + "\t");
                    }
                    System.out.print("\n");
                    System.out.print("Score\t\t\t");
                    for(int i = 0; i < bowler.getScoringFrame().size() -1; i++) {
                        System.out.print(bowler.getScores().get(i) + "\t\t");
                    }
                    System.out.print("\n");
                    return;
                }
            }
        });
    }
}
