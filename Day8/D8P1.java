package AdventOfCode.Day8;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class D8P1 {
    public static void main(String[] args) throws IOException  {
    
        // Extract line co-ords into Int Array
        File file = new File("AdventOfCode\\Day8\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;

        ArrayList<String[]> signalPatterns = new ArrayList<>();
        ArrayList<String[]> outputValues = new ArrayList<>();

        while ((inputString = br.readLine()) != null) {
            String[] lightInput = inputString.split(" ");
            String[] signals = {lightInput[0],lightInput[1],lightInput[2],lightInput[3],lightInput[4],lightInput[5],lightInput[6],lightInput[7],lightInput[8],lightInput[9]};
            String[] outputs = {lightInput[11],lightInput[12],lightInput[13],lightInput[14]};
            signalPatterns.add(signals);
            outputValues.add(outputs);
        }
        br.close();

        int count = 0;
        for (String[] a : outputValues) {
            for (String s : a) {
                if (s.length() == 2 || s.length() == 4 || s.length() == 3 || s.length() == 7) {
                    count++;
                }
            }
        }

        System.out.println("Number of instances: " + count);
    }
}