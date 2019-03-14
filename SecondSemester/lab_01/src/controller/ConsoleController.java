package controller;

import model.RailwayStationModel;
import view.ConsoleTableTrainViewer;

import java.io.*;
import java.util.Scanner;

public class ConsoleController implements Controller{

    private ConsoleTableTrainViewer viewer;
    private RailwayStationModel model;

    public ConsoleController(){
        this.viewer = new ConsoleTableTrainViewer();
        this.model = new RailwayStationModel();
        this.model.setCities(readDataFromFile("./files/inputCities.txt").split("\n"));
    }

    @Override
    public void execute(){
        this.viewer.printString("Виконав Довгополюк Р.Р.(залікова книжка №8)\n");

        this.menu();

    }

    @Override
    public void menu(){

        String menu = "\nWhat do you want to do:\n" +
                      "1 - show all trains\n" +
                      "2 - make request\n" +
                      "3 - load trains from file\n" +
                      "4 - generate random trains\n" +
                      "5 - exit\n";

        menuLoop: while (true) {
            this.viewer.printString(menu);

            int answer = new Scanner(System.in).nextInt();

            switch  (answer) {
                case 1: this.viewer.requestResponse(this.model.getAllInfo()); break;
                case 2: makeRequest(); break;
                case 3: this.model.receiveData(readDataFromFile("./files/inputTrains.txt"));; break;
                case 4: this.model.generateTrains(); break;
                case 5: break menuLoop;
            }
        }


    }

    @Override
    public void makeRequest(){
        this.viewer.printString("\nWhat type of request do you want to do:\n" +
                                "1 - all trains that have seats\n" +
                                "2 - trains by destination and time\n");

        int answer = new Scanner(System.in).nextInt();

        if (answer == 1) this.viewer.requestResponse(this.model.makeRequest());
        if (answer == 2) {
            Scanner input = new Scanner(System.in);

            this.viewer.printString("\nPlease, enter destination: ");
            String destination = input.next();

            this.viewer.printString("Please, enter time: ");
            String time = input.next();


            this.viewer.requestResponse(this.model.makeRequest(destination, time));
        }
    }

    private String readDataFromFile(String path) {

        String data = "";

        try {
            InputStream is = new FileInputStream(path);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            data = sb.toString();

            return data;

        } catch (IOException e) {
            System.out.print("\nFile reading error!\n");
        }

        return data;

    }
}
