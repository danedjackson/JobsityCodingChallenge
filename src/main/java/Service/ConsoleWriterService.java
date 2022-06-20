package main.java.Service;

import main.java.Interface.IWriter;
import main.java.Model.Bowler;
import main.java.Model.ScoringFrame;

import java.util.List;

public class ConsoleWriterService implements IWriter {
    private List<Bowler> bowlers;

    public ConsoleWriterService(List<Bowler> bowlers) {
        this.bowlers = bowlers;
    }

    @Override
    public void writeScores() {
        bowlers.forEach(bowler -> {
            System.out.print("Frame\t\t\t");
            for (int x = 0; x < bowler.getScoringFrame().size() - 1; x++) {
                for (int i = 1; i <= 10; i++) {
                    System.out.print(i + "\t\t");
                }
                //After printing 10 frames, skip to next line
                System.out.print("\n");
                System.out.println(bowler.getName());
                System.out.print("Pinfalls\t\t");
                //Iterate over scoring frames
                for (int i = 0; i < bowler.getScoringFrame().size(); i++) {
                    System.out.print(bowler.getScoringFrame().get(i).getFirstScore() + "\t" + bowler.getScoringFrame().get(i).getSecondScore() + "\t");
                }
                System.out.print("\n");
                System.out.print("Score\t\t\t");
                //Iterate over running score
                for (int i = 0; i < bowler.getScoringFrame().size() - 1; i++) {
                    System.out.print(bowler.getScores().get(i) + "\t\t");
                }
                System.out.print("\n");
                return;
            }
        });
    }
}
