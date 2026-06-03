import java.util.LinkedList;

public class HashTable<K, V> {
    // Вспомогательный класс для хранения пары ключ-значение
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // Геттеры и сеттеры
        public K getKey() { return key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }

    private LinkedList<Entry<K, V>>[] table;
    private int size = 0;
    private static final int CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[CAPACITY];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % CAPACITY;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index].removeIf(entry -> entry.getKey().equals(key));
            size--;
        }
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}