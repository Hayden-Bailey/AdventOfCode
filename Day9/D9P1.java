package AdventOfCode.Day9;

import java.io.*;


public class D9P1 {
    public static void main(String[] args) throws IOException  {

        // Count size of input values for new array
        int[] arraySize = countArraySize();

        int[][] heights = new int[arraySize[0]][arraySize[1]];

        // Extract input values into array
        File file = new File("AdventOfCode\\Day9\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int y = 0;

        String inputString;
        while ((inputString = br.readLine()) != null) {
            int x = 0;
            String[] heightString = inputString.split("");
            for (String s : heightString) {
                heights[y][x] = Integer.parseInt(s);
                x++; 
            }
            y++;
        }
        br.close();

        int total = 0;
        int x = 0;
        y = 0;
        for (int[] array : heights) {
            for (int i : array) {
                if (x == 0 && y == 0) {
                    if (i < heights[x+1][y] && i < heights[x][y+1]) {
                        total += i + 1;
                    }
                } else if (x == 0 && y == arraySize[1]-1) {
                    if (i < heights[x][y-1] && i < heights[x+1][y]) {
                        total += i + 1;
                    }
                 } else if (x == arraySize[0]-1 && y == 0) {
                     if (i < heights[x-1][y] && i < heights[x][y+1]) {
                         total += i + 1;
                     }
                 } else if (x == arraySize[0]-1 && y == arraySize[1]-1) {
                     if (i < heights[x-1][y] && i < heights[x][y-1]) {
                         total += i + 1;
                     }
                 } else if (x == 0) {
                    if (i < heights[x][y-1] && i < heights[x+1][y] && i < heights[x][y+1]) {
                        total += i + 1;
                    }
                } else if (y == 0) {
                    if (i < heights[x-1][y] && i < heights[x][y+1] && i < heights[x+1][y]) {
                        total += i + 1;
                    }
                } else if (x == arraySize[0]-1) {
                    if (i < heights[x][y-1] && i < heights[x-1][y] && i < heights[x][y+1]) {
                        total += i + 1;
                    }
                } else if (y == arraySize[1]-1) {
                    if (i < heights[x-1][y] && i < heights[x][y-1] && i < heights[x+1][y]) {
                        total += i + 1;
                    }
                } else {
                    if (i < heights [x][y-1] && i < heights[x-1][y] && i < heights[x+1][y] && i < heights[x][y+1]) {
                        total += i + 1;
                    }
                }
                    
                y++;
            }
            x++;
            y = 0;
        }

        System.out.println("Total Risk: " + total);
    }

    public static int[] countArraySize() throws IOException {
        File file = new File("AdventOfCode\\Day9\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String inputString = br.readLine();
        int x = inputString.length();
        int y = 1;
        while ((inputString = br.readLine()) != null) {
            y++;
        }
        br.close();

        int[] arraySize = {x,y};

        return arraySize;
    }
}
