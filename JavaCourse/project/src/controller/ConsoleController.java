package controller;

import model.RailwayStationModel;
import model.Time.Exceptions.TimeException;
import model.Train.Exceptions.TrainException;
import view.ConsoleTableTrainViewer;
import view.ConsoleColors;

public class ConsoleController implements Controller {

    private ConsoleTableTrainViewer viewer;
    private RailwayStationModel model;
    private ConsoleReader reader;

    public ConsoleController() {
        this.viewer = new ConsoleTableTrainViewer();
        this.model = new RailwayStationModel();
        this.reader = new ConsoleReader();
        this.model.setCities(this.reader.readFromFile("./files/inputCities.txt").split("\n"));
    }

    @Override
    public void execute() {
        this.viewer.printString(ConsoleColors.ANSI_WHITE);

        this.viewer.printString("Виконав Довгополюк Р.Р.(залікова книжка №8)\n");

        this.menu();

    }

    @Override
    public void menu() {

        String menu = "\nWhat do you want to do:\n" +
                "1 - show all trains\n" +
                "2 - make request\n" +
                "3 - load trains from file\n" +
                "4 - generate random trains\n" +
                "5 - exit\n";

        menuLoop:
        while (true) {
            this.viewer.printString(menu);

            try{

                int answer = this.reader.readInt();

                switch (answer) {
                    case 1:
                        this.viewer.requestResponse(this.model.getAllInfo());
                        break;
                    case 2:
                        makeRequest();
                        break;
                    case 3:
                        this.model.receiveData(this.reader.readFromFile("./files/inputTrains.txt"));
                        break;
                    case 4:
                        this.model.generateTrains();
                        break;
                    case 5:
                        break menuLoop;
                }
            } catch (TrainException | TimeException e) {
                this.viewer.printString(e.toString());
                if (e.getCause() != null){
                    this.viewer.printString("\nReason:\n");
                    this.viewer.printString(e.getCause().toString());
                }
            } catch (Exception e) {
                this.reader.resetReader();
            }

        }


    }

    @Override
    public void makeRequest() {
        this.viewer.printString("\nWhat type of request do you want to do:\n" +
                "1 - all trains that have seats\n" +
                "2 - trains by destination and time\n");

        int answer = this.reader.readInt();

        if (answer == 1) this.viewer.requestResponse(this.model.makeRequest());
        if (answer == 2) {

            while (true) {
                this.viewer.printString("\nPlease, enter destination: ");
                String destination = this.reader.readString();

                this.viewer.printString("Please, enter time: ");
                String time = this.reader.readString();


                try {
                    this.viewer.requestResponse(this.model.makeRequest(destination, time));
                    break;
                } catch (TimeException e) {
                    this.viewer.printString(e.toString());
                }
            }

        }
    }
}

