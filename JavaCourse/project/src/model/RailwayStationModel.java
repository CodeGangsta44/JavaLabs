package model;

import model.Time.Exceptions.TimeException;
import model.Time.Time;
import model.Train.Train;
import model.Train.TrainsRequestHandler;

public class RailwayStationModel implements Model<Train>{
    private TrainsRequestHandler handler;

    public RailwayStationModel(){
        handler = new TrainsRequestHandler();
    }

    @Override
    public void receiveData(String data) throws Exception {
        this.handler = new TrainsRequestHandler(data);
    }

    @Override
    public Train[] getAllInfo() {
        return handler.getAllTrains();
    }

    @Override
    public Train[] makeRequest() {
        return handler.hasSeats();
    }

    public Train[] makeRequest(String destination, String time) throws TimeException {
        return handler.hasDestAndTime(destination, new Time(time));
    }

    public void setCities(String[] cities){
        this.handler.setCities(cities);
    }

    public void generateTrains() {
        this.handler.generateTrains();
    }

}
