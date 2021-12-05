package AdventOfCode.Day5;

import java.io.*;
import java.util.ArrayList;

public class D5P1 {
    public static void main(String[] args) throws IOException  {
        final int X1_INDEX = 0;
        final int X2_INDEX = 2;
        final int Y1_INDEX = 1;
        final int Y2_INDEX = 3;
    
        // Extract line co-ords into Int Array
        File file = new File("AdventOfCode\\Day5\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;
        ArrayList<String[]> values = new ArrayList<>();

        while ((inputString = br.readLine()) != null) {
            String[] coords = inputString.split(" -> ");
            String[] temp1 = coords[0].split(",");
            String[] temp2 = coords[1].split(",");
            String[] finalCoords = new String[4];
            finalCoords[0] = temp1[0];
            finalCoords[1] = temp1[1];
            finalCoords[2] = temp2[0];
            finalCoords[3] = temp2[1];
            values.add(finalCoords);
        }
        br.close();

        
    }
}
