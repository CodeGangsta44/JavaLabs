package model.Train;

import model.Time.Time;

public class Train {
    private String destination;
    private int number;
    private Time departureTime;
    private int numberOfSeats;
    private int[] seats;

    public Train(String destination, int number, Time departureTime, int[] seats){
        this.destination = destination;
        this.number = number;
        this.departureTime = departureTime;
        this.numberOfSeats = seats[0] + seats[1] + seats[2];
        this.seats = seats;
    }

    public Train(){
        this.destination = "";
        this.number = 0;
        this.departureTime = new Time();
        this.numberOfSeats = 0;
        this.seats = new int[3];
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination(){
        return this.destination;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public void setDepartureTime(Time departureTime){
        this.departureTime = departureTime;
    }

    public Time getDepartureTime(){
        return this.departureTime;
    }

    public void setNumberOfSeats(int numberOfSeats){
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats(){
        return this.numberOfSeats;
    }

    public void setSeats(int[] seats){
        this.seats = seats;
    }

    public int[] getSeats(){
        return this.seats;
    }

    public String toString(){

        StringBuilder result = new StringBuilder();

        result.append(String.format("|%-20s", this.destination));
        result.append(String.format("|%-10s", this.number));
        result.append(String.format("|%-20s", this.departureTime.toString()));
        result.append(String.format("|%-10s", this.numberOfSeats));

        for (int i:this.seats) result.append(String.format("|%-10s", i));

        result.append("|\n");

        return result.toString();
    }

    public String toComaSeparetedValuesString(){
        StringBuilder result = new StringBuilder();

        result.append(String.format("%s,", this.destination));
        result.append(String.format("%s,", this.number));
        result.append(String.format("%s,", this.departureTime.toString()));
        result.append(String.format("%s,", this.numberOfSeats));

        for (int i:this.seats) {
            result.append(String.format("%s,", i));
        }

        result.deleteCharAt(result.length() - 1);

        result.append("\n");

        return result.toString();
    }
}
