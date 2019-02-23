package com.demo.crackingcodinginterview;

public class PalindromePermutation {

    boolean isPalindromePermutation(String str) {

        //find occurances of each character
        // to be palindrome permutation, it shud not hv more than one odd character

        int countOdd = 0;
        int[] lettercounts = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : str.toLowerCase().toCharArray()) {
            int cInt = getCharNumber(c);
            if (cInt != -1) {
                lettercounts[cInt]++;
                if (lettercounts[cInt] % 2 == 1) {
                    countOdd++;
                } else
                    countOdd--;
            }
        }
        return (countOdd <= 1);
    }

    private int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private boolean isPalindromePermutationBitVector(String str) {
        /*
            if we think of each character as 1/0 bit and toggle the bit for each occurance, at the end
            it shud have only one 1 bit, if there is more than 1, one bit then its not a palindrome permutation
         */

        int bitVector = createBitVector(str);
        return  bitVector == 0 || checkIfExactlyOneBitSet(bitVector);
    }

    private boolean checkIfExactlyOneBitSet(int bitVector){
        return (bitVector & (bitVector-1)) == 0;
    }

    private int createBitVector(String s) {
        int bitVector = 0;
        for (char c : s.toCharArray()) {
            int index = getCharNumber(c);
            bitVector = toggle(bitVector, index);
        }
        return bitVector;
    }

    private int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = (1 << index);
        if ((bitVector & mask) == 0) {
            bitVector |= mask;//0000010
        } else {//0000010 & 1111101 = 0000000
            bitVector &= ~mask;
        }
        return bitVector;
    }


    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.isPalindromePermutation("Tact Coat"));
        System.out.println(palindromePermutation.isPalindromePermutationBitVector("Tact Coat"));
    }
}
