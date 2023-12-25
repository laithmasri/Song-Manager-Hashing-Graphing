/**
 * This is the key value pair class. I took the generic implementation of this
 * class from the OpenDSA.
 * 
 * @author laithalmasri
 * @version Sep 19th
 */
// KVPair class definition
public class KVPair {
    private String theKey;
    private int theVal;

    /**
     * This is the constructor for the class.
     * 
     * @param k
     *            Represents the key.
     * @param v
     *            Represents the value.
     */
    KVPair(String k, int v) {
        theKey = k;
        theVal = v;
    }

// /**
// * This method compared the KVPairs.
// *
// * @param it
// * Represents the KVPair to compare.
// * @return Positive if greater, negative
// * if less, and zero if equal.
// */
// public int compareTo(KVPair<K, E> it) {
// return theKey.compareTo(it.key());
// }

// /**
// * Compare KVPairs
// *
// * @param it
// * object to compare.
// * @return difference value.
// */
// public int compareTo(K it) {
// return theKey.compareTo(it);
// }


    /**
     * This is a getter method for the ket.
     * 
     * @return The key.
     */
    public String getKey() {
        return theKey;
    }


    /**
     * This is a getter method for the value.
     * 
     * @return The value.
     */
    public int getValue() {
        return theVal;
    }


    /**
     * This is a setter method for the key.
     * 
     * @param name
     *            Represents the new key.
     */
    public void setKey(String name) {
        theKey = name;
    }


    /**
     * This is a setter method for the value.
     * 
     * @param id
     *            Represents the value.
     */
    public void setValue(int id) {
        theVal = id;
    }

}
