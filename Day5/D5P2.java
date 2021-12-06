package AdventOfCode.Day5;

import java.io.*;
import java.util.ArrayList;

public class D5P2 {
    public static void main(String[] args) throws IOException  {
        final int X1_INDEX = 0;
        final int X2_INDEX = 2;
        final int Y1_INDEX = 1;
        final int Y2_INDEX = 3;
    
        // Extract line co-ords into Int Array
        File file = new File("AdventOfCode\\Day5\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;
        ArrayList<String[]> values = new ArrayList<>();

        while ((inputString = br.readLine()) != null) {
            String[] coords = inputString.split(" -> ");
            String[] temp1 = coords[0].split(",");
            String[] temp2 = coords[1].split(",");
            String[] finalCoords = {temp1[0],temp1[1],temp2[0],temp2[1]};
            values.add(finalCoords);
        }
        br.close();

        // Convert Strings to integers and calculate max area bounds
        ArrayList<Integer[]> coordValues = new ArrayList<>();
        int maxX = 0;
        int maxY = 0;
        for (String[] coord : values) {
            int x1 = Integer.parseInt(coord[X1_INDEX]);
            int x2 = Integer.parseInt(coord[X2_INDEX]);
            int y1 = Integer.parseInt(coord[Y1_INDEX]);
            int y2 = Integer.parseInt(coord[Y2_INDEX]);
            Integer[] coords = {x1, y1, x2, y2};
            coordValues.add(coords);
            if (x1 > maxX) {
                maxX = x1;
            }
            if (x2 > maxX) {
                maxX = x2;
            }
            if (y1 > maxY) {
                maxY = y1;
            }
            if (y2 > maxY) {
                maxY = y2;
            }
        }


        // Lay out area in a 2d array
        int[][] mapArray = new int[(maxX+1)][(maxY+1)];
        

        // Iterate through coords and update 'lines' in mapArray
        for (Integer[] coords : coordValues) {
            int x1 = coords[X1_INDEX];
            int x2 = coords[X2_INDEX];
            int y1 = coords[Y1_INDEX];
            int y2 = coords[Y2_INDEX];

            if (x1 == x2) {
                for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                    mapArray[x1][i] += 1;
                }
            } else if (y1 == y2) {
                for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                    mapArray[i][y1] += 1;
                }
            // Determine if Diagonal
            } else if (Math.abs(x1-x2) == Math.abs(y1-y2)) {
                int currentY = y1;
                if (x1 < x2) {
                    for (int i = x1; i <= x2; i++) {
                        mapArray[i][currentY] += 1;
                        if (y1 < y2) {
                            currentY += 1;
                        } else {
                            currentY -= 1;
                        }
                    }
                } else {
                    for (int i = x1; i >= x2; i--) {
                        mapArray[i][currentY] += 1;
                        if (y1 < y2) {
                            currentY += 1;
                        } else {
                            currentY -= 1;
                        }
                    }
                }
            }
        }

        // Iterate through mapArray and find number of 2s
        int num2s = 0;
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (mapArray[i][j] >= 2) {
                    num2s += 1;
                }
            }
        }

        System.out.println("Number of Intercepting Points: " + num2s);
    }
}
