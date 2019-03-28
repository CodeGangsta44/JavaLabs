package model.Time.Exceptions;

import view.ConsoleColors;

public class TimeRangeException extends TimeException {
    private int input;
    public TimeRangeException(int input, String message){
        super(message);
        this.input = input;
    }
    public String toString(){
        String answer = super.toString()
                + "time range exception\n"
                + ConsoleColors.ANSI_RED + super.getMessage()
                + ConsoleColors.ANSI_WHITE + "\nYour input: "
                + ConsoleColors.ANSI_CYAN + this.input
                + '\n' + ConsoleColors.ANSI_RESET;

        return answer;
    }
}
