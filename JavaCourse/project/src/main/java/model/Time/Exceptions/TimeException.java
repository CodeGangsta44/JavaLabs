package model.Time.Exceptions;
import view.ConsoleColors;

public class TimeException extends Exception {
    public TimeException(String message){
        super(message);
    }
    public String toString(){
        return '\n' + ConsoleColors.ANSI_RED + "EXCEPTION\n"
                + ConsoleColors.ANSI_WHITE + "This is an exception related to time.\n"
                + ConsoleColors.ANSI_YELLOW + "Specification: " + ConsoleColors.ANSI_RESET;
    }
}
