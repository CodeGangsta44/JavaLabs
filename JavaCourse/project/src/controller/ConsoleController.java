package controller;
import controller.DataManager.*;
import model.RailwayStationModel;
import model.Time.Exceptions.TimeException;
import model.Train.Exceptions.TrainException;
import model.Train.*;
import view.ConsoleTableTrainViewer;
import view.ConsoleColors;

public class ConsoleController implements Controller {

    private ConsoleTableTrainViewer viewer;
    private RailwayStationModel model;
    private ConsoleReader reader;
    private DataManager<String> CSVmanager;
    private DataManager<Train> JSONmanager;
    private String fileFromat;
    private final String PATH = "./files/Trains";


    public ConsoleController() {
        this.viewer = new ConsoleTableTrainViewer();
        this.model = new RailwayStationModel();
        this.reader = new ConsoleReader();
        this.CSVmanager = new CSVDataManager();
        this.JSONmanager = new JSONDataManager();
        this.model.setCities(FileManager.readFile("./files/inputCities.txt").split("\n"));
        this.fileFromat = "csv";
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
                "5 - change file format\n" +
                "6 - exit\n";

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
                        this.loadData();
                        break;
                    case 4:
                        this.model.generateTrains();
                        break;
                    case 5:
                        this.changeFileFormat();
                        break;
                    case 6:
                        this.saveData();
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
                this.viewer.printString("\nUnrecognized input!\n" +
                                        "Please, try again.\n");
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

    @Override
    public void loadData() throws Exception {
        if (this.fileFromat.equals("csv")) {
            this.model.receiveData(this.CSVmanager.readData(this.PATH + '.' + this.fileFromat));
        }

        if (this.fileFromat.equals("json")) {
            this.model.receiveData(this.JSONmanager.readData(this.PATH + '.' + this.fileFromat));
        }
    }

    @Override
    public void saveData() {
        if (this.fileFromat.equals("csv")) {
            this.CSVmanager.writeData(this.PATH + '.' + this.fileFromat, this.model.getAllInfoInCSV());
        }

        if (this.fileFromat.equals("json")) {
            this.JSONmanager.writeData(this.PATH + '.' + this.fileFromat, this.model.getAllInfo());
        }
    }

    private void changeFileFormat(){
        this.viewer.printString("\nIn what format of file you would like to save data:\n" +
                "1 - csv\n" +
                "2 - json\n");

        int answer = this.reader.readInt();

        if (answer == 1) this.fileFromat = "csv";
        if (answer == 2) this.fileFromat = "json";
    }
}

