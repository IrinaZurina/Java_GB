import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Homework_3 {
    public static void main(String[] args) {

        ArrayList<Integer> list02 = new ArrayList<>();
        for (int i = 0; i < 10; i++) list02.add(new Random().nextInt(20));
        System.out.println(list02);


        System.out.println(deleteEvenNumbers(list02));
        System.out.println();

        listStatistics(list02);
        System.out.println();

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(20);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(mergeSort(array)));

    }

    //Реализовать алгоритм сортировки слиянием
    static int[] mergeSort(int[] array){
        if (array.length == 1) return array;

        int[] arrayLeft = new int[array.length / 2];
        System.arraycopy(array, 0, arrayLeft, 0, arrayLeft.length);

        int[] arrayRight = new int[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, arrayRight, 0, array.length - array.length / 2);

        arrayLeft = mergeSort(arrayLeft);
        arrayRight = mergeSort(arrayRight);

        return mergeArray(arrayLeft, arrayRight);
    }

    static int[] mergeArray(int[] array1, int[] array2){
        int[] result  = new int[array1.length + array2.length];
        int pos1 = 0; int pos2 = 0;
        for (int i = 0; i < array1.length + array2.length; i++) {
            if (pos1 == array1.length){
                result[i] = array2[pos2];
                pos2 += 1;
            }
            else if (pos2 == array2.length){
                result[i] = array1[pos1];
                pos1 += 1;
            }

            else if (array1[pos1] < array2[pos2]){
                result[i] = array1[pos1];
                pos1 += 1;
            }
            else {
                result[i] = array2[pos2];
                pos2 += 1;
            }
        }
        return result;
    }

    //Пусть дан произвольный список целых чисел, удалить из него чётные числа
    static ArrayList deleteEvenNumbers (ArrayList<Integer> list){
        ArrayList<Integer> result = new ArrayList<>();
        for (int n:list) {
            if (n % 2 != 0) result.add(n);
        }
        return result;
    }

    //Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
    static void listStatistics(ArrayList<Integer> list){
        int min = list.get(0);
        int max = list.get(0);
        float average = 0;
        for (int n:list) {
            average = average + n;
            if (n < min) min = n;
            if (n > max) max = n;
        }
        average = average / list.size();
        System.out.println("Минимальное значение в списке: " + min);
        System.out.println("Максимальное значение в списке: " + max);
        System.out.println("Среднее арифметическое значение списка: " + average);
    }

}
