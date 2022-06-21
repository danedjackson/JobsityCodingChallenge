package main.java.Service;

import main.java.Interface.IWriter;
import main.java.Model.Bowler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileWriterService implements IWriter {
    private List<Bowler> bowlers;
    static final String FILE_NAME = String.format("%s\\scores\\score-output-%s.txt",
                                                    System.getProperty("user.dir"),
                                                    new SimpleDateFormat("yyMMddhhmmss").format(new Date()));

    public FileWriterService(List<Bowler> bowlers) {
        this.bowlers = bowlers;
    }

    @Override
    public void writeScores() {
        String output = "";
        for(Bowler bowler : bowlers){
            output+= "Frame\t\t\t";
            for (int i = 1; i <= 10; i++) {
                output += i + "\t\t";
            }
            //After printing 10 frames, skip to next line
            output += "\n";
            output += bowler.getName() + "\n";
            output += "Pinfalls\t\t";
            //Iterate over scoring frames
            for (int i = 0; i < bowler.getScoringFrame().size(); i++) {
                output += bowler.getScoringFrame().get(i).getFirstScore() + "\t" + bowler.getScoringFrame().get(i).getSecondScore() + "\t";
            }
            output += "\n";
            output += "Score\t\t\t";
            //Iterate over running score
            for (int i = 0; i < bowler.getScoringFrame().size() - 1; i++) {
                output += bowler.getScores().get(i) + "\t\t";
            }
            output += "\n";
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(output);
            writer.close();
        } catch (IOException e ) {
            e.printStackTrace();
        }
        System.out.println("\nYour file has been saved to:\n" + FILE_NAME);
    }
}
