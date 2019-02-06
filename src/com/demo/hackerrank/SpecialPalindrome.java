package com.demo.hackerrank;

public class SpecialPalindrome {


    static long substrCount(int n, String s) {

        long count = 0;
        long strCount = n; // include all single letters

        for (int i = 1; i < n; i++) {

            // count palindromes made up of the same letter
            if (s.charAt(i) == s.charAt(i - 1)) {
                System.out.println(s.substring(i - 1, i + 1));
                count++;
            }
            // count two letter palindromes
            else {
                // reset and prepare the counter for the two-letter palindrome.
                count = 0;
                // keep track of left and right side of palindrome
                int right = i + 1;
                int left = i - 1;

                // start comparing both sides of palindrome with 2 chars
                while (left >= 0 && right < n) {
                    // compare left and right index against a char next to
                    // the middle one (they should all be the same,
                    // only the middle character should be a different one)
                    if (s.charAt(left) == s.charAt(i - 1) &&
                            s.charAt(right) == s.charAt(i - 1)) {

                        System.out.println(s.substring(left, right + 1));
                        // if the letters are the same, advance the
                        // indexes and the palindrome counter
                        count++;
                        left--;
                        right++;
                    } else break;
                }
            }
            // add the palindrome count for the current iteration to the total.
            strCount += count;
        }
        System.out.println(strCount);
        return strCount;
    }
}
