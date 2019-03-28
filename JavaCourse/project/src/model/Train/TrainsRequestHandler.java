package model.Train;
import model.Time.Exceptions.TimeException;
import model.Time.Time;
import model.Train.Exceptions.*;

import java.util.Random;



public class TrainsRequestHandler {
    private String[] cities;
    private Train[] trains;

    public TrainsRequestHandler() {
        this.trains = new Train[15];
        //generateTrains(15);
    }

    public TrainsRequestHandler(int numberOfTrains) {
        this.trains = new Train[numberOfTrains];
    }

    public TrainsRequestHandler(String data) throws Exception {
        parseData(data);
    }

    private void parseData(String data) throws Exception {

        String[] trains = data.split("\n");
        this.trains = new Train[trains.length];
        for (int i = 0; i < trains.length; i++){

            try{
                String[] current = trains[i].split(",");
                String currDest = current[0];
                int currNum = Integer.parseInt(current[1]);
                Time currTime = new Time(current[2]);
                int[] currSeats = new int[]{Integer.parseInt(current[4]), Integer.parseInt(current[5]), Integer.parseInt(current[6])};
                this.trains[i] = new Train(currDest, currNum, currTime, currSeats);

            } catch (TimeException e) {
                ParseTrainException newExc = new ParseTrainException("Can`t parse row[" + i + "]: " + trains[i] + '\n');
                newExc.initCause(e);
                throw newExc;
            }
        }


    }

    public void generateTrains() {
        for (int i = 0; i < this.trains.length; i++){
            Random rand = new Random();
            String destination = cities[rand.nextInt(cities.length)];
            int number = rand.nextInt(100) + 1;
            Time departureTime = (new Time()).random();
            int[] seats = new int[]{rand.nextInt(80), rand.nextInt(100), rand.nextInt(20)};
            this.trains[i] = new Train(destination, number, departureTime, seats);
        }
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    public String[] getCities() {
        return this.cities;
    }

    public Train[] hasSeats() {
        int counter = 0;
        Train[] temp = new Train[this.trains.length];

        for (Train i:trains){
            if (i != null && i.getNumberOfSeats() > 0){
                temp[counter++] = i;
            }
        }

        Train[] result = new Train[counter];
        System.arraycopy(temp, 0, result, 0, counter);

        return result;
    }

    public Train[] hasDestAndTime(String destination, Time time) {
        int counter = 0;
        Train[] temp = new Train[this.trains.length];

        for (Train i:trains){
            if (i != null && i.getDestination().equals(destination) && i.getDepartureTime().afterThisTime(time)) {
                temp[counter++] = i;
            }
        }

        Train[] result = new Train[counter];
        System.arraycopy(temp, 0, result, 0, counter);

        return result;
    }

    public Train[] getAllTrains() {
        return this.trains;
    }

}
