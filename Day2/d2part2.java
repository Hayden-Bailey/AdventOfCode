package AdventOfCode.Day2;

import java.io.*;
import java.util.ArrayList;

public class d2part2 {
    
    public static void main(String[] args) throws IOException  {

        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;

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
                    if (aim == 0) {
                        break;
                    } else {
                        depth += (length * aim);
                    }
                    break;
                case "up":
                    aim -= length;
                    break;
                case "down":
                    aim += length;
                    break;
           }
        }


        System.out.println("Horizontal Postion = " + horizontalPosition);
        System.out.println("Depth = " + depth);
        System.out.println("Aim = " + aim);

        System.out.println("Horizontal x Depth = " + (horizontalPosition * depth));
    }
}
