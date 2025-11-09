public class HashMap {
    // A low prime number - we don't want it too big to waste space and not too small to have to resize extra times
    private static int DEFAULT_TABLE_SIZE = 1609;
    private static final int RADIX = 256;
    private static final double LOAD_FACTOR = 0.50;
    private int tableSize;
    private int elementsSize;
    private String[] keys;
    private String[] values;

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
        elementsSize++;
        // Checks to see if the table is already 50% full
        if ((double) elementsSize / tableSize >= LOAD_FACTOR) {
            resize();
        }
        int newHashValue = hash(key);
        // Linear Probing used for collisions
        if (keys[newHashValue] != null) {
            while (keys[newHashValue] != null) {
                newHashValue++;
                if (newHashValue >= tableSize) {
                    newHashValue = 0;
                }
            }
        }
        // Inserting the key and value into the empty slot
        keys[newHashValue] = key;
        values[newHashValue] = value;
}

    public String get(String key) {
        int keyHash = hash(key);
        while (keys[keyHash] != null) {
            if (keys[keyHash].equals(key)) {
                return values[keyHash];
            }
            keyHash++;
            // Wrapping around if at the end of the table
            if (keyHash >= tableSize) {
                keyHash = 0;
            }
        }
        return null;
    }

    public void resize() {
        int oldSize = tableSize;
        tableSize = tableSize * 2;
        String[] oldKeys = keys;
        String[] oldValues = values;
        keys = new String[tableSize];
        values = new String[tableSize];

        elementsSize = 0;
        for (int i = 0; i < oldSize; i++) {
            if (oldKeys[i] != null) {
                add(oldKeys[i], oldValues[i]);
            }
        }
    }
}

