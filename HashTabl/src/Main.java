import java.util.LinkedList;
import java.util.Scanner;

class HashTable {
    private static final int TABLE_SIZE = 10;
    private LinkedList<Entry>[] table;

    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String key) {
        int hash = key.hashCode();
        return Math.abs(hash) % TABLE_SIZE;
    }

    public void put(String key, String value) {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        bucket.add(new Entry(key, value));
    }

    public String get(String key) {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null; 
    }

    public void remove(String key) {
        int index = hashFunction(key);
        LinkedList<Entry> bucket = table[index];

        for (Entry entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry);
                return;
            }
        }

        
    }

    public void list() {
        for (LinkedList<Entry> bucket : table) {
            for (Entry entry : bucket) {
                System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
            }
        }
    }
}

class Entry {
    private String key;
    private String value;

    public Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите команду (put, get, remove, list, exit):");

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("put")) {
                System.out.println("Введите ключ:");
                String key = scanner.nextLine();
                System.out.println("Введите значение:");
                String value = scanner.nextLine();
                hashTable.put(key, value);
                System.out.println("Элемент добавлен.");
            } else if (command.equals("get")) {
                System.out.println("Введите ключ:");
                String key = scanner.nextLine();
                String value = hashTable.get(key);
                if (value != null) {
                    System.out.println("Значение: " + value);
                } else {
                    System.out.println("Элемент не найден.");
                }
            } else if (command.equals("remove")) {
                System.out.println("Введите ключ:");
                String key = scanner.nextLine();
                hashTable.remove(key);
                System.out.println("Элемент удален.");
            } else if (command.equals("list")) {
                hashTable.list();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Неверная команда.");
            }
        }

        scanner.close();
    }
}
