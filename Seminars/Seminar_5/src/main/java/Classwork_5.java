import java.util.*;

public class Classwork_5 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            hashMap.put(i, String.valueOf(i));
            hashMap.putIfAbsent(i, String.valueOf(i) + "!"); // добавить значение, если ключа еще не было
        }

        // Можно распечатать так (но это будет просто строка):
        System.out.println(hashMap);
        // Можно распечатать пробежаться по всем элементам (но в цикле foreach никак нельзя изменять элеменеты):
        hashMap.forEach((k, v) -> System.out.print(k + "=" + v + ", "));

        //-----------------------------------
//        Set<Integer> keys = HashMap.keySet();  // почему-то ругается...
//        for (Integer k:keys) {
//            System.out.println(hashMap.get(k) + ", ");
//        }
//
//        Iterator<Integer> iterator = hashMap.keySet().iterator();
//        while (iterator.hasNext()){
//            String v = hashMap.get(iterator.next());
//            System.out.println(v + ", ");
//            iterator.remove();  // здесь, в отличие от предыдущих методов, можно удалять эл-ты
//        }
//
//        Collection<String> v = hashMap.values();  // выбрать все значения, положить в коллекцию
//
//        for (int i = 0; i < keys.size(); i++) {
//            System.out.print(hashMap.get(keys.toArray()[i]) + ", ");  // еще один способ перебора
//        }
//
//        Set<Map.Entry<Integer, String>> e = hashMap.entrySet();  //если надо сохранить в файл ключи и значения
//
//
//        hashMap.get(1); // возвращает значение по ключу
//        hashMap.getOrDefault(1, "Key is not found"); // вернет значение, если найдет ключ. В противном случае выведет значение по умолчанию
//
//        hashMap.compute(1, (k, val) -> val += "!"); // можно произвести значение только с одним эл-том без циклов
//        hashMap.computeIfPresent(3, (k, va) -> va = "1"); // обработает только если есть указанный ключ
//        hashMap.computeIfAbsent(3, va -> "1"); // обработает только если нет указанного ключа
//        hashMap.replaceAll((k, val) -> val += "1");
//
//        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(); // яохраняет последовательность
//        TreeMap<String, String> treeMap = new TreeMap<>();
//        treeMap.put("Первый", "1");
//        treeMap.put("Второй", "1");
//        treeMap.put("Третий", "1");
//        treeMap.put("Пятый", "1");
//        System.out.println(treeMap); // если нужно отсортировать дерево по ключам
//
//        treeMap.headMap("Второй", true); // возвращает значения от начала до указанного ключа, включительно
//        treeMap.tailMap("Второй", false); // возвращает значения от указанного ключа (невключительно) до конца

//      Это все к домашке, но нихрена непонятно((
//        ArrayList<String> age = new ArrayList<>();
//        age.add("Первый");
//        age.add("Второй");
//        age.add("Третий");
//        age.add("Пятый");
//        LinkedList<Integer> list = new LinkedList<>();
//        TreeMap<String, Integer> treeMap1 = new TreeMap<>();
//        Integer[] cnt = new Integer[]{0};
//        age.forEach(n -> treeMap1.put(n, cnt[0]++));
//        treeMap1.forEach((k, v) -> list.add(v));
    }

}
