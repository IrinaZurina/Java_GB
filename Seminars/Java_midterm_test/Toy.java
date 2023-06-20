import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Toy implements LotteryInterface {
    public static void main(String[] args) {}
    public int toyID;
    public String toyName;
    protected int toyNumber;
    public int weight;


    public Toy(int toyID, String toyName, int toyNumber, int weight){
        this.toyID = toyID;
        this.toyName = toyName;
        this.toyNumber = toyNumber;
        this.weight = weight;
    }

    static ArrayList<Toy> getToysList(String fileName){
        File file = new File(fileName);
        //создаем объект FileReader для объекта File
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        //создаем список для записи объектов класса игрушек
        ArrayList<Toy> toysList = new ArrayList<>();
        //считываем строку в файле...
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //...пока не встретится пустая строка
        while (line != null) {
            //получаем из считанной строки список атрибутов игрушки
            List<String> toyAttributes = new ArrayList<String>(Arrays.asList(line.split(" ")));
            //создаем объект класса
            Toy toyToAdd = new Toy(parseInt(toyAttributes.get(0)),
                                   toyAttributes.get(1),
                                   parseInt(toyAttributes.get(2)),
                                   parseInt(toyAttributes.get(3)));
            //добавляем объект в список игрушек
            toysList.add(toyToAdd);
            // считываем остальные строки в цикле
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return toysList;
    }

    static void writeToysToFile(String fileName, ArrayList<Toy> toyList){
        //создаем объект FileWriter
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //построчно добавляем объекты из списка в файл
        for(Toy toy : toyList){
            try {
                if (toy.toyNumber != 0)
                    writer.write(toy.toyID + " " + toy.toyName + " " + toy.toyNumber + " " + toy.weight + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // получение информации для записи о новой игрушке
    static String getNewToyInfo() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите название игрушки: ");
        String name = in.nextLine();
        System.out.print("Введите идентификатор игрушки: ");
        int id = in.nextInt();
        System.out.print("Введите количество игрушек: ");
        int number = in.nextInt();
        System.out.print("Введите вес игрушки: ");
        int weight = in.nextInt();
        String toyInfo = id + " " + name + " " + number + " " + weight + "\n";
        in.close();
        return toyInfo;
    }

    //вывод на экран всей информации об игрушках из файла
    public static void showAvailableToys(String fileName){
        ArrayList<Toy> availableToys = getToysList(fileName);
        for (Toy toy: availableToys) {
            System.out.println(toy.toyID + " " + toy.toyName + " " + toy.toyNumber + "шт " + toy.weight + "%");
        }
    }


}


