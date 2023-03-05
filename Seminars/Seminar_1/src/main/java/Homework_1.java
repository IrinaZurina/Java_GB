import java.util.Arrays;
import java.util.Random;

public class Homework_1 {

    public static void main(String[] args) {

        int i = generateRandomNumber(2000);
        System.out.println(i);

        int n = mostSignificantBit(i);
        System.out.println(n);

        System.out.println(Arrays.toString(findMultiple(i, n)));

        System.out.println(Arrays.toString(findNonMultiple(i, n)));

    }
    // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
    static int generateRandomNumber(int maxValue) {
        int i = new Random().nextInt(maxValue);
        return i;
    }

    // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    static int mostSignificantBit(int number) {
        int n = Integer.toBinaryString(number).length();
        return n;
    }

    // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
    static int[] findMultiple(int number, int bitNum) {
        int temp = number;
        int[] m1 = new int[(Short.MAX_VALUE - number) / bitNum];
        for (int j = 0; j < m1.length; j++) {
            while (m1[j] == 0) {
                if (temp % bitNum == 0) {
                    m1[j] = temp;
                    temp++;
                } else temp++;
            }
        }
        return m1;
    }

    // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
    static int[] findNonMultiple(int number, int bitNum){
        int temp = Short.MIN_VALUE;
        int[] m2 = new int[number - Short.MIN_VALUE - (number - Short.MIN_VALUE) / bitNum];
        for (int j = 0; j < m2.length; j++) {
            while (m2[j] == 0){
                if (temp % bitNum != 0){
                    m2[j] = temp;
                    temp ++;
                }
                else temp ++;
            }
        }
        return m2;
    }
}
