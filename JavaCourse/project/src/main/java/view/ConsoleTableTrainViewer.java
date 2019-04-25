package view;
import model.Train.Train;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleTableTrainViewer implements Viewer<Train> {
    private final Logger logger = LogManager.getLogger("viewerLogger");
    @Override
    public void printString(String string){
        this.logger.trace("Viewer printing string: " + string + "\n");
        System.out.print(string);
    }

    public void requestResponse(Train[] trains){
        this.logger.trace("Viewer received resulting collection of trains");
        if (trains.length == 0) System.out.println("\nNo trains found that match your request.\n");
        else  this.printString("\nList of trains satisfying your request:\n" + getStringOfCollection(trains));
    }

    private String getStringOfCollection(Train[] trains) {
        this.logger.trace("Viewer casting collection to string");
        StringBuilder result = createHeader();

        for (Train i:trains) result.append(i);

        return result.toString();
    }

    private StringBuilder createHeader(){
        this.logger.trace("Viewer generating table header for resulting collection");

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
