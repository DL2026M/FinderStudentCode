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
            // How do I wrap around here if at end
            if (key.equals(keys[elementsSize])) {
                elementsSize++;
            }
            else if (values[elementsSize] == null) {
                values[elementsSize] = value;
                keys[elementsSize] = key;
                elementsSize++;
            }
    }

    public String get(String key) {
        return null;
    }

    public void resize() {
        int oldSize = tableSize;
        tableSize = tableSize * 2;
        String[] newTable = new String[tableSize];
        String[] newValues = new String[tableSize];
        int newHash;
        for (int i = 0; i < oldSize; i++) {

            if (keys[i] == null) continue;

            // I know for sure that keys[i] is NOT null
            newHash = hash(keys[i]);

            while (newValues[i] != null) {
                i++;
                if (i >= tableSize) {
                    i = 0;
                }
            }
            newTable[newHash] = keys[i];
            newValues[newHash] = values[i];
        }
        keys = newTable;
        values = newValues;
    }
}
