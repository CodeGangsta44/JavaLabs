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
    }
    @Override
    public void execute(){
        this.viewer.printString("Виконав Довгополюк Р.Р.(залікова книжка №8)\n");

        this.menu();

    }

    public void menu(){

        while (true) {
            this.viewer.printString("\nWhat do you want to do:\n");
            this.viewer.printString("1 - show all trains\n");
            this.viewer.printString("2 - make request\n");
            this.viewer.printString("3 - load trains from file\n");
            this.viewer.printString("4 - generate random trains\n");
            this.viewer.printString("5 - exit\n");

            int answer = new Scanner(System.in).nextInt();

            if (answer == 1) this.viewer.requestResponse(this.model.getAllInfo());
            if (answer == 2) makeRequest();
            if (answer == 3) readDataFromFile("./files/input.txt");
            if (answer == 4) this.model = new RailwayStationModel();
            if (answer == 5) break;

        }


    }

    public void makeRequest(){
        this.viewer.printString("\nWhat type of request do you want to do:\n");
        this.viewer.printString("1 - all trains that have seats\n");
        this.viewer.printString("2 - trains by destination and time\n");

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

    private void readDataFromFile(String path) {

        String data;

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

            this.model.receiveData(data);

        } catch (IOException e) {
            System.out.print("\nFile reading error!\n");
        }

    }
}
