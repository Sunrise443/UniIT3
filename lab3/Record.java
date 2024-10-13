package lab3;

public class Record<K,V> {
    public K key;
    public V value;

    Record<K,V> next;

    public Record(K _key, V _value) {
        this.key = _key;
        this.value = _value;
    }
}
