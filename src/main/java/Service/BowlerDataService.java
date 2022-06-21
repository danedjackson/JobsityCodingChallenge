package main.java.Service;

import main.java.Model.FileInput;
import main.java.Model.Bowler;
import main.java.Model.ScoringFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BowlerDataService {

    public List<Bowler> createBowlerList(List<FileInput> rawData) {

        List<Bowler> bowlerList = new ArrayList<>();

        //Getting the name values from the raw data
        List<String> names = new ArrayList<>();
        for (FileInput element : rawData) {
            names.add(element.getName());
        }

        //Determining the names of each player
        List<String> distinctPlayers = names.stream().distinct().collect(Collectors.toList());

        //Building player objects from data provided
        for(String name : distinctPlayers){
            Bowler bowler = new Bowler(new ArrayList<>());
            bowler.setName(name);
            bowler.setPinfalls(generatePinfallInputs(name, rawData));
            bowler.setScores(bowler.calculateScore());
            bowlerList.add(bowler);
        }

        return bowlerList;
    }

    public Bowler createBowler(List<FileInput> rawData) {
        Bowler bowler = new Bowler(new ArrayList<>());
        bowler.setName(rawData.get(0).getName());
        bowler.setPinfalls(generatePinfallInputs(bowler.getName(), rawData));
        bowler.setScores(bowler.calculateScore());

        return bowler;
    }

    public List<String> generatePinfallInputs(String name, List<FileInput> data) {
        List<String> pinfalls = new ArrayList<>();
        //Checking the pinfall values for each name
        for (FileInput element : data) {
            if(element.getName().equalsIgnoreCase(name)) {
                //Set pinfall value to 0 if "F" is input
                //TODO:(not sure if I want to change this, possibly have a static function to filter Fouls later
                if (element.getPinfall().equalsIgnoreCase("f")) element.setPinfall("0");

                pinfalls.add(element.getPinfall());
            }
        }
        return pinfalls;
    }
}
