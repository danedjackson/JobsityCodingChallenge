package main.java.Interface;

import java.util.List;

public interface IValidator<T> {
    boolean validate(List<T> input);
}
