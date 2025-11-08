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

    public Finder() {
        HMap = new HashMap();
    }

    HashMap HMap;

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line = br.readLine();
        while (line != null) {
            line = br.readLine();
            String[] data = line.split(",");
            HMap.add(data[keyCol], data[valCol]);
        }
        br.close();


    }
    // Run constant time regardless of the size of the data table
    public String query(String key){
        String value = HMap.get(key);
        if (value == null) return INVALID;
        return value;

    }
}