package com.demo.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class CheckMagazine {


    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magWords = new HashMap<>();
        for (String str :
                magazine) {
            if (!magWords.containsKey(str)) {
                magWords.put(str, 1);
            } else {
                magWords.put(str, magWords.get(str) + 1);
            }
        }

        boolean present = true;
        for (String nt : note) {
            if (!magWords.containsKey(nt) || magWords.get(nt) <= 0) {
                present = false;
                continue;
            }
            magWords.put(nt, magWords.get(nt) - 1);
        }
        System.out.println(present ? "Yes" : "No");
    }
}
