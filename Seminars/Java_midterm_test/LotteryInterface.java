import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public interface LotteryInterface {

    //добавляем информацию о новой игрушку в конец файла
    static void addNewToy(String fileName, String toyInfo){
        File file = new File(fileName);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fr.write(toyInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void changeToyWeight(){
        // показываем игрушки в наличии - сумма весов должна быть равна 100
        System.out.println("Игрушки в наличии: ");
        Toy.showAvailableToys("toys_in_stock.txt");
        System.out.println();

        // выбираем игрушку и называем вес, который хотим ей присвоить
        Scanner s = new Scanner(System.in);
        System.out.println("Введите идентификатор игрушки, вес которой нужно изменить: ");
        int toyToChange = s.nextInt();
        System.out.println("Введите новый вес игрушки: ");
        int newWeight = s.nextInt();

        // считываем файл, находим игрушку, вносим изменения, записываем новый список в файл
        ArrayList<Toy> allToys = Toy.getToysList("toys_in_stock.txt");
        for (Toy toy: allToys) {
            if (toy.toyID == toyToChange){
                toy.weight = newWeight;
                break;
            }
        }
        Toy.writeToysToFile("toys_in_stock.txt", allToys);
    }

    static void getRandomToy(){
        // получаем словарь из игрушек, участвующих в лотерее
        HashMap<Integer, ArrayList> probabilities = Service.createLotteryDict("toys_in_stock.txt");
        //генерируем рандомное число от 0 до 99 (поэтому сумма весов игрушек должна быть = 100)
        int randomChoice = new Random().nextInt(100);
        int prizeKey = 0;
        // ищем полученное рандомное число в интервалах, которые записаны в словаре у каждой игрушки
        // как только находим - проверяем, что кол-во игрушек > 0, запоминаем идентификатор игрушки и сообщаем о призе
                for (int key:probabilities.keySet()) {
            ArrayList info = probabilities.get(key);
            int[] range = (int[]) info.get(0);
            if (range[0] <= randomChoice & randomChoice <= range[1]){
                if ((Integer) info.get(1) > 0) {
                    System.out.println("Ваш приз: " + info.get(2));
                    prizeKey = key;
                    break;
                }
                // если кол-во игрушек оказалось = 0, то повторяем розыгрыш
                else getRandomToy();
            }
        }
        //обновляем кол-во игрушки в нужных файлах
        Service.updateToyNumber(prizeKey, "toys_in_stock.txt", "toys_to_giveaway.txt");
    }

    static void deliverToy(){
        //выбираем из списка, какую игрушку нужно доставить
        System.out.println("Игрушки, которые ждут доставки: ");
        Toy.showAvailableToys("toys_to_giveaway.txt");
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println("Введите идентификатор игрушки, которую нужно доставить: ");
        int toyToDeliver = s.nextInt();
        // обновляем информацию в нужных файлах
        Service.updateToyNumber(toyToDeliver, "toys_to_giveaway.txt", "delivered_toys.txt");
    }
}
