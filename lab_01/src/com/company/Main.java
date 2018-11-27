package com.company;
import lab01.Matrix;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Виконав Довгополюк Р.Р.(залікова книжка №8)\n");

        System.out.print("Будь ласка, введіть розмірність матриці: ");
        Scanner input = new Scanner(System.in);
        String size = input.nextLine();

        Matrix obj = size.length() != 0 ? new Matrix(Integer.parseInt(size)) : new Matrix();

        System.out.println("Матриця до обробки:");
        obj.print();

        obj.rotate();

        System.out.println("Матриця після обробки:");
        obj.print();
    }
}

