package model.Train.Exceptions;

import view.ConsoleColors;

public class ParseTrainException extends TrainException {
    public ParseTrainException(String message){
        super(message);
    }
    public String toString(){
        String answer = super.toString()
                + "parse train exception\n"
                + ConsoleColors.ANSI_RED + super.getMessage()
                + ConsoleColors.ANSI_RESET;

        return answer;
    }
}
