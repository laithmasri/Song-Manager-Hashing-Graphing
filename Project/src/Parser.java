import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This is the File Parser.
 * 
 * @author laith21
 * @version Nov 10th
 */
public class Parser {

    private DataBase dataBase;

    /**
     * This is the constructor for the class.
     * 
     * @param hashSize
     *            Represents the size of the hash table
     * @param inputFile
     *            Represents the input file.
     * @throws FileNotFoundException
     */
    public Parser(int hashSize, String inputFile) throws FileNotFoundException {
        dataBase = new DataBase(hashSize);
        read(inputFile);
    }


    /**
     * This method is used to parse the input file.
     * 
     * @param fileName
     *            Represents the input file.
     * @throws FileNotFoundException
     */
    private void read(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        Scanner subScanner;
        String line = "";
        String command = "";
        String param = "";
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            subScanner = new Scanner(line);
            command = subScanner.next();
            if (command.equalsIgnoreCase("insert")) {
                String[] splits = line.split("<SEP>");
                String artistName = splits[0].trim();
                String songName = splits[1].trim();
                artistName = artistName.substring(7, artistName.length());
                dataBase.insert(artistName, songName);
            }
            else if (command.equalsIgnoreCase("remove")) {
                param = subScanner.next();
                String name = subScanner.nextLine().trim();
                dataBase.remove(param, name);
            }
            else {
                param = subScanner.next();
                dataBase.print(param);
            }
        }
    }


    /**
     * This method is used for testing purposes.
     * 
     * @param path
     *            Represents the file name.
     * @return The string printed into the console.
     * @throws IOException
     */
    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);

    }
}
