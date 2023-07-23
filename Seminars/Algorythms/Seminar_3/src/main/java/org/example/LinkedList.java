package org.example;

import java.util.Comparator;

/**
 * Связный список
 * @param <T>
 */
public class LinkedList<T>{
    private Node head; //Указатель на первый элемент (узел) связного списка

    /**
     * Узел (элемент)
     */
    public class Node{
        public T value;  // значение узла
        public Node next; // указатель на следующий узел
        public Node previous;
    }

    /**
     * Добавление нового элемента в начало связного списка
     * @param value значение
     */
    public void addFirst(T value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.next = head;
        }
        head = node;
    }

    /**
     * Добавление нового элемента в конец связного списка
     * @param value значение
     */
    public void addLast(T value) {
        Node node = new Node();
        node.value = value;
        if (head == null){
            head= node;
        }
        else {
            Node lastNode = head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }

    }

    /**
     * Удалить первый элемент связного списка
     */
    public void  removeFirst(){
         if (head != null){
             head = head.next;
         }
    }

    /**
     * Удалить последний элемент связного списка
     */
    public void  removeLast(){
        // случай когда список пустой
        if (head == null)
            return;
        // случаи когда элементов больше одного
        Node node = head;
        while (node.next != null){
            if(node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
        // случай когда элемент один
        head = null;
    }

    /**
     * Поиск элемента в связном списке
     * @param value значение
     * @return элемент (узел)
     */
    public Node contains(T value){
        Node node = head;
        while (node != null){
            if (node.value.equals(value))
                return node;
            node = node.next;
        }
        return null;
    }

    /**
     * Сортировка
     * @param comparator
     */
    public void sort(Comparator<T> comparator){
        Node node = head;
        while (node != null){

            Node minValueNode = node;

            Node node2 = node.next;
            while (node2 != null){
                if (comparator.compare(minValueNode.value, node2.value) > 0){
                    minValueNode = node2;
                }
                node2 = node2.next;
            }
            if (minValueNode != node){
                T buf = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buf;
            }
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = head;
        while (node != null){
            stringBuilder.append(node.value);
            stringBuilder.append('\n');
            node = node.next;
        }
        return stringBuilder.toString();
    }

    /**
     * Разворот списка
     * Публичная версия без параметров
     */
    public void revert(){
        if (head != null && head.next != null){  // запускается если в списке хотя бы 2 элемента
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }
    /**
     * Разворот списка
     * @param currentNode
     * @param previousNode
     *
     */
    private void revert(Node currentNode, Node previousNode){
        if (currentNode.next == null){  // как только доходим до конца списка, объявляем последний элемент головным
            head = currentNode;
        }
        else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next= previousNode;  // замена ссылок
    }

}
