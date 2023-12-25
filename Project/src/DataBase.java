/**
 * This is the Data Base class.
 * 
 * @author laith21
 * @version Nov 10th
 */
public class DataBase {

    private Hash artistTable;
    private Hash songTable;
    private Graph graph;

    /**
     * This is the constructor.
     * 
     * @param hashSize
     *            Represents the size of the hash table.
     */
    public DataBase(int hashSize) {
        artistTable = new Hash(hashSize);
        songTable = new Hash(hashSize);
        graph = new Graph(hashSize);
    }


    /**
     * This is the insert method.
     * 
     * @param artistName
     *            Represents the artist's name.
     * @param songName
     *            Represents the song's name.s
     * @return  -1 if a duplicate is found, and 0 otherwise.
     */
    public int insert(String artistName, String songName) {
        int artistIndex = artistTable.find(artistName);
        int songIndex = songTable.find(songName);
        if (artistIndex == -1) {
            artistIndex = graph.addNode();
            artistTable.insert(artistName, artistIndex, "Artist");
        }
        if (songIndex == -1) {
            songIndex = graph.addNode();
            songTable.insert(songName, songIndex, "Song");
        }
        if (!graph.hasEdge(artistIndex, songIndex)) {
            graph.addEdge(artistIndex, songIndex);
        }
        else {
            System.out.println("|" + artistName + "<SEP>" + songName
                + "| duplicates a record already in the database.");
            return -1;
        }
        return 0;
    }


    /**
     * This is the remove method.
     * 
     * @param param
     *            Represents either the artist or song parameter.
     * @param name
     *            Represents the name of either the artist or the song.
     */
    public void remove(String param, String name) {
        if (param.equalsIgnoreCase("artist")) {
            int removedIndex = artistTable.remove(name, "Artist");
            if (removedIndex >= 0)
            {
                graph.removeNode(removedIndex);
            }
        }
        else {
            int removedIndex = songTable.remove(name, "Song");
            if (removedIndex >= 0)
            {
                graph.removeNode(removedIndex);
            }
        }
    }


    /**
     * This is the print method.
     * 
     * @param param
     *            Represents the kind of thing that we should print.
     */
    public void print(String param) {
        if (param.equalsIgnoreCase("artist")) {
            artistTable.print();
            System.out.println("total artists: " + artistTable.getEntries());
        }
        else if (param.equalsIgnoreCase("song")) {
            songTable.print();
            System.out.println("total songs: " + songTable.getEntries());
        }
        else {
            graph.print();
        }
    }
}
