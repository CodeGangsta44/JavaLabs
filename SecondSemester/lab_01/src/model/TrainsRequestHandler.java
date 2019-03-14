package model;
import java.util.Random;
import java.util.ArrayList;



public class TrainsRequestHandler {
    private String[] cities = {"Lutsk", "Kyiv", "Rivne", "Lviv", "Mykolaiv", "Cherkasy", "Vinnytsia"};
    private Train[] trains;

    public TrainsRequestHandler(){
        this.trains = new Train[15];
        generateTrains(15);
    }

    public TrainsRequestHandler(int numberOfTrains){
        this.trains = new Train[numberOfTrains];
        generateTrains(numberOfTrains);
    }

    public TrainsRequestHandler(String data){
        parseData(data);
    }

    private void parseData(String data) {
        String[] trains = data.split("\n");
        this.trains = new Train[trains.length];
        for (int i = 0; i < trains.length; i++){
            String[] current = trains[i].split(",");
            String currDest = current[0];
            int currNum = Integer.parseInt(current[1]);
            Time currTime = new Time(current[2]);
            int[] currSeats = new int[]{Integer.parseInt(current[4]), Integer.parseInt(current[5]), Integer.parseInt(current[6])};
            this.trains[i] = new Train(currDest, currNum, currTime, currSeats);
        }

    }

    private void generateTrains(int numberOfTrains){
        for (int i = 0; i < numberOfTrains; i++){
            Random rand = new Random();
            String destination = cities[rand.nextInt(cities.length)];
            int number = rand.nextInt(100) + 1;
            Time departureTime = new Time(rand.nextInt(24), rand.nextInt(60));
            int[] seats = new int[]{rand.nextInt(80), rand.nextInt(100), rand.nextInt(20)};
            this.trains[i] = new Train(destination, number, departureTime, seats);
        }
    }

    public Train[] hasSeats(){
        ArrayList<Train> result = new ArrayList<Train>();
        for (Train i:trains){
            if (i.getNumberOfSeats() > 0) result.add(i);
        }
        Train[] arrResult = new Train[result.size()];
        return result.toArray(arrResult);
    }

    public Train[] hasDestAndTime(String destination, Time time){
        ArrayList<Train> result = new ArrayList<Train>();
        for (Train i:trains){
            if (i.getDestination().equals(destination) && i.getDepartureTime().afterThisTime(time)) result.add(i);
        }
        Train[] arrResult = new Train[result.size()];
        return result.toArray(arrResult);
    }

    public Train[] getAllTrains(){
        return this.trains;
    }

}
