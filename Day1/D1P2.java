package AdventOfCode.Day1;

import java.io.*;
import java.util.ArrayList;


public class D1P2 {
    
    public static void main(String[] args) throws IOException {

        int previousComparison = 0;
        int currentComparison = 0;

        File file = new File("AdventOfCode\\Day1\\input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;
        ArrayList<Integer> values = new ArrayList<>();

        while ((inputString = br.readLine()) != null) {
            int currentValue = Integer.parseInt(inputString);
            values.add(currentValue);
        }
        br.close();

        int increasingCount = 0;
        int decreasingCount = 0;
        int equalCount = 0;

        int currentIndex = 0;        
        try {
            for (Integer integer : values) {
                currentComparison = integer + values.get(currentIndex + 1) + values.get(currentIndex + 2);
                if (previousComparison == 0){

                } else if (currentComparison > previousComparison) {
                    increasingCount += 1;
                } else if (currentComparison < previousComparison) {
                    decreasingCount += 1;
                } else if (currentComparison == previousComparison) {
                    equalCount += 1;
                }
                previousComparison = currentComparison;
                currentIndex += 1;
            }        
        } catch (Exception indexOutOfBoundsException) {
            }
        

        System.out.println("Increasing Count: " + increasingCount);
        System.out.println("Decreasing Count: " + decreasingCount);
        System.out.println("Equal Count: " + equalCount);
    
    }
}
