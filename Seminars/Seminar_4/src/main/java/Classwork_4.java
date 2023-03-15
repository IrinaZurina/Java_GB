import java.util.ArrayList;
import java.util.Scanner;

public class Classwork_4 {

    public static void main(String[] args) {

        ArrayList<ArrayList>  database = new ArrayList ();

        getInfo(database);
        System.out.println("Неотсортированный список:");
        printDatabase(database);

        System.out.println();
        System.out.println("Хотите отсортировать список? 1 - 'да', 2 - 'нет'");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        if (userInput == 1){
            database = sorting(database);
            System.out.println();
            System.out.println("Отсортированный список:");
            printDatabase(database);
        } else {
            System.out.println("До свидания!");
        }
    }

    // Метод для формирования базы до тех пор, пока пользователь на скажет "нет"
    static ArrayList<ArrayList> getInfo(ArrayList<ArrayList>  database){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите добавить пользователя? 1 - 'да', 2 - 'нет'.");
        int userInput = scanner.nextInt();
        while (userInput == 1){
            addUserToDatabase(getOneUserInfo(), database);
            System.out.println("Хотите добавить еще одного пользователя? 1 - 'да', 2 - 'нет'.");
            userInput = scanner.nextInt();
        }
        return database;
    }

    // Метод получения информации об одном объекте базы данных
    static ArrayList getOneUserInfo(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> newUser = new ArrayList<>();

        System.out.print("Введите фамилию: ");
        newUser.add(scanner.nextLine());

        System.out.print("Введите имя: ");
        newUser.add(scanner.nextLine());

        System.out.print("Введите Отчество: ");
        newUser.add(scanner.nextLine());

        System.out.print("Введите возраст: ");
        newUser.add(scanner.nextLine());

        System.out.print("Введите пол (М или Ж): ");
        newUser.add(scanner.nextLine());

        return newUser;
    }

    // Метод добавления информации об одном объекте в общую базу данных
    static ArrayList addUserToDatabase(ArrayList user, ArrayList<ArrayList> database){
        database.add(user);
        return database;
    }

    // Метод для печати базы данных в формате Иванов И.И. 32M
    static void printDatabase(ArrayList<ArrayList> database){
        for (int i = 0; i < database.size(); i++) {
            String name = new String((String) (database.get(i)).get(1));
            String parentalName = new String((String) (database.get(i)).get(2));
            System.out.print((database.get(i)).get(0) + " ");
            System.out.print(name.charAt(0) + "." + parentalName.charAt(0) + "." + " ");
            System.out.print((database.get(i)).get(3));
            System.out.println((database.get(i)).get(4));
        }
    }

    // Сортировка по полу, а затем по возрасту
    static ArrayList<ArrayList> sorting(ArrayList<ArrayList> database){
        ArrayList<ArrayList> female = new ArrayList<>();
        ArrayList<ArrayList> male = new ArrayList<>();
        for (int i = 0; i < database.size(); i++) {
            String gender = new String((String) (database.get(i)).get(4));
            if (gender.equals("Ж")){
                female.add(database.get(i));
            } else {
                male.add(database.get(i));
            }
        }

        database.clear();
        ageSorting(female);
        ageSorting(male);

        for (ArrayList user: female) {
            database.add(user);
        }

        for (ArrayList user: male) {
            database.add(user);
        }
        return database;
    }

    // Сортировка по возрасту
    static ArrayList<ArrayList> ageSorting(ArrayList<ArrayList> database){
        int steps = database.size() - 1;
        for (int i = 0; i < database.size(); i++) {
            for (int j = 0; j < steps; j++) {
                ArrayList temp = new ArrayList<>();
                int age1 = Integer.valueOf((String) (database.get(j)).get(3));
                int age2 = Integer.valueOf((String) (database.get(j + 1)).get(3));
                if (age1 > age2){
                    temp = database.get(j + 1);
                    database.set(j + 1, database.get(j));
                    database.set(j, temp);
                }
            }
        }
        return database;
    }
}
