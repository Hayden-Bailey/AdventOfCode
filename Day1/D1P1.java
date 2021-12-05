package AdventOfCode.Day1;

import java.io.*;


public class D1P1 {
    public static void main(String[] args) throws IOException {
        int currentDepth = 0;
        int previousDepth = 0;

        File file = new File("AdventOfCode\\Day1\\input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;

        int increasingCount = 0;
        int decreasingCount = 0;
        int equalCount = 0;

        while ((inputString = br.readLine()) != null) {
            currentDepth = Integer.parseInt(inputString);
            if (previousDepth == 0) {
            } else if (currentDepth > previousDepth) {
                increasingCount += 1;
            } else if (currentDepth < previousDepth) {
                decreasingCount += 1;
            } else if (currentDepth == previousDepth) {
                equalCount += 1;
            }
            previousDepth = currentDepth;
        }
        br.close();

        System.out.println("Increasing Count: " + increasingCount);
        System.out.println("Decreasing Count: " + decreasingCount);
        System.out.println("Equal Count: " + equalCount);
        
    }
}
