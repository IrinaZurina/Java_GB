import java.util.*;
import java.util.stream.Collectors;

public class Homework_5 {
    public static void main(String[] args) {

        HashMap<String, TreeMap> contactList = getContacts();
        System.out.println("Имя Фамилия   кол-во вызовов: номер телефона");
        printContacts(contactList);
        System.out.println();
        popularNames(contactList);
        System.out.println();
        popularNumbers(contactList);
        System.out.println();
    }

    // Формирование списка контактов
    static HashMap getContacts(){
        HashMap<String, TreeMap> contactList = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        while (userInput.equals("q") == false){
            List<String> inputList = new ArrayList<String>(Arrays.asList(userInput.split(" ")));
            TreeMap<Integer, String> phones = new TreeMap<>();
            for (int i = 2; i < inputList.size(); i++) {
                Random numOfCalls = new Random();
                phones.put(numOfCalls.nextInt(100), inputList.get(i));
            }
            contactList.put(inputList.get(0) + " " + inputList.get(1), phones);
            userInput = scanner.nextLine();
        }
        return contactList;
    }

    // Печать списка контактов
    static void printContacts(HashMap contactList){
        for (Object k: contactList.keySet()) {
            System.out.print(k + "   ");
            TreeMap<Integer, String> phones = (TreeMap<Integer, String>) contactList.get(k);
            Set<Integer> keys = phones.keySet();
            for (Integer key: keys) {
                System.out.print(key + ": " + phones.get(key) + ";   ");
            }
            System.out.println();
        }
    }

    // Поиск и печать повторяющихся имен с сортировкой по убыванию популярности имён
    static void popularNames(HashMap contactList){
        // создаем карту с подсчетом имен в списке
        Map<String, Integer> popularNames = new HashMap<>();
        for (Object key: contactList.keySet()){
            List<String> contactName = new ArrayList<String>(Arrays.asList(key.toString().split(" ")));
            popularNames.putIfAbsent(contactName.get(0), 0);
            popularNames.compute(contactName.get(0), (k, v) -> v += 1);
        }

        // сортируем карту по значениям и выводим на печать, если значение больше 1
        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(popularNames.entrySet());
        sortedNames.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println("Самые популярные имена");
        for (Map.Entry<String, Integer> element: sortedNames) {
            if (element.getValue() > 1) System.out.println(element);
        }
    }

    // // Поиск и печать топ-5 самых вызываемых номеров с сортировкой по убыванию популярности
    static void popularNumbers(HashMap contactList){
        // собираем все номера с количествами вызовов в отдельную карту
        TreeMap<Integer, String> popularNumbers = new TreeMap<>();
        for (Object key: contactList.keySet()) {
            popularNumbers.putAll((Map<? extends Integer, ? extends String>) contactList.get(key));
        }
        // сортируем и выводим на печать
        List<Map.Entry<Integer, String>> sortedNumbers = new ArrayList<>(popularNumbers.entrySet());
        sortedNumbers.sort(Map.Entry.comparingByKey(Comparator.reverseOrder()));
        System.out.println("Топ-5 популярных номеров");
        int counter = 0;
        for (Map.Entry<Integer, String> element: sortedNumbers) {
            System.out.println(element);
            counter += 1;
            if (counter == 5) break;
        }
    }
}
