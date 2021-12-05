package AdventOfCode.Day3;

import java.io.*;
import java.util.ArrayList;

public class D3P2 {

    public static void main(String[] args) throws IOException  {

        // Extract contents from File
        File file = new File("AdventOfCode\\Day3\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;
        ArrayList<String> originalValues = new ArrayList<>();
        
        while ((inputString = br.readLine()) != null) {
            String currentValue = inputString;
            originalValues.add(currentValue);
        }
        br.close();

        // Copy ArrayList and iterate through bits, removing least common
        ArrayList<String> oxygenList = new ArrayList<>(originalValues);

        double charCount = 0.0;
        int index = 0;
        while (oxygenList.size() > 1) {
            double listSize = oxygenList.size();
            for (String string : oxygenList) {
                char c = string.charAt(index);
                if (c == '1') {
                    charCount += 1;
                }
            }

            if (charCount > (listSize / 2)) {
                for (int i = 0; i < oxygenList.size(); i++) {
                    char c = oxygenList.get(i).charAt(index);
                    if (c == '0') {
                        oxygenList.remove(i);
                        i--;
                    }
                }
            } else if (charCount < (listSize / 2)) {
                for (int i = 0; i < oxygenList.size(); i++) {
                    char c = oxygenList.get(i).charAt(index);
                    if (c == '1') {
                        oxygenList.remove(i);
                        i--;
                    }
                }
            } else if (charCount == (listSize / 2)) {
                for (int i = 0; i < oxygenList.size(); i++) {
                    char c = oxygenList.get(i).charAt(index);
                    if (c == '0') {
                        oxygenList.remove(i);
                        i--;
                    }
                }
            }
            index++;
            charCount = 0;
        }
        System.out.println(oxygenList);
        int oxygenGeneratorRating = Integer.parseInt(oxygenList.get(0),2);

        // Copy ArrayList and iterate through bits, removing most common
        ArrayList<String> scrubberList = new ArrayList<String>(originalValues);

        charCount = 0;
        index = 0;
        while (scrubberList.size() > 1) {
            double listSize = scrubberList.size();
            for (String string : scrubberList) {
                char c = string.charAt(index);
                if (c == '1') {
                    charCount += 1;
                }
            }

            if (charCount > (listSize / 2)) {
                for (int i = 0; i < scrubberList.size(); i++) {
                    char c = scrubberList.get(i).charAt(index);
                    if (c == '1') {
                        scrubberList.remove(i);
                        i--;
                    }
                }
            } else if (charCount < (listSize / 2)) {
                for (int i = 0; i < scrubberList.size(); i++) {
                    char c = scrubberList.get(i).charAt(index);
                    if (c == '0') {
                        scrubberList.remove(i);
                        i--;
                    }
                }
            } else if (charCount == (listSize / 2)) {
                for (int i = 0; i < scrubberList.size(); i++) {
                    char c = scrubberList.get(i).charAt(index);
                    if (c == '1') {
                        scrubberList.remove(i);
                        i--;
                    }
                }
            }
            index++;
            charCount = 0;
        }
        System.out.println(scrubberList);
        int coScrubberRating = Integer.parseInt(scrubberList.get(0),2);

        System.out.println("Oxygen Rating: "+ oxygenGeneratorRating);
        System.out.println("CO2 Scrubber Rating: " + coScrubberRating);

        System.out.println("Life Support Rating = " + (oxygenGeneratorRating * coScrubberRating));
    }
}
    
