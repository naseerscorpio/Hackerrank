package com.demo.crackingcodinginterview;

public class UniqueCharacters {

    private boolean isUniqueChars(String str){
        /**
         * aabbcc, abcabc
         * abcdef
         */
        if(str.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val]=true;
        }
        return false;
    }

    private boolean isUniqueCharsOptimal(String str){
        /**
         * 00000000
         * 00000001
         * 00000011
         * 00000111 & 00001000
         */
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i)-'a';
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1<<val);
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueCharacters uniqueCharacters = new UniqueCharacters();
        uniqueCharacters.isUniqueCharsOptimal("abcabc");
    }
}
