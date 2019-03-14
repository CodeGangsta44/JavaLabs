package model;

public class RailwayStationModel implements Model<Train>{
    private TrainsRequestHandler handler;

    public RailwayStationModel(){
        handler = new TrainsRequestHandler();
    }

    @Override
    public void receiveData(String data){
        this.handler = new TrainsRequestHandler(data);
    }

    public Train[] getAllInfo() {
        return handler.getAllTrains();
    }

    public Train[] makeRequest() {
        return handler.hasSeats();
    }

    public Train[] makeRequest(String destination, String time) {
        return handler.hasDestAndTime(destination, new Time(time));
    }

}
