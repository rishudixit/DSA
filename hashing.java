import java.io.*;

class ValueEntry {
    String key;
    int value;

    ValueEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

class HashTable {
    private int HASH_SIZE;
    private int size;
    private ValueEntry[] table;
    private int totalprimeSize;

    public HashTable(int ts) {
        size = 0;
        HASH_SIZE = ts;
        table = new ValueEntry[HASH_SIZE];
        for (int i = 0; i < HASH_SIZE; i++)
            table[i] = null;
        totalprimeSize = getPrime();
    }

    public int getPrime() {
        for (int i = HASH_SIZE - 1; i >= 1; i--) {
            int cnt = 0;
            for (int j = 2; j * j <= i; j++)
                if (i % j == 0)
                    cnt++;
            if (cnt == 0)
                return i;
        }
        return 3;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        size = 0;
        for (int i = 0; i < HASH_SIZE; i++)
            table[i] = null;
    }

    public int getkey(String key) {
        int hash1 = myhash1(key);
        int hash2 = myhash2(key);
        while (table[hash1] != null
                && !table[hash1].key.equals(key)) {
            hash1 += hash2;
            hash1 %= HASH_SIZE;
        }
        return table[hash1].value;
    }

    public void insert(String key, int value) {
        if (size == HASH_SIZE) {
            System.out.println("Table is full");
            return;
        }
        int hashing1 = myhash1(key);
        int hashing2 = myhash2(key);
        while (table[hashing1] != null) {
            hashing1 += hashing2;
            hashing1 %= HASH_SIZE;
        }
        table[hashing1] = new ValueEntry(key, value);
        size++;
    }

    public void remove(String key) {
        int hash1 = myhash1(key);
        int hash2 = myhash2(key);
        while (table[hash1] != null
                && !table[hash1].key.equals(key)) {
            hash1 += hash2;
            hash1 %= HASH_SIZE;
        }
        table[hash1] = null;
        size--;
    }

    private int myhash1(String y) {
        int myhashVal1 = y.hashCode();
        myhashVal1 %= HASH_SIZE;
        if (myhashVal1 < 0)
            myhashVal1 += HASH_SIZE;
        return myhashVal1;
    }

    private int myhash2(String y) {
        int myhashVal2 = y.hashCode();
        myhashVal2 %= HASH_SIZE;
        if (myhashVal2 < 0)
            myhashVal2 += HASH_SIZE;
        return totalprimeSize - myhashVal2 % totalprimeSize;
    }

    public void printHashTable() {
        System.out.println("\nHash Table");
        for (int i = 0; i < HASH_SIZE; i++)
            if (table[i] != null)
                System.out.println(table[i].key + " "
                        + table[i].value);
    }
}

public class hashing {
    public static void main(String[] args) {
        System.out.println("Hash Table : ");
        HashTable ht = new HashTable(100);
        ht.insert("negative", -7);
        ht.insert("positive", 6);
        ht.insert("negative", -15);
        ht.insert("negative", 9);
        ht.insert("positive", 69);
        ht.insert("negative", -96);
        ht.printHashTable();
    }
}
