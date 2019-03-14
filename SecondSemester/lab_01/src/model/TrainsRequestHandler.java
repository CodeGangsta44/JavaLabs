package model;
import java.util.Random;



public class TrainsRequestHandler {
    private String[] cities = {"Lutsk", "Kyiv", "Rivne", "Lviv", "Mykolaiv", "Cherkasy", "Vinnytsia"};
    private Train[] trains;

    public TrainsRequestHandler(){
        this.trains = new Train[15];
        //generateTrains(15);
    }

    public TrainsRequestHandler(int numberOfTrains){
        this.trains = new Train[numberOfTrains];
        //generateTrains(numberOfTrains);
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

    public void generateTrains(){
        for (int i = 0; i < this.trains.length; i++){
            Random rand = new Random();
            String destination = cities[rand.nextInt(cities.length)];
            int number = rand.nextInt(100) + 1;
            Time departureTime = new Time(rand.nextInt(24), rand.nextInt(60));
            int[] seats = new int[]{rand.nextInt(80), rand.nextInt(100), rand.nextInt(20)};
            this.trains[i] = new Train(destination, number, departureTime, seats);
        }
    }

    public void setCities(String[] cities){
        this.cities = cities;
    }

    public String[] getCities() {
        return this.cities;
    }

    public Train[] hasSeats(){
        int counter = 0;
        for (Train i:trains){
            if (i.getNumberOfSeats() > 0) counter++;
        }

        Train[] result = new Train[counter];

        for (Train i:trains){
            if (i.getNumberOfSeats() > 0) result[--counter] = i;
        }
        return result;
    }

    public Train[] hasDestAndTime(String destination, Time time){
        int counter = 0;

        for (Train i:trains){
            if (i.getDestination().equals(destination) && i.getDepartureTime().afterThisTime(time)) counter++;
        }

        Train[] result = new Train[counter];

        for (Train i:trains){
            if (i.getDestination().equals(destination) && i.getDepartureTime().afterThisTime(time)) result[--counter] = i;
        }

        return result;
    }

    public Train[] getAllTrains(){
        return this.trains;
    }

}
