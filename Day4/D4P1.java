package AdventOfCode.Day4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D4P1 {
    public static void main(String[] args) throws IOException  {
        // Extract Bingo Numbers into Int Array
        File file = new File("AdventOfCode\\Day4\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String inputString = br.readLine();
        String[] questionOrder = inputString.split(",");
        int[] bingoNumbers = new int[questionOrder.length];
        for (int i = 0; i < questionOrder.length; i++) {
            bingoNumbers[i] = Integer.parseInt(questionOrder[i]);
        }
        br.close();

        // Extract Bingo Boards into Arraylist of 2d integer arrays
        ArrayList<int[][]> bingoBoards = new ArrayList<int[][]>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        saveBingoBoards(bingoBoards, reader);
        
        boolean bingo = false;
        int boardNum = 0;
        int sum = 0;
        int finalScore = 0;
        // Iterate through Bingo Numbers, replace Bingo number on boards with '0'
        while (!bingo) {
            for (Integer number : bingoNumbers) {
                // Replace bingo number on all boards
                for (int[][] bingoBoard : bingoBoards) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (bingoBoard[i][j] == number) {
                                bingoBoard[i][j] = 0;
                            }
                        }
                    }
                }
    
                // Within for loop, add check to all boards for bingo
                boardNum = 0;
                for (int[][] bingoBoard : bingoBoards) {
                    for (int i = 0; i < 5; i++) {
                        if (bingoBoard[0][i] == 0) {
                            if (bingoBoard[1][i] == 0) {
                                if (bingoBoard[2][i] == 0) {
                                    if (bingoBoard[3][i] == 0) {
                                        if (bingoBoard[4][i] == 0) {
                                            bingo = true;
                                            for (int j = 0; j < 5; j++) {
                                                for (int x = 0; x < 5; x++) {
                                                    sum += bingoBoard[j][x];
                                                }
                                            }
                                            finalScore = sum * number;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (int i = 0; i < 5; i++) {
                        if (bingoBoard[i][0] == 0) {
                            if (bingoBoard[i][1] == 0) {
                                if (bingoBoard[i][2] == 0) {
                                    if (bingoBoard[i][3] == 0) {
                                        if (bingoBoard[i][4] == 0) {
                                            bingo = true;
                                            for (int j = 0; j < 5; j++) {
                                                for (int x = 0; x < 5; x++) {
                                                    sum += bingoBoard[j][x];
                                                }
                                            }
                                            finalScore = sum * number;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (bingo) {
                        break;
                    }
                    boardNum++;
                }
                if (bingo) {
                    break;
                }
            }
        }
        
        System.out.println("Winning Board = " + boardNum);
        System.out.println("Winning Board Sum = " + sum);
        System.out.println("Final Score = " + finalScore);
    }


    private static void saveBingoBoards(ArrayList<int[][]> bingoBoards, BufferedReader reader) throws IOException {
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
