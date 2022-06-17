package main.java.Service;

import main.java.Model.FileInput;
import main.java.Model.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReaderService {
    private String filePath;

    public ReaderService(String filePath) {

        this.filePath = filePath;
    }

    //Reads the raw data from the target file
    public List<FileInput> readRawData() {
        List<FileInput> rawData = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String data[] = scanner.nextLine().split("\t");
                rawData.add(new FileInput(data[0], data[1]));
            }
        } catch(FileNotFoundException e) {
            System.out.println("The file could not be found, please verify that you have entered the correct file path.");
        }
        return rawData;
    }

}