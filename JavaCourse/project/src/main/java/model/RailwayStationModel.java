package model;

import model.Time.Exceptions.TimeException;
import model.Time.Time;
import model.Train.Train;
import model.Train.TrainsRequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RailwayStationModel implements Model<Train>{
    private TrainsRequestHandler handler;
    private final Logger logger = LogManager.getLogger("modelLogger");

    public RailwayStationModel(){
        handler = new TrainsRequestHandler();
    }

    @Override
    public void receiveData(Train[] data) {
        this.logger.trace("Request handler received data");
        this.handler = new TrainsRequestHandler(data);
    }
    @Override
    public Train[] getAllInfo() {
        this.logger.trace("Request handler returned all trains");
        return handler.getAllTrains();
    }

    @Override
    public Train[] makeRequest() {
        this.logger.trace("Request handler returned all trains with seats");
        return handler.hasSeats();
    }

    public Train[] makeRequest(String destination, String time) throws TimeException {
        this.logger.trace("Request handler returned all trains by destination and time");
        return handler.hasDestAndTime(destination, new Time(time));
    }

    public void setCities(String[] cities){
        this.logger.info("Request handler received list of cities");
        this.handler.setCities(cities);
    }

    public void generateTrains() {
        this.logger.trace("Request handler generating random trains");
        this.handler.generateTrains();
    }

}
