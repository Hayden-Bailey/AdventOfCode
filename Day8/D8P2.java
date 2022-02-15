package AdventOfCode.Day8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class D8P2 {
    public static void main(String[] args) throws IOException  {
    
        // Extract line co-ords into Int Array
        File file = new File("AdventOfCode\\Day8\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String inputString;

        ArrayList<String> entries = new ArrayList<>();

        while ((inputString = br.readLine()) != null) {
            entries.add(inputString);
        }
        br.close();

        int total = 0;

        for (String a : entries) {
            ArrayList<String> signals = new ArrayList<String>();
            ArrayList<String> output = new ArrayList<String>();
            String zero="",one="",two="",three="",four="",five="",six="",seven="",eight="",nine="";

            String[] splitEntry = a.split(" | ");

            for (int i = 0; i < 10; i++) {
                signals.add(splitEntry[i]);
            }
            for (int i = 11; i < 15; i++) {
                output.add(splitEntry[i]);
            }

            for (String signal : signals) {
                if (signal.length() == 2) {
                    one = signal;
                } else if (signal.length() == 3) {
                    seven = signal;
                } else if (signal.length() == 4) {
                    four = signal;
                } else if (signal.length() == 7) {
                    eight = signal;
                }
            }
            signals.remove(one);
            signals.remove(four);
            signals.remove(seven);
            signals.remove(eight);

            for (String signal : signals) {
                String[] signalSplit = signal.split("");
                // Sort for lengths 5 & 6
                if (signal.length() == 5) {
                    int threeCount = 0;
                    String[] sevSplit = seven.split("");
                    for (String c : sevSplit) {
                        for (String s : signalSplit) {
                            if (c.equals(s)) {
                                threeCount++;
                            }
                        }
                    }
                    
                    if (threeCount == 3) {
                        three = signal;
                    } else {
                        int fiveCount = 0;
                        String[] fourSplit = four.split("");
                        for (String c : fourSplit) {
                            for (String s : signalSplit) {
                                if (c.equals(s)) {
                                    fiveCount++;
                                }
                            }
                        }
                        if (fiveCount == 3) {
                            five = signal;
                        } else {
                            two = signal;
                        }
                    }
                } else {
                    int nineCount = 0;
                    String[] fourSplit = four.split("");
                    for (String c : fourSplit) {
                        for (String s : signalSplit) {
                            if (c.equals(s)) {
                                nineCount++;
                            }
                        }
                    }

                    if (nineCount == 4) {
                        nine = signal;
                    } else {
                        int zeroCount = 0;
                        String[] sevSplit = seven.split("");
                        for (String c : sevSplit) {
                            for (String s : signalSplit) {
                                if (c.equals(s)) {
                                    zeroCount++;
                                }
                            }
                        }
                        if (zeroCount == 3) {
                            zero = signal;
                        } else {
                            six = signal;
                        }
                    }
                }
            }
            char char0Array[] = zero.toCharArray();
            Arrays.sort(char0Array);
            zero = new String(char0Array);
            char char1Array[] = one.toCharArray();
            Arrays.sort(char1Array);
            one = new String(char1Array);
            char char2Array[] = two.toCharArray();
            Arrays.sort(char2Array);
            two = new String(char2Array);
            char char3Array[] = three.toCharArray();
            Arrays.sort(char3Array);
            three = new String(char3Array);
            char char4Array[] = four.toCharArray();
            Arrays.sort(char4Array);
            four = new String(char4Array);
            char char5Array[] = five.toCharArray();
            Arrays.sort(char5Array);
            five = new String(char5Array);
            char char6Array[] = six.toCharArray();
            Arrays.sort(char6Array);
            six = new String(char6Array);
            char char7Array[] = seven.toCharArray();
            Arrays.sort(char7Array);
            seven = new String(char7Array);
            char char8Array[] = eight.toCharArray();
            Arrays.sort(char8Array);
            eight = new String(char8Array);
            char char9Array[] = nine.toCharArray();
            Arrays.sort(char9Array);
            nine = new String(char9Array);

            ArrayList<Integer> intOutput = new ArrayList<Integer>();
            for (String s : output) {
                char charArray[] = s.toCharArray();
                Arrays.sort(charArray);
                s = new String(charArray);
                if (s.equals(zero)) {
                    intOutput.add(0);
                } else if (s.equals(one)) {
                    intOutput.add(1);
                } else if (s.equals(two)) {
                    intOutput.add(2);
                } else if (s.equals(three)) {
                    intOutput.add(3);
                } else if (s.equals(four)) {
                    intOutput.add(4);
                } else if (s.equals(five)) {
                    intOutput.add(5);
                } else if (s.equals(six)) {
                    intOutput.add(6);
                } else if (s.equals(seven)) {
                    intOutput.add(7);
                } else if (s.equals(eight)) {
                    intOutput.add(8);
                } else if (s.equals(nine)) {
                    intOutput.add(9);
                }
            }
            int result = 0;
            for (int i = 0; i < intOutput.size(); i++) {
                result *= 10;
                result += intOutput.get(i);
            }

            total += result;
        }

        System.out.println("Result = " + total);
    }
}