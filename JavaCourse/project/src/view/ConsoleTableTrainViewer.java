package view;
import model.Train.Train;

public class ConsoleTableTrainViewer implements Viewer<Train> {
    @Override
    public void printString(String string){
        System.out.print(string);
    }

    public void requestResponse(Train[] trains){
        if (trains.length == 0) System.out.println("\nNo trains found that match your request.\n");
        else  System.out.println("\nList of trains satisfying your request:\n" + getStringOfCollection(trains));
    }

    private String getStringOfCollection(Train[] trains) {
        StringBuilder result = createHeader();

        for (Train i:trains) result.append(i);

        return result.toString();
    }

    private StringBuilder createHeader(){
        StringBuilder header = new StringBuilder();
        header.append(String.format("|%-20s", "Destination:"));
        header.append(String.format("|%-10s", "Number:"));
        header.append(String.format("|%-20s", "Departure time:"));
        header.append(String.format("|%-10s", "Seats:"));
        header.append(String.format("|%-10s", "Coupe:"));
        header.append(String.format("|%-10s", "P-card:"));
        header.append(String.format("|%-10s", "Premium:"));
        header.append("|\n");

        int headerLength = header.length();
        for (int i = 1; i < headerLength; i++) header.append('-');

        header.append("\n");

        return header;
    }
}
