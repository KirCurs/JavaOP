import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class HashTable {
    private static final int TABLE_SIZE = 10;
    private static final double LOAD_FACTOR = 0.75;
    private LinkedList<Entry>[] table;
    private int size;

    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int hashFunction(String key) {
        int hash = key.hashCode();
        return Math.abs(hash) % TABLE_SIZE;
    }

    private void rehash() {
        int newCapacity = TABLE_SIZE * 2;
        LinkedList<Entry>[] newTable = new LinkedList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (LinkedList<Entry> bucket : table) {
            for (Entry entry : bucket) {
                int index = entry.getKey().hashCode() % newCapacity;
                newTable[index].add(entry);
            }
        }

        table = newTable;
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
        size++;

        if ((double) size / TABLE_SIZE > LOAD_FACTOR) {
            rehash();
        }
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
                size--;
                return;
            }
        }
    }

    public void removeByKey(String key) {
        remove(key);
    }

    public List<Entry> list() {
        List<Entry> entries = new ArrayList<>();
        for (LinkedList<Entry> bucket : table) {
            for (Entry entry : bucket) {
                entries.add(entry);
            }
        }
        return entries;
    }

    public void printHashTable() {
        List<Entry> entries = list();
        System.out.println("Хэш-таблица:");
        for (Entry entry : entries) {
            printEntry(entry);
        }
    }

    private void printEntry(Entry entry) {
        System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
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
}

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.put("ключ1", "значение1");
        hashTable.put("ключ2", "значение2");
        hashTable.put("ключ3", "значение3");

        List<HashTable.Entry> entries = hashTable.list();

        String keyToRemove = "ключ2";
        hashTable.removeByKey(keyToRemove);

        entries = hashTable.list();
        hashTable.printHashTable();
    }
}
