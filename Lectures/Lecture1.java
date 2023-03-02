package Lectures;

import java.util.Scanner; // модуль для считывания данных с консоли
import java.io.FileWriter;  // модуль для работы с файлами
import java.io.IOException; // модуль для обработки исключений
/**
 * program
 */
public class Lecture1 {  // написать class и выбрать сниппет
    public static void main(String[] args) {    //написать main и выбрать сниппет
        //System.out.println("world");    // написать sys и выбрать сниппет sysout
        String s = "qwerty"; // строка
        s.charAt(0);    // обращение к элементу строки по индексу
        System.out.println(s);
        short age = 10; // занимает меньше чем int
        int salary = 12_345; // стандартно - занимает 4 байта; разряды можно разделять _
        float e = 2.7f; // обязательно суффикс f!!!
        double pi = 3.1415; //есть суффикс D, но он необязательный
        char ch = 'a'; // символ
        boolean f = true && false;
        //var i = 123;    //неявная типизация
        System.out.println(Integer.MAX_VALUE); // Integer - класс-обертка, для него уже есть много функционала
        
        int a = 123;
        System.out.println(a++); // выведет 123
        System.out.println(a); // выведет 124 => приоритет у вывода в консоль выше, чем у операции внутри вывода
        System.out.println(++a); // выведет 125 - здесь приоритет у инкремента перед выводом
        
        // Массивы
        int[] arr = new int[10];
        System.out.println(arr.length); // 10
        
        arr = new int[] { 1, 2, 3, 4, 5 };
        System.out.println(arr.length);    // 5
    }
    
    /**
    * ||, &&, ^, ! - логические операции
    <<, >>, &, |, ^ - побитовые операции
    */

    public static void main1(String[] args) {
        // Многомерные массивы
        int[] arr[] = new int[3][5];
        for (int[] line : arr) {
            for (int item : line) {
                System.out.printf("%d", item);
            }
            System.out.println();
        }

        int[][] brr = new int[3][5];
        for (int i = 0; i < brr.length; i++) {
            for (int j = 0; j < brr[i].length; j++) {
                System.out.printf("%d ", brr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main2(String[] args) {
        // Преобразование типов. Неявное преобразование:
        int i = 123;
        double d = i;
        System.out.println(i); // 123
        System.out.println(d); // 123.0
        d = 3.1315;
        i = (int) d;
        System.out.println(d); // 3.1315
        System.out.println(i); // 3

        // Преобразование типов. Явное преобразование:
        byte b = Byte.parseByte("123");
        System.out.println(b); // 123
        byte c = Byte.parseByte("1234");
        System.out.println(c); // Error, т.к. в байт можно положить от 0 до 255 

        int[] a = new int[10];
        // double[] f = a; // нельзя в массив вещественных положить массив целых
        // изучить ковариантность и контрвариантность
    }
    
    public static void main3(String[] args) {
        // Получение данных из терминала. import java.util.Scanner;
        Scanner iScanner = new Scanner(System.in); // экземпляр класса Scanner; SystemIn - откуда что будем забирать
        System.out.printf("name: ");
        String name = iScanner.nextLine(); // получение строки
        System.out.printf("Привет, %s", name);
        System.out.printf("int a: ");
        int x = iScanner.nextInt();
        System.out.printf("double a: ");
        double y = iScanner.nextDouble();
        System.out.printf("%d + %f = %f", x, y, x + y);
        iScanner.close();
    }
    
    public static void main4(String[] args) {
        // Проверка на соответсвие получаемого типа. import java.util.Scanner;
        Scanner iScanner = new Scanner(System.in); // экземпляр класса Scanner; SystemIn - откуда что будем забирать
        System.out.printf("int a: ");
        boolean flag = iScanner.hasNextInt(); // проверка - можно из ввода сделать int или нет
        System.out.println(flag);
        int i = iScanner.nextInt();
        System.out.println(i);
        iScanner.close();
    }

    public static void main5(String[] args) {
        // Форматированный вывод
        int a = 1, b = 2;
        int c = a + b;
        // String res = a + " + " + b + " = " + c;
        String res = String.format("%d + %d = %d \n", a, b, c); //форматированную строку можно положить в переменную
        System.out.printf("%d + %d = %d \n", a, b, c); // а можно сразу вывести на печать
        System.out.println(res);

        String s = "qwe";
        int d = 123;
        String q = s + d; // здесь конкатенация + неявное преобразование a
        // конкатенация дает очень сильную просадку по производительности, есть другие методы
        System.out.println(q); //qwe123

        /* Виды спецификаторов:
         * %d - для вывода целочисленных значений
         * %x - для вывода шестнадцатеричных значений
         * %f - для вывода чисел с плавающей точкой
         * %e - для вывода чисел в экспоненциальной форме
         * %с - для вывода одиночного символа
         * %s - для вывода строковых значений
         */
    }

    public static void main6(String[] args) {
        int a = 1;
        int b = 2;
        int min = a < b ? a : b; // тернарный оператор "если а < b мин = а, иначе мин = b"
        System.out.println(min);

        // ОПЕРАТОР ВЫБОРА
        Scanner iScanner = new Scanner(System.in);
        int month = iScanner.nextInt();
        String text = "";
        switch (month) {
            case 1:
                text = "Autumn";
                break;

            default:
                text = "mistake";
                break;
        }
        iScanner.close();
    }

    
    public static void main7(String[] args) {
        // Частный случай цикла for для перебора коллекции:
        int[] arr = new int[] { 1, 2, 4, 7, 89, 9 };
        for (int item : arr) {  //сниппет foreach
            System.out.println(item);
            //В таком цикле работа идет не с эл-там коллекции, а с их копией в локальной переменной!!
        }
    }

    public static void main8(String[] args) {
        // РАБОТА С ФАЙЛАМИ
        try (FileWriter fw = new FileWriter("file.txt", false)) {   // true/false влияют на дозапись или создание нового файла
            fw.write("line 1");
            fw.append('\n');
            fw.append('2');
            fw.append('\n');
            fw.write("line 3");
            fw.flush(); // принудительная запись
        } catch (Exception ex) {
            System.out.println(ex.getMessage());    // при ошибке просмотреть сообщение об ошибке
        }
    }

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}