/*
 * Problem: Find the Missing Number
 * 
 * Difficulty: Easy
 * Topic: Arrays, Strings
 * 
 * Problem Statement:
 * You are given a string s that represents a concatenation of all integers from
 * 1 to n in random order with one number missing. Your task is to return the
 * missing number.
 * 
 * Constraints:
 * 1 <= n <= 100
 * 
 * The string's contains all digits of the numbers from 1 to n, except one
 * number, and in random order.
 * The string contains no spaces or delimiters, and no leading zeroes.
 * 
 * Example:
 * Input:
 * s = "234567891011"
 * n = 11
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * All numbers from 1 to 11 should be in the string (in any order),
 * but 1 is missing.
 */

import java.util.*;

public class MissingNumber {

    // Set to track numbers we've successfully parsed
    static Set<Integer> found = new HashSet<>();

    public static int findMissingNumber(String s, int n) {
        found.clear();
        backtrack(s, n, 0, new ArrayList<>());
        
        // After backtracking, check which number from 1 to n is missing
        for (int i = 1; i <= n; i++) {
            if (!found.contains(i)) {
                return i;
            }
        }
        return -1; // Fallback (shouldn’t happen under constraints)
    }

    // Recursive backtracking function
    public static void backtrack(String s, int n, int index, List<Integer> path) {
        if (index == s.length()) {
            // Found a complete partition, record all numbers in this path
            found.addAll(path);
            return;
        }

        // Try every possible split of 1 to 3 digits
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String part = s.substring(index, index + i);
            if (part.startsWith("0")) continue; // Skip leading zeroes

            int num = Integer.parseInt(part);
            if (num > n || path.contains(num)) continue;

            path.add(num);
            backtrack(s, n, index + i, path);
            path.remove(path.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        String s = "234567891011";
        int n = 11;

        int missing = findMissingNumber(s, n);
        System.out.println("Missing number is: " + missing);
    }
}