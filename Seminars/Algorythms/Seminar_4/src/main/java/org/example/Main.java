package main.java.org.example;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> hashMap1 = new HashMap<>(4);
        hashMap1.put("+792839832", "Андрей");
        hashMap1.put("+792839833", "Василий");
        hashMap1.put("+792839833", "Александр");
        hashMap1.put("+778345783", "Ivan");
        hashMap1.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));

    }
}