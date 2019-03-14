package lab03;
import lab03.Train;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainsRequestHandler {
    private String[] cities = {"Lutsk", "Kyiv", "Rivne", "Lviv", "Mykolaiv", "Cherkasy", "Vinnytsia"};
    private int numberOfTrains;
    private Train[] trains;

    public TrainsRequestHandler(){
        this.numberOfTrains = 15;
        this.trains = new Train[15];
        generateTrains();
    }

    public TrainsRequestHandler(int numberOfTrains){
        this.numberOfTrains = numberOfTrains;
        this.trains = new Train[numberOfTrains];
        generateTrains();
    }

    private void generateTrains(){
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

    public Train[] hasDestAndTime(){

        Scanner input = new Scanner(System.in);

        System.out.print("\nPlease, enter destination: ");
        String destination = input.next();

        System.out.print("Please, enter time: ");
        String time = input.next();

        return hasDestAndTime(destination, new Time(time));
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

    public Train[] makeRequest(){

        System.out.println("\nWhat kind of request do you want to do:");
        System.out.println("1 - all trains that have seats");
        System.out.println("2 - trains by destination and time");

        int answer = new Scanner(System.in).nextInt();


        if (answer == 1) return hasSeats();
        if (answer == 2) return hasDestAndTime();

        return new Train[0];

    }

    public void print(){
        for (int i = 0; i < numberOfTrains; i++){
            System.out.println(trains[i]);
        }
    }
}
