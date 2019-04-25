package controller;
import controller.DataManager.*;
import model.RailwayStationModel;
import model.Time.Exceptions.TimeException;
import model.Train.Exceptions.TrainException;
import model.Train.*;
import view.ConsoleTableTrainViewer;
import view.ConsoleColors;
import org.apache.logging.log4j.*;

public class ConsoleController implements Controller {

    private ConsoleTableTrainViewer viewer;
    private RailwayStationModel model;
    private ConsoleReader reader;
    private DataManager<Train> CSVmanager;
    private DataManager<Train> JSONmanager;
    private String fileFromat;
    private final String PATH = "./files/Trains";
    private final Logger logger = LogManager.getLogger("controllerLogger");


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
        this.logger.info("Starting execution of program");
        this.viewer.printString(ConsoleColors.ANSI_WHITE);

        this.viewer.printString("Виконав Довгополюк Р.Р.(залікова книжка №8)\n");

        this.menu();

    }

    @Override
    public void menu() {
        this.logger.info("Starting menu loop");

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
            this.logger.info("Printed menu");

            try{

                int answer = this.reader.readInt();
                this.logger.trace("User entered: " + answer);

                switch (answer) {
                    case 1:
                        this.logger.trace("Printing all trains");
                        this.viewer.requestResponse(this.model.getAllInfo());
                        break;
                    case 2:
                        this.logger.trace("Making request");
                        makeRequest();
                        break;
                    case 3:
                        this.logger.trace("Loading trains from file");
                        this.loadData();
                        break;
                    case 4:
                        this.logger.trace("Generating random trains");
                        this.model.generateTrains();
                        break;
                    case 5:
                        this.logger.trace("Changing file format");
                        this.changeFileFormat();
                        break;
                    case 6:
                        this.logger.trace("Shutdown");
                        this.saveData();
                        break menuLoop;
                }
            } catch (TrainException | TimeException e) {
                this.logger.error("Exception: ", e);
                this.viewer.printString(e.toString());
                if (e.getCause() != null){
                    this.viewer.printString("\nReason:\n");
                    this.viewer.printString(e.getCause().toString());
                }
            } catch (Exception e) {
                this.logger.error("Exception: ", e);
                this.reader.resetReader();
                this.viewer.printString("\nUnrecognized input!\n" +
                                        "Please, try again.\n");
            }

        }


    }

    @Override
    public void makeRequest() {

        this.logger.trace("Entering requests menu");
        this.viewer.printString("\nWhat type of request do you want to do:\n" +
                "1 - all trains that have seats\n" +
                "2 - trains by destination and time\n");

        int answer = this.reader.readInt();

        if (answer == 1){
            this.logger.trace("Getting all trains with seats");
            this.viewer.requestResponse(this.model.makeRequest());
        }
        if (answer == 2) {

            this.logger.trace("Getting all trains by destination and time");
            while (true) {
                this.viewer.printString("\nPlease, enter destination: ");
                String destination = this.reader.readString();

                this.viewer.printString("Please, enter time: ");
                String time = this.reader.readString();


                try {
                    this.viewer.requestResponse(this.model.makeRequest(destination, time));
                    break;
                } catch (TimeException e) {
                    this.logger.error("Exception: ", e);
                    this.viewer.printString(e.toString());
                }
            }

        }
    }

    @Override
    public void loadData() throws Exception {
        this.logger.info("Loading trains from file");

        if (this.fileFromat.equals("csv")) {
            this.model.receiveData(this.CSVmanager.readData(this.PATH + '.' + this.fileFromat));
        }

        if (this.fileFromat.equals("json")) {
            this.model.receiveData(this.JSONmanager.readData(this.PATH + '.' + this.fileFromat));
        }
    }

    @Override
    public void saveData() {
        this.logger.info("Saving trains to file");

        if (this.fileFromat.equals("csv")) {
            this.CSVmanager.writeData(this.PATH + '.' + this.fileFromat, this.model.getAllInfo());
        }

        if (this.fileFromat.equals("json")) {
            this.JSONmanager.writeData(this.PATH + '.' + this.fileFromat, this.model.getAllInfo());
        }
    }

    private void changeFileFormat(){
        this.logger.trace("Entering file format menu");

        this.viewer.printString("\nIn what format of file you would like to save data:\n" +
                "1 - csv\n" +
                "2 - json\n");

        int answer = this.reader.readInt();

        if (answer == 1){
            this.logger.info("File format set CSV");
            this.fileFromat = "csv";
        }
        if (answer == 2){
            this.logger.info("File format set JSON");
            this.fileFromat = "json";
        }
    }
}

