package controller.Reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private Scanner scanner;
    public ConsoleReader(){
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int readInt() {
        return this.scanner.nextInt();
    }

    @Override
    public String readString() {
        return this.scanner.next();
    }

    @Override
    public void resetReader() {
        this.scanner.nextLine();
    }

}
