package AdventOfCode.Day6;

import java.io.*;
import java.util.ArrayList;

public class D6P1 {
    public static void main(String[] args) throws IOException  {

        final int NUM_DAYS = 80;
    
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
        System.out.println("Number of Fish = " + integerValues.size());

        int newFish = 0;
        for (int i = 0; i < NUM_DAYS; i++) {
            for (int j = 0; j < integerValues.size(); j++) {
                if (integerValues.get(j) == 0) {
                    integerValues.set(j, 6);
                    newFish += 1;
                } else {
                    integerValues.set(j, (integerValues.get(j) - 1));
                }
            }
            for (int x = 0; x < newFish; x++) {
                integerValues.add(8);
            }
            newFish = 0;
        }

        System.out.println("Number of Fish = " + integerValues.size());
    }
}
