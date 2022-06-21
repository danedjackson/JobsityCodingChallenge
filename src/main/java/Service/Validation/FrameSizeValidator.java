package main.java.Service.Validation;

import main.java.Interface.IValidator;
import main.java.Model.ScoringFrame;

import java.util.List;

public class FrameSizeValidator implements IValidator<ScoringFrame> {
    //Frame size is equal to 11 to facilitate the last element of the 10th frame.
    static final Integer MAX_FRAME_SIZE = 11;

    @Override
    public boolean validate(List<ScoringFrame> bowlerInputData) {
        if (bowlerInputData.size() == MAX_FRAME_SIZE) {
            return true;
        } else {
            System.out.println("Incorrect number of scores provided.");
            return false;
        }
    }
}
