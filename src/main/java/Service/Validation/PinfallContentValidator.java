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
                    isValid = false;
                    break;
                }
                if(pinfallValue < 0 || pinfallValue > 10){
                    isValid = false;
                    break;
                }
            }
        };
        return isValid;
    }
}
