package controller.DataManager;

import java.io.*;

public class FileManager {
    public static String readFile(String path){
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

        } catch (IOException e) {
            System.out.print("\nFile reading error!\n");
        }

        return data;
    }

    public static void writeToFile(String path, String data){
        try{
            FileWriter writer = new FileWriter(path, false);

            writer.write(data);
            writer.flush();
            writer.close();

        } catch(IOException e){
            System.out.print("\nFile writing error!\n");
        }
    }
}
