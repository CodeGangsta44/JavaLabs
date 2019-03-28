package com.company;
import lab03.Train;
import lab03.TrainsRequestHandler;
import lab03.TrainsCollection;
import lab03.Time;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TrainsRequestHandler handler = new TrainsRequestHandler();

        TrainsCollection allTrains = new TrainsCollection(handler.getAllTrains());

        System.out.println("All trains:");

        allTrains.showInformation();

        TrainsCollection reqCollection = new TrainsCollection(handler.makeRequest());

        reqCollection.reqResponse();
    }
}
