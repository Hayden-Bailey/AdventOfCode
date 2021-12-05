package AdventOfCode.Day4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D4P1 {
    public static void main(String[] args) throws IOException  {
        File file = new File("AdventOfCode\\Day4\\input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String inputString = br.readLine();
        String[] questionOrder = inputString.split(",");
        br.close();

        ArrayList<int[][]> bingoBoards = new ArrayList<int[][]>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();

        while (reader.readLine() != null) {
            int[][] arr = new int[5][5];
            for (int i = 0; i < 5; i++) {
                String[] numLine = reader.readLine().split(" ");
                List<String> list = new ArrayList<String>(Arrays.asList(numLine));
                int numSpaces = 0;
                for (String string : list) {
                    if (string == "") {
                        numSpaces++;
                    }
                }
                for (int x = 0; x < numSpaces; x++) {
                    list.remove("");
                }
                numLine = list.toArray(new String[0]);                
            
                for (int j = 0; j < 5; j++) {
                    arr[i][j] = Integer.parseInt(numLine[j]);
                }
            }
            bingoBoards.add(arr);
        }
        reader.close();

        
    }
}
