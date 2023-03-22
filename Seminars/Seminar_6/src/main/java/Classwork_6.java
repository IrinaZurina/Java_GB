import java.util.ArrayList;

public class Classwork_6 {
    public static void main(String[] args) {
    MySet mySet1 = new MySet();
    mySet1.add(3);
    mySet1.add(4);
    mySet1.add(3);
    mySet1.add(33);
    mySet1.printSet();
    System.out.println();

    MySet mySet2 = new MySet();
    mySet2.add(23);
    mySet2.add(4);
    mySet2.add(3);
    mySet2.add(34);
    mySet2.printSet();
    System.out.println();

    System.out.println(mySet2.get(5));

    mySet1.unite(mySet2).printSet();
    System.out.println();

    mySet1.intersect(mySet2).printSet();
    System.out.println();

    System.out.println(mySet2.toList());
    System.out.println();

    System.out.println(mySet2.partToList(1));
    System.out.println();

    mySet2.remove(2);
    mySet2.printSet();
    }
}

class MySet {
    ArrayList<Integer> mySet;
    public MySet(){
        mySet = new ArrayList<>();
    }

    public void add(int x){
        if (!mySet.contains(x)) mySet.add(x);
    }

    public void addAll(MySet set2){
        set2.mySet.forEach(x -> mySet.add(x));
    }

    public Object get(int index){
        if (index < mySet.size()) return mySet.get(index);
        else return "Index out of range";
    }

    public void remove(int index){
        if (index < mySet.size()) mySet.remove(index);
        else System.out.println("Index out of range");
    }

    public void printSet(){
        mySet.forEach(x -> System.out.print(x + " "));
    }

    public String toString(){
        String line = "";
        for (Integer element: mySet) {
            line = line + element.toString() + " ";
        }
        return line;
    }

    public int size(){
        return mySet.size();
    }

    public MySet unite(MySet set2){
        MySet unitedSet = new MySet();
        unitedSet.addAll(set2);
        for (int element: mySet) {
            if (!unitedSet.mySet.contains(element)) unitedSet.add(element);
        }
        return unitedSet;
    }

    public MySet intersect(MySet set2){
        MySet intersect = new MySet();
        for (int element: mySet) {
            if (set2.mySet.contains(element)) intersect.add(element);
        }
        return intersect;
    }

    public ArrayList toList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(mySet);
        return list;
    }

    public ArrayList partToList(int index){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < index + 1; i++) {
            list.add(mySet.get(i));
        }
        return list;
    }
}