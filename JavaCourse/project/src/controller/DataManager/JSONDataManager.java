
package controller.DataManager;

import model.Train.Train;
import com.google.gson.*;

public class JSONDataManager implements DataManager<Train> {

    public Train[] readData(String path){
        Gson gson = new Gson();
        return gson.fromJson(FileManager.readFile(path), Train[].class);
    }

    public void writeData(String path, Train[] data){
        Gson gson = new Gson();
        FileManager.writeToFile(path, gson.toJson(data));
    }
}
