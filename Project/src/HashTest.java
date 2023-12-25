import student.TestCase;

/**
 * @author laith21
 * @version Nov 10th
 */
public class HashTest extends TestCase {

    private Hash table;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        table = new Hash(6);
    }


    /**
     * This testing case checks if the insert method functions properly.
     */
    public void testInsert() {
        assertEquals(2, table.insert("laith", 0, "song"));
        assertEquals(3, table.insert("nart", 1, "song"));
        assertEquals(0, table.insert("2", 2, "song"));
        assertEquals(-1, table.insert("2", 3, "song"));
        assertEquals(6, table.insert("6", 4, "song"));
    }


    /**
     * This method checks if the remove methods works properly.
     */
    public void testRemove() {
        assertEquals(-1, table.remove("1", "song"));
        table.insert("1", 0, "song");
        assertEquals(0, table.remove("1", "song"));
        table.insert("1", 1, "song");
        table.insert("laith", 2, "song");
        table.insert("2", 3, "song");
        assertEquals(3, table.remove("2", "song"));
        assertEquals(-1, table.remove("2", "song"));
    }
    
    /**
     * This method checks if the remove methods works properly.
     */
    public void testAdvancedMethods()
    {
        Hash hash = new Hash(10);
        assertEquals(9, hash.insert("1", 0, "song"));
        hash.insert("2", 1, "song");
        hash.insert("3", 2, "song");
        hash.insert("4", 3, "song");
        hash.insert("5", 4, "song");
        System.out.println("~~~~");
        hash.insert("6", 5, "song");
        hash.insert("7", 6, "song");
        hash.insert("8", 7, "song");
        hash.insert("9", 8, "song");
        hash.insert("10", 9, "song");
        System.out.println("~~~~");
        hash.insert("11", 10, "song");
        hash.insert("12", 11, "song");
        hash.insert("13", 12, "song");
        hash.insert("14", 13, "song");
        hash.insert("15", 14, "song");
        hash.insert("16", 15, "song");
        hash.insert("17", 16, "song");
        hash.insert("18", 17, "song");
        hash.insert("19", 18, "song");
        hash.insert("20", 19, "song");
        System.out.println("~~~~");
        hash.insert("21", 20, "song");
        
    }


    /**
     * This method checks if the print method works properly.
     */
    public void testPrint() {
        table.insert("1", 0, "song");
        table.insert("2", 1, "song");
        table.insert("3", 2, "song");
        assertEquals(6, table.getSize());
        table.insert("4", 3, "song");
        assertEquals(12, table.getSize());
        table.remove("3", "song");
        table.print();
        table.insert("5", 4, "song");
        table.insert("6", 5, "song");
        assertEquals(12, table.getSize());
        table.insert("7", 6, "song");
        table.insert("8", 7, "song");
        assertEquals(24, table.getSize());
        table.remove("9", "song");
        table.print();
        table.insert("10", 8, "song");
        table.insert("11", 9, "song");
        table.insert("12", 10, "song");
        table.insert("13", 11, "song");
        table.insert("14", 12, "song");
        table.insert("15", 13, "song");
        table.insert("16", 14, "song");
        table.insert("17", 15, "song");
        table.insert("18", 16, "song");
        table.insert("20", 17, "song");
        table.insert("21", 18, "song");
        table.insert("22", 19, "song");
        table.insert("23", 20, "song");
        table.insert("24", 21, "song");
        table.insert("25", 22, "song");
        table.insert("26", 23, "song");
        table.insert("27", 24, "song");
        table.insert("28", 25, "song");
    }


    /**
     * This test checks if the getter methods are working properly.
     */
    public void testGetEntries() {
        assertEquals(table.getSize(), 6);
        assertEquals(table.getEntries(), 0);
    }


    /**
     * Check out the sfold method
     *
     * @throws Exception
     *             either a IOException or FileNotFoundException
     */
    public void testSfold() throws Exception {
        assertEquals(Hash.hashValue("a", 10000), 97);
        assertEquals(Hash.hashValue("b", 10000), 98);
        assertEquals(Hash.hashValue("aaaa", 10000), 1873);
        assertEquals(Hash.hashValue("aaab", 10000), 9089);
        assertEquals(Hash.hashValue("baaa", 10000), 1874);
        assertEquals(Hash.hashValue("aaaaaaa", 10000), 3794);
        assertEquals(Hash.hashValue("Long Lonesome Blues", 10000), 4635);
        assertEquals(Hash.hashValue("Long   Lonesome Blues", 10000), 4159);
        assertEquals(Hash.hashValue("long Lonesome Blues", 10000), 4667);
        assertEquals(8, Hash.hashValue("laith", 12));
        assertEquals(0, Hash.hashValue("leen", 12));
        assertEquals(7, Hash.hashValue("ward", 12));
        assertEquals(2, Hash.hashValue("nart", 12));
        assertEquals(2, Hash.hashValue("2", 6));
    }
}
