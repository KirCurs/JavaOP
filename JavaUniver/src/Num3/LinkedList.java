package Num301;

import java.util.function.Predicate;

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;

    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);


        if (head == null) {
            head = newNode;

        } else {
            Node currentNode = head;
            while (currentNode.next != null) {

                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }

    }

    public void removeForIndex(int index) {

    }

    public void remove(Predicate<Integer> condition) {
        Node currentNode = head;
        Node prevNode = null;

        while (currentNode.next != null) {

            if (condition.test(currentNode.data)) {

                if (currentNode == head) {
                    head = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }

            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void print() {
        Node currentNode = head;

        if (head != null) {
            System.out.println(head.data);
        }

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.data);
        }
    }
}
