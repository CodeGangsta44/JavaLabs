package model.Train.Exceptions;

import view.ConsoleColors;

public class TrainException extends Exception {
    public TrainException(String message){
        super(message);
    }
    public String toString(){
        return '\n' + ConsoleColors.ANSI_RED + "EXCEPTION\n"
                + ConsoleColors.ANSI_WHITE + "This is an exception related to train.\n"
                + ConsoleColors.ANSI_YELLOW + "Specification: " + ConsoleColors.ANSI_RESET;
    }
}
