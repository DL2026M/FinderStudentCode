import java.io.BufferedReader;
import java.io.IOException;
/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: David Lutch
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        String line = br.readLine();
        while (line != null) {
            line = br.readLine();
            // call the HashMap thing
            HashMap.add(keyCol, valCol);

        }
        br.close();


    }
    // Run constant time regardless of the size of the data table
    public String query(String key){
        // TODO: Complete the query() function!

        return INVALID;
    }
}