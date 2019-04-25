package model.Time.Exceptions;
import view.ConsoleColors;

public class TimeFormatException extends TimeException {
    private String input;
    public TimeFormatException(String input, String message){
        super(message);
        this.input = input;
    }
    public String toString(){
        String answer = super.toString()
                + "time format exception\n"
                + ConsoleColors.ANSI_RED + super.getMessage()
                + ConsoleColors.ANSI_WHITE + "\nYour input: "
                + ConsoleColors.ANSI_CYAN + this.input
                + '\n' + ConsoleColors.ANSI_RESET;

        return answer;
    }
}
