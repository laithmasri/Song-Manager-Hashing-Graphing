import student.TestCase;

/**
 * This is the Data Base test class.
 * 
 * @author laith21
 * @version Nov 10th
 */
public class DataBaseTest extends TestCase {

    private DataBase dataBase;

    /**
     * This sets up the tests.
     */
    public void setUp() {
        dataBase = new DataBase(6);
    }


    /**
     * This testing case checks if the insert method is working properly.
     */
    public void testInsert() {
        
        assertEquals(0, dataBase.insert("laith", "void"));
        dataBase.insert("laith02", "void02");
        dataBase.insert("laith03", "void03");
        dataBase.insert("test", "tests");
        dataBase.insert("laith", "void");
        dataBase.insert("layan", "void");
    }


    /**
     * This testing case checks if the remove method is working properly.
     */
    public void testRemove() {
        assertEquals(0, dataBase.insert("laith", "void"));
        dataBase.insert("laith", "void");
        dataBase.insert("laith", "void");
        dataBase.insert("laith", "void02");
        dataBase.remove("artist", "laith");
        dataBase.remove("artist", "laith02");
        dataBase.remove("song", "void");
        dataBase.remove("song", "void02");
        dataBase.remove("song", "void03");
    }


    /**
     * This is a testing case that checks for the advanced tests
     */
    public void testadvanced() {
        assertEquals(0, dataBase.insert("laith", "void"));
        DataBase db = new DataBase(10);
        db.insert("1", "song");
        db.insert("2", "song");
        db.insert("3", "song");
        db.insert("4", "song");
        db.insert("5", "song");
        System.out.println("~~~~");
        db.insert("6", "song");
        db.insert("7", "song");
        db.insert("8", "song");
        db.insert("9", "song");
        db.insert("10", "song");
        System.out.println("~~~~");
        db.insert("11", "song");
        db.insert("12", "song");
        db.insert("13", "song");
        db.insert("14", "song");
        db.insert("15", "song");
        db.insert("16", "song");
        db.insert("17", "song");
        db.insert("18", "song");
        db.insert("19", "song");
        db.insert("20", "song");
        System.out.println("~~~~");
        db.insert("21", "song");
    }


    /**
     * This testing case checks if the print method is working properly.
     */
    public void testPrint() {
        assertEquals(0, dataBase.insert("laith", "void"));
        dataBase.insert("laith", "void");
        dataBase.insert("laith", "void");
        dataBase.insert("laith", "void02");
        dataBase.print("artist");
        dataBase.print("song");
        dataBase.print("graph");
    }
    
    /**
     * This testing case checks for everything at once.
     */
    public void testRandom()
    {
        assertEquals(0, dataBase.insert("laith", "void"));
        dataBase.insert("Laith", "Zeus");
        dataBase.insert("Laith", "King");
        dataBase.insert("Yazan", "King");
        dataBase.remove("Artist", "Laith");
        dataBase.insert("Ward", "Sam");
        dataBase.insert("Laith", "Sam");
        dataBase.insert("Laith", "Zeus");
    }
    
    /**
     * This testing case checks if the print graph method is working fine.
     */
    public void testPrintGraph()
    {
        assertEquals(0, dataBase.insert("laith", "void"));
        System.out.println("~~~~");
        dataBase.print("graph");
        dataBase.print("graph");
        dataBase.insert("Blind Lemon Jefferson", "Long Lonesome Blues");
        dataBase.insert("Blind Lemon Jefferson", "Long Lonesome Blues");
        dataBase.insert("Blind Lemon Jefferson", "Long   Lonesome Blues");
        dataBase.insert("Blind Lemon Jefferson", "Lonesome Blues");
        dataBase.insert("Ma Rainey", "Ma Rainey's Black Bottom");
        dataBase.insert("Ma Rainey", "Long Lonesome Blues");
        dataBase.insert("Ma Rainey", "Mississippi Boweavil Blues");
        dataBase.insert("Ma Rainey", "Fixin' To Die Blues");
        System.out.println("~~~~");
        dataBase.print("graph");
        dataBase.remove("Artist", "Blind Lemon Jefferson");
        dataBase.remove("Song", "Long Lonesome Blues");
        dataBase.insert("Blind Lemon Jefferson", "Long   Lonesome Blues");
        dataBase.remove("Song", "Long Lonesome Blues");
        dataBase.remove("Artist", "Blind Lemon Jefferson");
        dataBase.remove("Artist", "Ma Rainey");
        dataBase.remove("Song", "Long Lonesome Blues");
        dataBase.print("graph");
        dataBase.remove("Song", "Long   Lonesome Blues");
        dataBase.remove("Song", "Ma Rainey's Black Bottom");
        dataBase.remove("Song", "Fixin' To Die Blues");
        dataBase.remove("Song", "Mississippi Boweavil Blues");
        dataBase.remove("Song", "Lonesome Blues");
        dataBase.remove("Song", "Lonesome Blues");
        dataBase.print("graph");
    }
}
