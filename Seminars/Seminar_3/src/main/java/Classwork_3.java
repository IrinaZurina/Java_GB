import java.util.*;

public class Classwork_3 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(4);
        list.add(8);
        list.add(5);
        list.add(29);
        list.add(12);

        list.remove(1);
        list.get(1);

        if (list.get(1) instanceof String) ((String) list.get(1)).toUpperCase();

        list.forEach(n -> System.out.print(n + ","));
        System.out.println();

        ArrayList<String> listS = new ArrayList<>();  // <> => в список можно положить тоьлко указанный тип данных
        list.add(list.size()/2, 45); // вставит элемент иподвинет все оставшиеся
        list.set(list.size()/2, 1); // заменит элемент на новый

        ArrayList strings = new ArrayList();
        strings.addAll(listS);

//        Collections.sort(list);
//        list.forEach(n -> System.out.print(n + ","));

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                return t0 - t1; // сортирока по возрастанию. Если t1 - t0, то по убыванию
            }
        });
        list.forEach(n -> System.out.print(n + ","));
        System.out.println();

        ArrayList<Integer> list01 = new ArrayList<>();
        ArrayList<Integer> list02 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list01.add(new Random().nextInt(5));
            list02.add(new Random().nextInt(5));
        }
        System.out.println(list01);
        System.out.println(list02);
        System.out.println("-".repeat(10));
        //list01.retainAll(list02);
        //list01.removeAll(list02);
        System.out.println(list01);

        list01.forEach(n -> System.out.println(n));

        for (int n:list01) {
            System.out.println(n);
        }

        Iterator<Integer> iterator = list01.iterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            System.out.println(n);
            list01.remove(0);
        }

        ListIterator<Integer> iterator1 = list01.listIterator(list01.size());
        while (iterator1.hasPrevious()){
            int n = iterator1.previous();
            System.out.println(n);
            list01.remove(0);
        }

        LinkedList<Integer> linkedList = new LinkedList<>(); // быстрее для вставления и удаления эл-тов, а все остальное очень медленно
        linkedList.add(4);
        linkedList.get(0); // из середины будет медленно доставать
        linkedList.getFirst();
        linkedList.getLast();
    }
}
