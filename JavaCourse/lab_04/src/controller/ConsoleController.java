package controller;

import controller.Reader.ConsoleReader;
import model.ListModel;
import viewer.ConsoleViewer;

public class ConsoleController {
    private ListModel model;
    private ConsoleViewer viewer;
    private ConsoleReader reader;

    public ConsoleController(){
        this.model = new ListModel(10, 2);
        this.viewer = new ConsoleViewer();
        this.reader = new ConsoleReader();
    }

    public void execute(){
        this.model.createAndFillLists();
        this.menu();
    }

    private void menu(){
        String menu = "\nWhat do you want to do:\n" +
                "1 - show lists\n" +
                "2 - generate new lists\n" +
                "3 - move lists\n" +
                "4 - change parameters\n" +
                "5 - exit\n";
        menuLoop:
        while (true) {
            this.viewer.printString(menu);
            try{

                int answer = this.reader.readInt();

                switch (answer) {
                    case 1:
                        this.viewer.printString(this.model.toString());
                        break;
                    case 2:
                        this.model.createAndFillLists();
                        break;
                    case 3:
                        this.viewer.printString(this.model.moveLists());
                        break;
                    case 4:
                        this.viewer.printString("Please, input length of lists:");
                        int length = this.reader.readInt();
                        this.viewer.printString("Please, input N:");
                        int N = this.reader.readInt();

                        this.model = new ListModel(length, N);
                        this.model.createAndFillLists();
                        break;
                    case 5:
                        break menuLoop;
                }
            } catch (Exception e) {
                this.reader.resetReader();
                this.viewer.printString("\nUnrecognized input!\n" +
                        "Please, try again.\n");
            }

        }


    }

}
