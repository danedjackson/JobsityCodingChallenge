package main.java.Interface;

import main.java.Model.FileInput;

import java.util.List;

public interface IValidator<T> {
    boolean validate(List<T> input);
}
