package AdventOfCode.Day3;

import java.io.*;
import java.util.ArrayList;

public class D3P1 {
    
    public static void main(String[] args) throws IOException  {

        File file = new File("AdventOfCode\\Day3\\input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;
        ArrayList<String> values = new ArrayList<>();
        
        while ((inputString = br.readLine()) != null) {
            String currentValue = inputString;
            values.add(currentValue);
        }
        br.close();

        int fileCount = values.size();
        int[] charCount = new int[12];

        for (String string : values) {
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (c == '1') {
                    charCount[i] += 1;
                }
            }
        }
        int[] gammaBinaryArray = new int[12];
        int[] epsilonBinaryArray = new int[12];
        int index = 0;
        for (Integer counts : charCount) {
            if (counts > (fileCount / 2)) {
                gammaBinaryArray[index] = 1;
                epsilonBinaryArray[index] = 0;
            } else {
                gammaBinaryArray[index] = 0;
                epsilonBinaryArray[index] = 1;
            }
            index++;
        }
        
        String gammaBinary = arrayToInt(gammaBinaryArray);
        String epsilonBinary = arrayToInt(epsilonBinaryArray);
        
        System.out.println("Gamma Binary = " + Integer.parseInt(gammaBinary,2));
        System.out.println("Epsilon Binary = " + Integer.parseInt(epsilonBinary,2));

        System.out.println("Power Consumption = " + (Integer.parseInt(gammaBinary,2)) * (Integer.parseInt(epsilonBinary,2)));
    }

    public static String arrayToInt(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int single : array) {
            String oneNum = Integer.toString(single);
            sb.append(oneNum);
        }
        String result = sb.toString();

        return result;
    }
    
}
