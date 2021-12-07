package AdventOfCode.Day6;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class D6P2 {
    public static void main(String[] args) throws IOException  {

        final int NUM_DAYS = 256;
    
        // Extract line co-ords into Int Array
        File file = new File("AdventOfCode\\Day6\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        
        String inputString;

        inputString = br.readLine();
        br.close();

        String[] stringValues = inputString.split(",");
        ArrayList<Integer> integerValues = new ArrayList<>();

        for (String string : stringValues) {
            int newValue = Integer.parseInt(string);
            integerValues.add(newValue);
        }
        Map<Integer, Long> fishDict = new HashMap<Integer,Long>();        
        Long numFish = 0L;

        for (int i = 0; i < 9; i++) {
            fishDict.put(i,0L);
        }
        for (Integer fishTimer : integerValues) {
            fishDict.put(fishTimer, (fishDict.get(fishTimer) + 1));
            
        }
        for (int i = 0; i < NUM_DAYS; i++) {
            Long newFish = fishDict.get(0);
            for (int j = 0; j < 8; j++) {
                fishDict.put(j, fishDict.get(j+1));
            }
            fishDict.put(8, newFish);
            fishDict.put(6, fishDict.get(6) + newFish);
        }
        for (int i = 0; i < 9; i++) {
            numFish += fishDict.get(i);
        }
        System.out.println("Number of fish: " + numFish);
    }
}
