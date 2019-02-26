package com.demo.crackingcodinginterview;

public class OneCharacterAway {

    private boolean check(String one, String two) {
        //insert, remove , replace
        if (one.length() - two.length() > 1) return false;

        if (one.length() == two.length()) {
            return oneCharacterReplace(one, two);
        } else if (one.length() + 1 == two.length()) {
            return oneCharacterInsert(one, two);
        } else if (one.length() - 1 == two.length()) {
            return oneCharacterInsert(two, one);
        }
        return true;
    }

    boolean oneCharacterReplace(String first, String second) {
        //pale - > bale
        boolean foundDiff = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDiff)
                    return false;
                foundDiff = true;
            }
        }
        return foundDiff;
    }

    boolean oneCharacterInsert(String s1, String s2) {
        //pales -> pale
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    boolean oneEditAway(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        /* Get shorter and longer string.*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                /* Ensure that this is the first difference found. */
                if (foundDifference) return false;

                foundDifference = true;
                if (s1.length() == s2.length()) {
                    //On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }


    public static void main(String[] args) {
        OneCharacterAway oneCharacterAway = new OneCharacterAway();
        System.out.println(oneCharacterAway.check("pale", "ple"));
    }
}
