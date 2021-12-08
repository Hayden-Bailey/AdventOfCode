package AdventOfCode.Day7;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class D7P1 {
    public static void main(String[] args) throws IOException  {
        int min = 0;
        int max = 0;
    
        // Extract line co-ords into Int Array
        File file = new File("AdventOfCode\\Day7\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;

        inputString = br.readLine();
        br.close();

        String[] stringValues = inputString.split(",");
        ArrayList<Integer> integerValues = new ArrayList<>();

        for (String string : stringValues) {
            int newValue = Integer.parseInt(string);
            if (newValue < min) {
                min = newValue;
            } else if (newValue > max) {
                max = newValue;
            }
            integerValues.add(newValue);
        }

        Map<Integer,Integer> fuelCosts = new HashMap<Integer,Integer>();
        for (int i = min; i < max; i++) {
            int fuel = 0;
            for (Integer intValue : integerValues) {
                fuel += Math.abs(i - intValue);
            }
            fuelCosts.put(i, fuel);
        }

        Entry<Integer,Integer> minEntry = null;
        for (Entry<Integer, Integer> entry : fuelCosts.entrySet()) {
            if (minEntry == null || minEntry.getValue() > entry.getValue()) {
                minEntry = entry;
            }
        }
        System.out.println("Distance " + minEntry.getKey() + " at fuel cost " + minEntry.getValue());

    }
}