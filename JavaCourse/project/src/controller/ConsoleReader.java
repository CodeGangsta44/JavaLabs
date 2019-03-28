package controller;

import java.io.*;
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

    @Override
    public String readFromFile(String path) {
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
