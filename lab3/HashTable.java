package lab3;

import java.util.*;
import lab3.Record;

public class HashTable<K, V> {
    //variables
    public int hSize;
    public int size = 0;
    private final LinkedList<Record<K,V>>[] hTable;
    
    //object (holds all the key-value pairs) - constructor
    public HashTable(int hSize) {
        this.hSize = hSize;
        this.hTable = new LinkedList[this.hSize]; //присваиваем ссылку на оссоциативный массив соответствующего размера (пустой)
        for (int i=0; i<this.hSize; i++) {
            this.hTable[i] = new LinkedList<>(); //заполнение массива пустыми массивами и разрешение коллизий (LinkedList)
        }
        size = 0;
    }
    
    //change to private
    public int getHash (int obj) {
        int hashCode;
        hashCode = obj*50%hSize;
        return hashCode;
    }
    public int getIndex (K key) {
        Object _key = key;
        return getHash((int) _key);
    }
    
    //put(key, value)
    public void put (K key, V value) {
        int index = getIndex(key);
        if (hTable[index] == null) {
            hTable[index] = new LinkedList<Record<K, V>>();
        }
        for (Record<K,V> rec: hTable[index]) {
            if (rec.key.equals(key)) {
                rec.value = value;
                return;
            }
        }
        hTable[index].add(new Record<> (key, value));
        System.out.println("The element has been added");
        size++;
    }
    

    //get(key)
    public V get (K key) {
        if (key==null) return null;
        int index = getIndex(key);
        LinkedList<Record<K,V>> list = hTable[index];
        if (list.isEmpty()) {
            return null;
        } else {
            for (Record<K,V> r: list) {
                if (r.key.equals(key)) {
                    return r.value;
                }
            }
        }
        return null;
    }

    public Record<K,V> getRecord (K key) {
        if (key==null) return null;
        int index = getIndex(key);
        LinkedList<Record<K,V>> list = hTable[index];
        if (list.isEmpty()) {
            return null;
        } else {
            for (Record<K,V> rec: list) {
                if (rec.key.equals(key)) {
                    return rec;
                }
            }
        }
        return null;
    }
    
    //remove(key)
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Record<K,V>> list = hTable[index];
        if (!list.isEmpty()) {
            Record<K,V> rec = getRecord(key);
            if(rec!=null) {
                list.remove(rec);
            }
        }
    }
    
    //size() - amount of elemets in the table
    public int getSize(){
        return size;
    }
    //isEmpty() - if size == 0
    public boolean isEmpty(){
        return getSize()==0;
    }


    public static void main(String[] args) {
        HashTable<Integer, String> firstHT = new HashTable<>(10);
        firstHT.put(1, "one");
        firstHT.put(2, "two");
        firstHT.put(3, "three");
        firstHT.put(4, "four");
        firstHT.remove(2);

        System.out.println(firstHT.getSize());
        System.out.println(firstHT.get(1));
        System.out.println(firstHT.get(2));
    }
}
