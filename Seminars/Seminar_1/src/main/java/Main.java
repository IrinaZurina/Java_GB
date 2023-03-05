import java.util.Random;

public class Main {
    // public/private - модификатор видимости, будет или нет видно вне класса
    // ТИПЫ ДАННЫХ
    int i; // 32 bit
    
    long l; // 62 bit
    byte b; //8 bit
    short sh; // 16 bit

    float f; // 32 bit floating point
    double d; // 64 bit floating point

    boolean bool; // по умолчанию False

    char aChar; // буква, точнее индекс буквы в ASCII, беззначный

    String str; // это класс, str - ссылочная переменная
    String tmpS = new String("Hello world"); // правильный формат объявления ссылочных переменных
    
    static int[] ints = new int[10];

    public static void main(String[] args) { // точка входа, полная сигнатура, без нее не будет работать
        Main.getInt("45"); // вызов метода класса Main
        ints[3] = 10;
        int[] tmp = new int[ints.length * 2 + 1];

        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            tmp[i] = ints[i] + random.nextInt(100);
        }
        tmp[15] = 5;
        ints = tmp;

        System.out.println(Integer.toBinaryString(2));  // преобразовать десятичное число в двоичное 
    }
    
    static int getInt(String str) { // static нужно, чтобы можно было обратиться из статичного метода main
        Main main = new Main(); // создание экземпляра класса main, в котором будут доступны все переменные и нестатичные методы
        return Integer.parseInt(str);
    }
    
    static void print(String str) {
        System.out.println();
    }
}
