package main.java.Service.Validation;

import main.java.Interface.IValidator;
import main.java.Model.ScoringFrame;

import java.util.List;

public class FrameSizeValidator implements IValidator<ScoringFrame> {

    @Override
    public boolean validate(List<ScoringFrame> bowlerInputData) {
        if (bowlerInputData.size() == 11) {
            return true;
        } else {
            System.out.println("Incorrect number of scores provided.");
            return false;
        }
    }
}
