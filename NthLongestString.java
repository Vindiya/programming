/**
Given a collection of strings, write a method to determine the nTh longest string in that list.
Example: {Yuri, Interview, Nordstrom, Cat, Dog, Telephone, AVeryLongString, This code puzzle is easy}
if multiple then print lexicographically smallest first
nTh = 1 > would return "This code puzzle is easy".

This is an interview question at Nordstrom.
 */
 import java.util.*;
 class tempCodeRunner {
    public static void main(String args[]) {
        String[] input = new String[]{"Yuri", "Interview", "Nordstrom", "Cat", "Dog", "Telephone", "AVeryLongString", "This code puzzle is easy"};
        String expected1 = "This code puzzle is easy";
        String expected2 = "AVeryLongString";
        String expected3 = "Interview";
        String expected4 = "Nordstrom";
        String output = nthLongestString(input, 1);
        System.out.println(output);
        System.out.println(output.equals(expected1));
    }
    public static String nthLongestString(String[] input, int n) {
        if(n>=input.length) {
            return null;
        }
        Arrays.sort(input, (a, b)-> {
            if(a.length()==b.length()) {
                return a.compareTo(b);
            }
            return b.length()-a.length();
        });
        return input[n-1];
    }
 }