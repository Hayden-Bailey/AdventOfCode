package AdventOfCode.Day2;

import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;

import javax.tools.ForwardingFileObject;


public class part1 {
    
    public static void main(String[] args) throws IOException {

        int horizontalPosition = 0;
        int depth = 0;

        File file = new File("AdventOfCode\\Day2\\input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;
        ArrayList<String> values = new ArrayList<>();
        

        while ((inputString = br.readLine()) != null) {
            String currentValue = inputString;
            values.add(currentValue);
        }
        br.close();

        for (String string : values) {
            String[] stringSplit = string.split(" ");
            String direction = stringSplit[0];
            int length = Integer.parseInt(stringSplit[1]);

            switch (direction) {
                case "forward":
                    horizontalPosition += length;
                    break;
                case "up":
                    depth -= length;
                    break;
                case "down":
                    depth += length;
                    break;
           }
        }


        System.out.println("Horizontal Postion = " + horizontalPosition);
        System.out.println("Depth = " + depth);

        System.out.println("Horizontal x Depth = " + (horizontalPosition * depth));
    }
}
