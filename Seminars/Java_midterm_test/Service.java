import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Service extends Toy{
    public Service(int toyID, String toyName, int toyNumber, int weight) {
        super(toyID, toyName, toyNumber, weight);
    }

    // вспомогательный метод для проведения лотереи - создание словаря, в котором ключ = идентификатор игрушки, а значение =
    // список, в котором лежит информация о диапазоне вероятностей, количестве игрушки и ее названии
    protected static HashMap<Integer, ArrayList> createLotteryDict(String filename){
        ArrayList<Toy> lotteryToys = Toy.getToysList(filename);
        HashMap<Integer, ArrayList> probabilities = new HashMap<>();
        // получение диапазонов вероятностей: допустим, у первой игрушки вес = 7, значит ее диапазон = [0, 7];
        // у второй игрушки вес = 10, ее диапазон = [7, 7 + 10]  и т.д.
        // проходимся по всему списку игрушек и добавляем в словарь необходимую информацию о каждой из них
        int start = 0;
        int end = lotteryToys.get(0).weight;
        for (int i = 0; i < lotteryToys.size(); i++) {
            ArrayList info = new ArrayList<>();
            int[] range = new int[]{start, end};
            info.add(range);
            info.add(lotteryToys.get(i).toyNumber);
            info.add(lotteryToys.get(i).toyName);
            probabilities.put(lotteryToys.get(i).toyID, info);
            start = end;
            if (i + 1 < lotteryToys.size()) end = start + lotteryToys.get(i + 1).weight;
            else end = 100;
        }
        return probabilities;
    }

    //вспомогательный метод для обновления количества игрушек, передаем идентификатор игрушки,
    // количество которой надо изменить - убавляем в одном файле, добавляем во втором
    protected static void updateToyNumber(int toyID, String filenameToSubtract, String filenameToAdd){
        // считываем файл, находим нужную игрушку, уменьшаем на единицу
        ArrayList<Toy> toysToSubtract = Toy.getToysList(filenameToSubtract);
        String theToy = "";
        for (Toy toy: toysToSubtract) {
            if (toy.toyID == toyID) {
                toy.toyNumber -= 1;
                theToy = toy.toyID + " " + toy.toyName + " " + 1 + " " + toy.weight + "\n";
                break;
            }
        }
        Toy.writeToysToFile(filenameToSubtract, toysToSubtract);

        // там где надо добавить, создаем флаг и смотрим, есть ли такая игрушка в наличии, если да,
        // то увеличиваем кол-во на 1, меняем флаг
        ArrayList<Toy> toysToAdd = Toy.getToysList(filenameToAdd);
        boolean toyIsPresent = false;
        for (Toy toy: toysToAdd) {
            if (toy.toyID == toyID){
                toy.toyNumber += 1;
                toyIsPresent = true;
                break;
            }
        }
        //если игрушка уже есть в файле (проверяем по флагу), просто записываем обновленный список файл
        if (toyIsPresent) Toy.writeToysToFile(filenameToAdd, toysToAdd);
        //если игрушки в файле не нашлось, то добавляем ее данные целиком
        else LotteryInterface.addNewToy(filenameToAdd, theToy);
    }
}
