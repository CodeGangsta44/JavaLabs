package controller.DataManager;

public class CSVDataManager implements DataManager<String> {

    public String[] readData(String path) {

        return FileManager.readFile(path).split("\n");
    }

    public void writeData(String path, String[] data) {

        FileManager.writeToFile(path, String.join("", data));
    }
}
