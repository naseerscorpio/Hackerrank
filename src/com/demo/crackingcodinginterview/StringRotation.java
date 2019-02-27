package com.demo.crackingcodinginterview;

public class StringRotation {

    private boolean isRotatedString(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private boolean isSubstring(String s1, String s2) {
        return true;
    }

    public static void main(String[] args) {
        StringRotation stringRotation = new StringRotation();
        System.out.println(stringRotation.isRotatedString("waterbottle", "erbottlewat"));
    }
}
