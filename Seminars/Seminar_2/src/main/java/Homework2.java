import com.sun.tools.javac.Main;

public class Homework2 {
    public static void main(String[] args) {

        StringBuilder line1 = new StringBuilder("Hello world");
        String str = "orl";
        findMyLine(line1, str);

        System.out.println();

        StringBuilder line2 = new StringBuilder("dlrow olleH");
        reversedLines(line1, line2);

        System.out.println();

        String line = "Hello world!!!";
        reverseLineThroughRecursion(line);

        System.out.println();

        StringBuilder equation = new StringBuilder(buildEquation(56, 3, "+"));
        System.out.println(equation);

        System.out.println();

        //System.out.println(replaceEqualitySign(equation));

        System.out.println(replaceEqualitySign1(equation));

        System.out.println();

        String testString = "=".repeat(10000);
        StringBuilder testBuilder = new StringBuilder("");
        for (int i = 0; i < 10000; i++) {
            testBuilder.append("=");
        }
        compareStrings(testString, testBuilder);

    }

    // Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
    static void findMyLine(StringBuilder builder, String str){
        if (builder.indexOf(str) >= 0) System.out.println("Индекс вхождения строки = " + builder.indexOf(str));
        else System.out.println("Строка не обнаружена");
    }

    //Напишите программу, чтобы проверить, являются ли две данные строки
    // вращением друг друга (вхождение в обратном порядке).
    static void reversedLines(StringBuilder sb1, StringBuilder sb2){
        if (sb1.toString().equals(sb2.reverse().toString())) {
            System.out.println("Строки являются вращением друг друга");
        }
        else {
            System.out.println("Строки НЕ являются вращением друг друга");
        }
    }

    //*Напишите программу, чтобы перевернуть строку с помощью рекурсии.
    static void reverseLineThroughRecursion(String line){
        if (line.length() == 0) System.out.println(line);
        else {
            System.out.print(line.charAt(line.length()-1));
            reverseLineThroughRecursion(line.substring(0, line.length()-1));
        }
    }

    //Дано два числа, например 3 и 56, необходимо составить следующие строки:
    // 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
    static StringBuilder buildEquation(int num1, int num2, String operation){
        StringBuilder equation = new StringBuilder("");
        int result = 0;
        if (operation.equals("+")) result = num1 + num2;
        else if (operation.equals("-")) result = num1 - num2;
        else if (operation.equals("*")) result = num1 * num2;
        else if (operation.equals("/")) result = num1 / num2;

        return (equation.append(num1).append(operation).append(num2).append("=").append(result));
    }

    //Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
    static StringBuilder replaceEqualitySign(StringBuilder line){
        int i = line.indexOf("=");
        line.deleteCharAt(i).insert(i, " равно ");
        return line;
    }
    //Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
    static StringBuilder replaceEqualitySign1(StringBuilder line){
        int i = line.indexOf("=");
        line.replace(i, i + 1," равно ");
        return line;
    }

    //*Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
    static void compareStrings (String str, StringBuilder build){
        long startStr = System.currentTimeMillis();
        str.replace("=", "равно");
        long endStr = System.currentTimeMillis();
        System.out.print("Время для String: ");
        System.out.println(endStr - startStr);

        long startBuild = System.currentTimeMillis();
        build.replace(0, build.length(), "равно");
        long endBuild = System.currentTimeMillis();
        System.out.print("Время для StringBuilder: ");
        System.out.println(endBuild - startBuild);
    }
}



        






