package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFloatNumber());

        String text = readLine();
        System.out.println(text);

    }

    /*
    ** Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает
    * введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
    * необходимо повторно запросить у пользователя ввод данных.
     */
    public static float getFloatNumber() {
        System.out.print("Введите десятичную дробь: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        float res = 0;
        if (isValid(userInput)) res = Float.parseFloat(userInput);
        else {
            System.out.println("Неправильно введено число!");
            res = getFloatNumber();
        }
        return res;
    }

    public static boolean isValid(String testString){
        try{
            Float.parseFloat(testString);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /*Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.*/
    public static String readLine(){
        System.out.print("Введите текст: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.length() == 0)
            throw  new RuntimeException("Нельзя вводить пустую строку!");
        return line;
    }
}