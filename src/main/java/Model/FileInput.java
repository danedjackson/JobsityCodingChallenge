package main.java.Model;

public class FileInput {
    private String name;
    private String pinfall;

    public FileInput(String name, String pinfall) {
        this.name = name;
        this.pinfall = pinfall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinfall() {
        return pinfall;
    }

    public void setPinfall(String pinfall) {
        this.pinfall = pinfall;
    }

    @Override
    public String toString() {
        return "FileInput{" +
                "name='" + name + '\'' +
                ", pinfall='" + pinfall + '\'' +
                '}';
    }
}
