package org.example;

public class Program {
    public static void main(String[] args) {
        LinkedList<Employee> linkedList1 = new LinkedList<>();

        Employee searchEmployee = new Employee("EEEE", 18);

        linkedList1.addFirst(new Employee("AAAAA", 23));
        linkedList1.addFirst(new Employee("BBB", 41));
        linkedList1.addFirst(new Employee("FFF", 33));
        linkedList1.addFirst(new Employee("AAAAA", 28));
        linkedList1.addFirst(new Employee("AAAA", 53));
        linkedList1.addFirst(new Employee("EEEE", 19));
        linkedList1.addFirst(new Employee("AAAAA", 23));
        linkedList1.addFirst(new Employee("MMM", 32));

        System.out.println();
        System.out.println(linkedList1);

        linkedList1.revert();

        System.out.println();
        System.out.println(linkedList1);

    }
}