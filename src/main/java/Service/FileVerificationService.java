package main.java.Service;

import main.java.Model.FileInput;
import main.java.Model.Player;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileVerificationService {

    private String[] acceptableStringInput = {"F"};

    public List<Player> createPlayerList(List<FileInput> rawData) {

        List<Player> playerList = new ArrayList<>();

        //Getting the name values from the raw data
        List<String> names = new ArrayList<>();
        for (FileInput element : rawData) {
            names.add(element.getName());
        }

        //Determining the names of each player
        List<String> distinctPlayers = names.stream().distinct().collect(Collectors.toList());

        //Building player objects from data provided
        for(String name : distinctPlayers){
            Player player = new Player();
            player.setName(name);
            //player.setPinfalls(validatePinfallInputs(name, rawData));
            playerList.add(player);
        }

        return playerList;
    }

    public List<String> validatePinfallInputs(String name, Map<String, String> data) {
        System.out.println(data);
        List<String> pinfalls = new ArrayList<>();
        for (Map.Entry<String, String> element : data.entrySet()) {
            if(element.getKey().equalsIgnoreCase(name)) {
                element.setValue(element.getValue().toLowerCase() == "f" ? "0": element.getValue());
                try {
                    Integer value = Integer.parseInt(element.getValue());
                    if ((value >= 0 && value <= 10)) {
                        pinfalls.add(element.getValue());
                    }
                    //Handle if value is invalid here
                } catch (NumberFormatException e) {
                    System.out.println("Failed to parse pinfall value.");
                }
            }
        }
        return pinfalls;
    }
}
