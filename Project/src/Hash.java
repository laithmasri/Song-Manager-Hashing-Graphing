/**
 * Hash table class
 *
 * @author laith21
 * @version Nov 10th
 */

public class Hash {
    private int size;
    private int numOfEntries;
    private KVPair[] table;

    /**
     * This is the contructor for the class.
     * 
     * @param theSize
     *            Represents the size of the hash table.
     */
    public Hash(int theSize) {
        size = theSize;
        numOfEntries = 0;
        table = new KVPair[size];
    }


    /**
     * This method is used to check if the specified item is in the table or
     * not.
     * 
     * @param name
     *            The name to look for.
     * @return The value of the item.
     */
    public int find(String name) {
        for (int x = 0; x < table.length; x++) {
            if (table[x] != null) {
                if (table[x].getKey().equals(name)) {
                    return table[x].getValue();
                }
            }
        }
        return -1;
    }


    /**
     * This is the insert method.
     * 
     * @param name
     *            Represents the name of the object to be added.
     * @param index
     *            Represents the node index.
     * @param tableType
     *            Represents the type of table we're working with.
     * @return The hash value.
     */
    public int insert(String name, int index, String tableType) {
        for (int x = 0; x < getSize(); x++) {
            if (table[x] != null) {
                if (table[x].getKey().equals(name)) {
                    return -1;
                }
            }
        }
        if (getSize() / 2 == getEntries()) {
            table = rehash(tableType);
        }
        int hashValue = hashValue(name, getSize());
        int originalPos = hashValue;
        int counter = 1;
        while (table[hashValue] != null) {
            if (table[hashValue].getKey().equals("tombstone")) {
                KVPair newPair = new KVPair(name, index);
                table[hashValue] = newPair;
                numOfEntries++;
                System.out.println("|" + name + "| is added to the " + tableType
                    + " database.");
                return hashValue;
            }
            hashValue = originalPos;
            hashValue += (counter * counter);
            hashValue = hashValue % getSize();
            counter++;

        }
        KVPair newPair = new KVPair(name, index);
        table[hashValue] = newPair;
        numOfEntries++;
        System.out.println("|" + name + "| is added to the " + tableType
            + " database.");
        return hashValue;
    }


    /**
     * This is the remove method.
     * 
     * @param name
     *            Represents the name of either the artist or the song.
     * @param tableType
     *            Represents the type of table we're working with.
     * @return True if the object is removed and false otherwise.
     */
    public int remove(String name, String tableType) {
        int hashValue = hashValue(name, getSize());
        int original = hashValue;
        int counter = 1;
        while (table[hashValue] != null) {
            if (table[hashValue].getKey().equals(name)) {
                KVPair tombstone = new KVPair("tombstone", table[hashValue]
                    .getValue());
                table[hashValue] = tombstone;
                numOfEntries--;
                System.out.println("|" + name + "| is removed from the "
                    + tableType + " database.");
                return table[hashValue].getValue();
            }
            hashValue = original;
            hashValue += counter * counter;
            hashValue = hashValue % getSize();
            counter++;
        }
        System.out.println("|" + name + "| does not exist in the " + tableType
            + " database.");
        return -1;
    }


    /**
     * This is the print method.
     */
    public void print() {
        for (int x = 0; x < getSize(); x++) {
            if (table[x] != null) {
                if (table[x].getKey().equals("tombstone")) {
                    System.out.println(x + ": TOMBSTONE");
                }
                else {
                    System.out.println(x + ": |" + table[x].getKey() + "|");
                }

            }
        }
    }


    /**
     * This is a getter method for the size of the hash table.
     * 
     * @return The size of the hash table.
     */
    public int getSize() {
        return size;
    }


    /**
     * This is a getter method for the number of entries.
     * 
     * @return The number of entries.
     */
    public int getEntries() {
        return numOfEntries;
    }


    /**
     * This method is used to rehash the entries
     * into a new table with double the size.
     */
    private KVPair[] rehash(String tableType) {
        KVPair[] newArray = new KVPair[getSize() * 2];

        size = newArray.length;
        for (int x = 0; x < table.length; x++) {
            if (table[x] != null) {
                if (!table[x].getKey().equals("tombstone")) {
                    int counter = 1;
                    int hashValue = hashValue(table[x].getKey(),
                        newArray.length);
                    int originalPos = hashValue;
                    while (newArray[hashValue] != null) {
                        hashValue = originalPos;
                        hashValue += (counter * counter);
                        hashValue = hashValue % newArray.length;
                        counter++;
                    }
                    KVPair newPair = new KVPair(table[x].getKey(), table[x]
                        .getValue());
                    newArray[hashValue] = newPair;
                }
            }
        }
        if (tableType.equalsIgnoreCase("song")) {
            System.out.println("Song hash table size doubled.");
        }
        else {
            System.out.println("Artist hash table size doubled.");
        }
        return newArray;
    }


    /**
     * Compute the hash function
     * 
     * @param s
     *            The string that we are hashing
     * @param length
     *            Length of the hash table (needed because this method is
     *            static)
     * @return
     *         The hash function value (the home slot in the table for this key)
     */
    public static int hashValue(String s, int length) {
        int intLength = s.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) {
            char[] c = s.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            for (int k = 0; k < c.length; k++) {
                sum += c[k] * mult;
                mult *= 256;
            }
        }

        char[] c = s.substring(intLength * 4).toCharArray();
        long mult = 1;
        for (int k = 0; k < c.length; k++) {
            sum += c[k] * mult;
            mult *= 256;
        }

        return (int)(Math.abs(sum) % length);
    }

}
