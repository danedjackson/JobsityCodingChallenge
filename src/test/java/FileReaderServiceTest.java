package test.java;
import main.java.Service.FileReaderService;
import org.junit.jupiter.api.Test;
public class FileReaderServiceTest {

    @Test
    void scoreFileHasData() {
        FileReaderService fileReaderService =
                new FileReaderService("C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\positive\\scores.txt");
        assert fileReaderService.readRawData().size() > 0;
    }

    @Test
    void emptyFileHasNoData() {

        FileReaderService fileReaderService =
                new FileReaderService("C:\\Users\\Dane\\Documents\\Projects\\Jobsity\\JavaChallenge\\src\\test\\resources\\negative\\empty.txt");
        assert fileReaderService.readRawData().size() == 0;
    }
}
