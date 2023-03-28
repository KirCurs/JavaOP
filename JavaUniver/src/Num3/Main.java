package Num301;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);


        list.remove(v -> v == 1);
        list.print();
    }
}
