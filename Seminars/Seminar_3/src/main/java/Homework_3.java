import java.util.*;

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

        System.out.println();

        ArrayList<Integer> list03 = new ArrayList<>();
        ArrayList<Integer> list04 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list03.add(new Random().nextInt(5));
            list04.add(new Random().nextInt(5));
        }
        System.out.println(unionLists(list03,list04));

        System.out.println();

        // Сравнить время работы пятого и шестого пунктов.
        long startSimpleList = System.currentTimeMillis();
        addNullToList();
        long endSimpleList = System.currentTimeMillis();
        System.out.print("Время для List: ");
        System.out.println(endSimpleList - startSimpleList);

        long startLinkedList = System.currentTimeMillis();
        addNullToLinkedList();
        long endLinkedList = System.currentTimeMillis();
        System.out.print("Время для LinkedList: ");
        System.out.println(endLinkedList - startLinkedList);

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

    // Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся в первом.
    static ArrayList unionLists(ArrayList list01,ArrayList list02){
        System.out.println(list01);
        System.out.println(list02);
        System.out.println("-".repeat(10));
        Iterator i = list02.iterator();
        while (i.hasNext()){
            if (list01.contains(i.next()) == false){
                list01.add(i.next());
            }
        }
        return list01;
    }

    // Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз.
    static ArrayList addNullToList(){
        ArrayList<Integer> list01 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list01.add(new Random().nextInt(5));
        }
        for (int i = 0; i < 10000; i++) {
            list01.add(0, 0);
        }
        return list01;


    // Создать LinkedList<Integer> и добавить нулевым эллементом ноль 10000 раз.
    }static LinkedList addNullToLinkedList(){
        LinkedList<Integer> list01 = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            list01.add(new Random().nextInt(5));
        }
        for (int i = 0; i < 10000; i++) {
            list01.addFirst(0);
        }
        return list01;
    }
}
