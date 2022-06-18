package main.java.Service;

import main.java.Model.FileInput;
import main.java.Model.Bowler;
import main.java.Model.ScoringFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileVerificationService {

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
            bowler.setPinfalls(validatePinfallInputs(name, rawData));
            bowler.setScores(bowler.calculateScore());
            System.out.println(bowler);
            bowlerList.add(bowler);
        }

        return bowlerList;
    }

    public List<String> validatePinfallInputs(String name, List<FileInput> data) {
        List<String> pinfalls = new ArrayList<>();
        //Checking the pinfall values for each name
        for (FileInput element : data) {
            if(element.getName().equalsIgnoreCase(name)) {
                //Set pinfall value to 0 if "F" is input
                //TODO:(not sure if I want to change this, possibly have a static function to filter Fouls later
                if (element.getPinfall().equalsIgnoreCase("f")) element.setPinfall("0");
                //Trying to parse integer from pinfall value
                try {
                    Integer value = Integer.parseInt(element.getPinfall());
                    if ((value >= 0 && value <= 10)) {
                        pinfalls.add(element.getPinfall());
                    }
                    //TODO:Handle if value is invalid here
                } catch (NumberFormatException e) {
                    System.out.println("Failed to parse pinfall value.");
                }
            }
        }
        return pinfalls;
    }
}
