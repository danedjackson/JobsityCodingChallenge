package main.java.Service.Validation;

import main.java.Interface.IValidator;
import main.java.Model.FileInput;

import java.util.List;

public class PinfallContentValidator implements IValidator<FileInput> {
    @Override
    public boolean validate(List<FileInput> bowlerInputData) {
        boolean isValid = true;
        int pinfallValue = 0;

        for(FileInput bowlerData : bowlerInputData){
            if(!bowlerData.getPinfall().equalsIgnoreCase("f")) {
                try{
                    pinfallValue = Integer.parseInt(bowlerData.getPinfall());
                }catch(NumberFormatException e) {
                    System.out.println("Failed to parse pinfall data, invalid data provided.");
                    isValid = false;
                    break;
                }
                if(pinfallValue < 0 || pinfallValue > 10){
                    System.out.println("Invalid score provided, only scores of 0 to 10 are accepted.");
                    isValid = false;
                    break;
                }
            }
        };
        return isValid;
    }
}
