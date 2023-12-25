import student.TestCase;

/**
 * This is the testing class for the Graph.
 * 
 * @author laith21
 * @version Nov 26th
 */
public class GraphTest extends TestCase {
    
    private Graph g;
    
    /**
     * This method initiates the graph.
     */
    public void setUp()
    {
        g = new Graph(10);
    }
    
    /**
     * This test checks if adding two nodes and linking them is working.
     */
    public void testAddNodeAndEdge()
    {
        assertEquals(0, g.addNode());
        assertEquals(1, g.addNode());
        assertFalse(g.hasEdge(0, 1));
        g.addEdge(0, 1);
        assertTrue(g.hasEdge(0, 1));
    }
    
    /**
     * Random
     */
    public void testRandom()
    {
        assertEquals(0, g.addNode());
        assertEquals(1, g.addNode());
        g.print();
        g.removeNode(0);
        g.print();
        g.removeNode(1);
        g.print();
    }
    
    
    /**
     * Random
     */
    public void testRemoveNode()
    {
        assertEquals(0, g.addNode());
        assertEquals(1, g.addNode());
        g.addEdge(0, 1);
        g.removeNode(0);
        assertEquals(0, g.addNode());
        assertEquals(2, g.addNode());
        assertEquals(3, g.addNode());
        assertEquals(4, g.addNode());
        assertEquals(5, g.addNode());
        assertEquals(6, g.addNode());
        assertEquals(7, g.addNode());
        assertEquals(8, g.addNode());
        assertEquals(9, g.addNode());
        assertEquals(10, g.addNode());
    }

}
