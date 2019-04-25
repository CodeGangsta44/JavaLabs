package controller.DataManager;

import model.Time.Exceptions.TimeException;
import model.Time.Time;
import model.Train.Exceptions.ParseTrainException;
import model.Train.Train;

public class CSVDataManager implements DataManager<Train> {

    public Train[] readData(String path) throws Exception{

        return this.parseData(FileManager.readFile(path).split("\n"));
    }

    public void writeData(String path, Train[] data) {

        FileManager.writeToFile(path, String.join("", this.trainToCsv(data)));
    }

    private Train[] parseData(String[] trains) throws Exception{
        Train[] result = new Train[trains.length];
        for (int i = 0; i < trains.length; i++){

            try{
                String[] current = trains[i].split(",");
                String currDest = current[0];
                int currNum = Integer.parseInt(current[1]);
                Time currTime = new Time(current[2]);
                int[] currSeats = new int[]{Integer.parseInt(current[4]), Integer.parseInt(current[5]), Integer.parseInt(current[6])};
                result[i] = new Train(currDest, currNum, currTime, currSeats);

            } catch (TimeException e) {
                ParseTrainException newExc = new ParseTrainException("Can`t parse row[" + i + "]: " + trains[i] + '\n');
                newExc.initCause(e);
                throw newExc;
            }
        }

        return result;
    }

    public String[] trainToCsv(Train[] trains){
        int counter = 0;
        Train[] temp = new Train[trains.length];

        for (Train i:trains){
            if (i != null) {
                temp[counter++] = i;
            }
        }

        String[] result = new String[counter];

        for (int i = 0; i < counter; i++)
            result[i] = temp[i].toComaSeparetedValuesString();

        return result;
    }
}
