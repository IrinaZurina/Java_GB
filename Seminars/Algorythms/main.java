import java.util.Random;
public class main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] sortArr = new int[10];
        for(int i = 0; i < sortArr.length; i++){
            sortArr[i] = new Random().nextInt(100);
            System.out.print(sortArr[i] + "\t");
        }

        System.out.println();

        Heapsort.heapSort(sortArr);
        for(int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + "\t");
        }
    }
}
