package lab03;

public class TrainsCollection {
    private Train[] trains;
    public TrainsCollection(Train[] trains){
        this.trains = trains;
    }

    public void reqResponse(){
        if (this.trains.length == 0) System.out.println("\nNo trains found that match your request.");
        else {
            System.out.println("\nList of trains satisfying your request:");
            showInformation();
        }
    }

    public void showInformation(){
        StringBuilder header = new StringBuilder();
        header.append(String.format("%-20s", "Destination:"));
        header.append(String.format("%-10s", "Number:"));
        header.append(String.format("%-20s", "Departure time:"));
        header.append(String.format("%-10s", "Seats:"));
        header.append(String.format("%-10s", "Coupe:"));
        header.append(String.format("%-10s", "P-card:"));
        header.append(String.format("%-10s", "Premium:"));


        System.out.println(header.toString());
        for (Train i:this.trains){
            System.out.println(i);
        }
    }
}
