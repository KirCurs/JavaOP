
package Num3;



public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;

    }

    public static class Node {
        public int data;
        public Node nextElem;

        public Node(int data) {
            this.data = data;
            nextElem = null;
        }
    }

    public void setNum(int num) {
        Node newNode = new Node(num);
        Node currentNode = head;

        if (head == null) {
            head = newNode;

        }else {
            while (currentNode.nextElem != null){
                currentNode = currentNode.nextElem;
            }
            currentNode.nextElem = newNode;
        }

    }
        public void remove (int num){
            Node currentNode = head;
            Node prevNode = null;

            while (currentNode.nextElem != null) {

                if (currentNode.data == num) {

                    if (currentNode == head) {
                        head = currentNode.nextElem;
                    } else {
                        prevNode.nextElem = currentNode.nextElem;
                    }

                }

                prevNode = currentNode;
                currentNode = currentNode.nextElem;
            }
        }
        public void print () {
            Node currentNode = head;

            if (head != null) {
                System.out.println(head.data);
            }

            while (currentNode.nextElem != null) {
                currentNode = currentNode.nextElem;
                System.out.println(currentNode.data);
            }
        }
    }
 // удаление по индексу, добавление по индексу, добавление в конец
