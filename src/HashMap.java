public class HashMap {
    // A low prime number - we don't want it too big to waste space and not too small to have to resize extra times
    private int DEFAULT_TABLE_SIZE = 1009;
    private int tableSize;
    private int elementsSize;
    private String[] keys;
    private String[] values;
    private static final int RADIX = 256;

    public HashMap() {
        tableSize = DEFAULT_TABLE_SIZE;
        elementsSize = 0;
        keys = new String[DEFAULT_TABLE_SIZE];
        values = new String[DEFAULT_TABLE_SIZE];
    }
    public int hash(String key) {
        int seqHash = 0;
        // Calculating the hash for a given segment using Horner's method
        for (int i = 0; i < key.length(); i++) {
            seqHash = (seqHash * RADIX + key.charAt(i)) % tableSize;
        }
        return seqHash;
    }
    public void add(String key, String value) {
        // Checks to see if the table is already 50% full
        if ((double) elementsSize / tableSize >= 0.5) {
            resize();
        }
        while (elementsSize < tableSize - 1) {
            if (key.equals(keys[elementsSize])) {
                elementsSize++;
                if (values[elementsSize] == null) {
                    values[elementsSize] = value;
                    keys[elementsSize] = key;
                }
            }
            keys[elementsSize] = key;
            values[elementsSize] = value;
            elementsSize++;
        }
    }
    public String get(String key) {
        return key;
    }
    public void resize() {
        tableSize = tableSize * 2;
        String[] newTable = new String[tableSize];
        String[] newValues = new String[tableSize];
        for (int i = 0; i < tableSize; i++) {
            newTable[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newTable;
        values = newValues;
    }
}
