package model;

import model.DoubleLinkedCircularList.DoubleLinkedCircularList;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class ListModel {
    private int lengthOfLists;
    private int N;

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private DoubleLinkedCircularList<Integer> myList;


    public ListModel(int lengthOfLists, int N){
        this.lengthOfLists = lengthOfLists;
        this.N = N;
    }

    public void createAndFillLists(){
        Random rand = new Random();

        this.arrayList = new ArrayList<>();
        this.linkedList = new LinkedList<>();
        this.myList = new DoubleLinkedCircularList<>();

        for (int i = 0; i < this.lengthOfLists; i++) {
            int temp = rand.nextInt(100);

            this.arrayList.add(temp);
            this.linkedList.add(temp);
            this.myList.addLast(temp);
        }
    }

    public String moveLists(){
        StringBuilder result = new StringBuilder();

        result.append("\nArrayList\n" + "Initial state:\n");
        result.append(this.arrayList);
        long timeStamp = System.nanoTime();
        this.moveArrayList();
        result.append("\nAfter move:\n");
        result.append(this.arrayList);
        result.append("\nTime: " + (System.nanoTime() - timeStamp) + " nanoseconds\n");

        result.append("\nLinkedList\n" + "Initial state:\n");
        result.append(this.linkedList);
        timeStamp = System.nanoTime();
        this.moveLinkedList();
        result.append("\nAfter move:\n");
        result.append(this.linkedList);
        result.append("\nTime: " + (System.nanoTime() - timeStamp) + " nanoseconds\n");

        result.append("\nDoubleLinkedCircularList\n" + "Initial state:\n");
        result.append(this.myList);
        timeStamp = System.nanoTime();
        this.moveMyList();
        result.append("\nAfter move:\n");
        result.append(this.myList);
        result.append("\nTime: " + (System.nanoTime() - timeStamp) + " nanoseconds\n");

        return result.toString();
    }

    private void moveArrayList(){

        List<Integer> temp = this.arrayList.subList(this.lengthOfLists - this.N, this.lengthOfLists);
        this.arrayList.addAll(0, temp);

        for (int i = 0; i < this.N; i++){
            this.arrayList.remove(this.arrayList.size() - 1);
        }

        //        for(int i = 0; i < this.N; i++){
//            int temp = this.arrayList.get(this.lengthOfLists - 1);
//            for (int j = this.lengthOfLists - 2; j >= 0; j--) {
//                this.arrayList.set(j + 1, this.arrayList.get(j));
//            }
//            this.arrayList.set(0, temp);
//        }
    }

    private void moveLinkedList(){
        for(int i = 0; i < this.N; i++){
            this.linkedList.addFirst(this.linkedList.pollLast());
        }
    }

    private void moveMyList(){
        this.myList.moveRight(this.N);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append("\nArrayList\n");
        result.append(this.arrayList);

        result.append("\nLinkedList\n");
        result.append(this.linkedList);

        result.append("\nDoubleLinkedCircularList\n");
        result.append(this.myList);


        return result.toString();
    }
}
