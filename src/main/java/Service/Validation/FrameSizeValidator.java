package main.java.Service.Validation;

import main.java.Interface.IValidator;
import main.java.Model.ScoringFrame;

import java.util.List;

public class FrameSizeValidator implements IValidator<ScoringFrame> {

    @Override
    public boolean validate(List<ScoringFrame> bowlerInputData) {
        return bowlerInputData.size() == 11 ? true : false;
    }
}
