package lab02;

import java.util.Scanner;

public class DigitCounter {
    private String DEFAULT_STRING = "The idea of establishment of technical educational institution occurred to sugar \n" +
            "mill workers of south-west regions. On 18th of January 1880 with the active support of the head of Kyiv \n" +
            "exchange committee N. Hryakov it was decided to open the subscription for donation-raising. Raising money, \n" +
            "guaranteed the contributions of Kyiv patrons and support from the Minister of Justice I. Witte who \n" +
            "allowed to make a decision on 25th of November 1896 on private meeting in L.I. Brodskyi’s house to \n" +
            "establish Kyiv Polytechnic Institute.";

    private String input;
    private int summOfDigits;

    public DigitCounter(){

        summOfDigits = 0;
        System.out.println("Введіть Ваш текст (для завершення введіть порожній рядок): ");

        Scanner scan = new Scanner(System.in);
        StringBuilder resultOfInput = new StringBuilder();
        while(true){
            String temp = scan.nextLine();
            if(temp.length() == 0) break;
            else{
                if (resultOfInput.length() != 0) resultOfInput.append('\n');
                resultOfInput.append(temp);
            }
        }

        input = resultOfInput.length() == 0 ? DEFAULT_STRING : resultOfInput.toString();
    }
    public DigitCounter(String _input){
        input = _input;
        summOfDigits = 0;
    }
    public void find_summ(){
        String[] DigitArray = input.split("");
        for (String i:DigitArray){
            if (i.charAt(0) >= 48 && i.charAt(0) <= 57) summOfDigits += i.charAt(0) - 48;
        }
    }
    public int get_summ(){
        return summOfDigits;
    }
    public String get_string(){
        return input;
    }
}
