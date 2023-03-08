public class Classwork2 {
    public static void main(String[] args) {
        String str = "Hello world!";    // объект строки финализирован!
//        System.out.println("Строка str = " + str);
//        str += "!";     // на этом этапе не просто добавляется символ, создается новая строка
//        System.out.println(str);

        StringBuilder builder = new StringBuilder("Hello world");    // этот объект не финализирован, в отличие от строк!
//        System.out.println(builder);
//        builder.append(" ")
//               .append(str);    //так работает добавление в билдер
//        System.out.println(builder);

        long begin = System.currentTimeMillis();  // возвращает время с 01.01.1970 в миллисекундах
        for (int i = 0; i < 1000; i++) {
            str += Character.getName(i); // возвращает название буквы
        }

        long end = System.currentTimeMillis();
        System.out.println(end - begin); // 20ms
        // System.nanoTime();  // возвращает время в наносекундах со времени включения компа

        begin = System.currentTimeMillis();  // возвращает время с 01.01.1970 в миллисекундах
        for (int i = 0; i < 1000; i++) {
            builder.append(Character.getName(i)); // возвращает название буквы
        }

        end = System.currentTimeMillis();
        System.out.println(end - begin); // 1ms
        // System.nanoTime();  // возвращает время в наносекундах со времени включения компа

        System.out.println(str.toLowerCase());
        System.out.println(str.length());
        System.out.println("_*".repeat(10));

        String a = "d";
        String f = "d";

        System.out.println(str.equals("N"));
        System.out.println(str.contains("N"));
        str = "Hello world!";
        System.out.println(str.replace("l", "p"));
        System.out.println(str.replaceFirst("l", "p"));
        System.out.println(str.charAt(1)); // вернуть буквы на 1 месте
        String[] strings = str.split(" ");

        System.out.println(builder.replace(0, 1, "F"));
        System.out.println(builder.reverse());
        System.out.println(builder.insert(4, "insert"));
        System.out.println(builder.deleteCharAt(6));
        System.out.println(builder.indexOf("o"));
    }
}
