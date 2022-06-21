package main.java.Service;

import main.java.Interface.IReader;
import main.java.Model.FileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReaderService implements IReader {
    private String filePath;

    public FileReaderService(String filePath) {

        this.filePath = filePath;
    }

    //Reads the raw data from the target file
    @Override
    public List<FileInput> readRawData() {
        List<FileInput> rawData = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String data[] = scanner.nextLine().split("\t");
                rawData.add(new FileInput(data[0], data[1]));
            }
        } catch(FileNotFoundException e) {
            //Handled by validation
        }
        return rawData;
    }

}