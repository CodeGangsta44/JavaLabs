package com.company;
import lab02.DigitCounter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Виконав Довгополюк Р.Р.(залікова книжка №8)\n");

        DigitCounter obj = new DigitCounter();

        obj.find_summ();

        System.out.println("Введений текст: ");
        System.out.println(obj.get_string());

        System.out.print("\nСума цифр у введеному тексті: ");
        System.out.println(obj.get_summ());

    }
}
