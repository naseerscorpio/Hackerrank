package com.demo.hackerrank;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HackerRank {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr);
        /*
            As the array has been sorted, so we need to consider the difference between
            only the consecutive elements. In a sorted array, the difference will increase
            if you skip elements to calculate the difference.
         */
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff,Math.abs(arr[i]-arr[i-1]));
        }
        return minDiff;
    }

    /*
        1. Recursive Solution
        2. Memorize Intermediate results
        3. Bottom-up
     */
    static int commonChild(String a, String b) {
        int C[][] = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    C[i + 1][j + 1] = 1 + C[i][j];
                } else {
                    C[i + 1][j + 1] = Math.max(C[i + 1][j], C[i][j + 1]);
                }
            }
        }
        return C[a.length()][b.length()];
    }


    // Complete the substrCount function below.
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

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> lettercounts = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            if (lettercounts.containsKey(c)) {
                lettercounts.put(c, lettercounts.get(c) + 1);
            } else {
                lettercounts.put(c, 1);
            }
            max = Math.max(max, lettercounts.get(c));
        }

        for (Map.Entry m : lettercounts.entrySet())
            min = Math.min(min, (int) m.getValue());

        int maxCount = 0;
        int minCount = 0;
        for (int count : lettercounts.values()) {
            if (count == max) {
                maxCount++;
            } else if (count == min) {
                minCount++;
            }
        }

        if (max - min == 0 || (maxCount == lettercounts.size() - 1 && min == 1)
                || (minCount == lettercounts.size() - 1 && max - min == 1)) {
            return "YES";
        }
        return "NO";
    }

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        if (s.length() <= 1) return 0;

        char s0 = s.toCharArray()[0];
        int deletions = 0;
        for (int i = 1; i < s.length(); i++) {
            char s1 = s.charAt(i);
            if (s0 == s1) {
                deletions++;
            }
            s0 = s1;
        }
        return deletions;
    }


    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int[] lettercounts = new int[26];
        for (char c : a.toCharArray()) {
            lettercounts[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            lettercounts[c - 'a']--;
        }
        int result = 0;
        for (int i : lettercounts) {
            result += Math.abs(i);
        }
        return result;
    }

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return countInversions(arr, 0, arr.length);
    }

    static long countInversions(int[] arr, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return 0;

        long count = 0;

        int middle = (leftStart + rightEnd) / 2;
        count += countInversions(arr, leftStart, middle);
        count += countInversions(arr, middle + 1, rightEnd);
        count += merge(arr, leftStart, rightEnd);

        return count;
    }

    static long merge(int[] arr, int start, int end) {

        int mid = (start + end) / 2;
        int[] newArr = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = start;
        long count = 0;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                newArr[k++] = arr[j++];
                count += mid - i + 1;
            } else {
                newArr[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            newArr[k++] = arr[i++];
        }
        while (j <= end) {
            newArr[k++] = arr[j++];
        }

        System.arraycopy(newArr, 0, arr, start, end - start + 1);
        return count;
    }


    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        LinkedList<Integer> q = new LinkedList<>();
        int[] freq = new int[201];

        for (int i = 0; i < expenditure.length; i++) {
            while (i < d) {
                q.add(expenditure[i]);
                freq[expenditure[i]] = freq[expenditure[i]] + 1;
                i++;
            }

            float median = getMedian(freq, d);

            if (expenditure[i] >= 2 * median) {
                count++;
            }

            int head = q.remove();
            freq[head] = freq[head] - 1;
            q.add(expenditure[i]);
            freq[expenditure[i]] = freq[expenditure[i]] + 1;
        }
        return count;
    }

    private static float getMedian(int[] freq, int d) {
        if (d % 2 == 1) {
            int center = 0;
            for (int i = 0; i < freq.length; i++) {
                center += freq[i];
                if (center > d / 2) {
                    return i;
                }
            }
        } else {
            int count = 0;
            int first = -1;
            int second = -1;

            for (int i = 0; i < freq.length; i++) {
                count += freq[i];

                if (count == d / 2) {
                    first = i;
                } else if (count > d / 2) {
                    if (first < 0)
                        first = i;
                    second = i;
                    return (((float) first) + ((float) second)) / 2;
                }
            }

        }
        return 0f;
    }

    static double calculateMedian(int[] arr, int start, int end) {
        int[] selected = new int[end - start + 1];
        int index = 0;
        for (int i = start; i < end; i++) {
            selected[index++] = arr[i];
        }
        Arrays.sort(selected);

        int middle = selected.length / 2;
        if (selected.length % 2 == 1) {
            return selected[middle];
        } else {
            return (selected[middle - 1] + selected[middle]) / 2.0;
        }
    }


    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        HashMap<Integer, Function<Integer, Boolean>> mapa = new HashMap<>();
        mapa.put(1, o -> data.add(o));
        mapa.put(2, o -> data.remove(o));
        mapa.put(3, o -> {
            Map<Integer, Long> counts = data.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            return result.add(counts.containsValue(new Long(o)) ? 1 : 0);
        });
        queries.forEach(integers -> {
            mapa.get(integers.get(0)).apply(integers.get(1));
        });
        return result;
    }


    private class Player {
        public String name;
        public int score;
    }

    class Checker implements Comparator<Player> {
        // complete this method
        public int compare(Player a, Player b) {
            if (a.score > b.score) {
                return -1;
            } else if (a.score < b.score) {
                return 1;
            } else {
                return a.name.compareTo(b.name);
            }
        }
    }


    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int count = 0;
        Arrays.sort(prices);
        Long sum = 0L;
        for (int price : prices) {
            sum += price;
            if (sum <= k) {
                count++;
            }
        }
        return count;
    }

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        //[6,4,1]
        int swaps = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println(swaps);
    }

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        /*
        # stores number of tuples with two elements that can be formed if we find the key
         */
        Map<Long, Long> t2 = new HashMap<>();
        /*
         # stores number of tuples with three elements that can be formed if we find the key
         */
        Map<Long, Long> t3 = new HashMap<>();
        long result = 0L;

        for (Long a : arr) {
            /*
             # k completes the three tuples given we have already found k/(r^2) and k/r
             */
            result += t3.getOrDefault(a, 0L);
            if (t2.containsKey(a)) {
            /*
              # For any element of array we can form three element tuples if we find k*r given k / r is already found. Also k forms the second element.
             */
                t3.put(a * r, t3.getOrDefault(a * r, 0L) + t2.get(a));
            }
            /*
             # For any element of array we can form two element tuples if we find k*r. Also k forms the first element.
             */
            t2.put(a * r, t2.getOrDefault(a * r, 0L) + 1);
        }
        return result;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        //for each length of sliding window
        for (int i = 1; i < s.length(); i++) {
            //starting  index
            Map<String, Integer> found = new HashMap<>();
            for (int j = 0; j + i < s.length(); j++) {
                String substr = s.substring(j, j + i);
                substr = Arrays.stream(substr.split("")).sorted()
                        .collect(Collectors.joining(""));
                if (found.containsKey(substr)) {
                    count += found.get(substr);
                    found.put(substr, found.get(substr) + 1);
                } else {
                    found.put(substr, 1);
                }
            }
        }
        return count;
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        boolean distinct = true;
        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            if (s1.indexOf(c) > 0 && s2.indexOf(c) > 0) {
                distinct = false;
                break;
            }
        }
        return distinct ? "Yes" : "No";
    }


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


    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        long max = 0;
        int a = 0;
        int b = 0;
        int k = 0;
        int m = queries.length;

        for (int i = 0; i < m; i++) {
            a = queries[i][0] - 1;
            b = queries[i][1] - 1;
            k = queries[i][2];
            arr[a] += k;
            if (b + 1 < n)
                arr[b + 1] -= k;
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    static int minimumSwaps(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        int swaps = 0;
        while (first < last) {
            while (arr[first] == first + 1 && first < last) {
                first++;
            }
            while (arr[last] == last + 1 && first < last) {
                last--;
            }

            if (first < last) {
                int temp = arr[arr[first] - 1];
                arr[arr[first] - 1] = arr[first];
                arr[first] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribes = 0;
        //1,2,3,4,5 ---> 2 1 5 3 4
        //2 5 1 3 4
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            /*
                start the nested loop from q[i] - 2 instead of 0. Since no one
                can jump ahead of its original position by more than 2, so any value higher than q[i]
                can only be till index q[i] -2.
                i=4
                q[i] = 4
                j=2
                q[j] = 5

                --
                j=3
                q[j] = 3

             */

            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) bribes++;
            }
        }
        System.out.println(bribes);
    }

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] rot = new int[a.length];
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            rot[(n + i - d) % n] = a[i];
        }
        return rot;
    }

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int valleys = 0;
        int mountains = 0;

        int counter = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'U') {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0) {
                if (ch == 'D') {
                    mountains++;
                } else {
                    valleys++;
                }
            }
        }
        return valleys;
    }


    static int jumpingOnClouds(int[] c) {
        int steps = 0;
        int idx = 0;
        while (idx < c.length - 1) {
            if (idx + 2 < c.length && c[idx + 2] != 1) {
                steps++;
                idx += 2;
            } else {
                idx += 1;
                steps++;
            }
        }
        return steps;
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long numOfS = n / s.length();
        long rest = n % s.length();

        if (!s.contains("a")) return 0;
        return s.length() > n ? aCounter(s, rest)
                : numOfS * aCounter(s, s.length()) + aCounter(s, rest);
    }

    private static long aCounter(String s, long end) {
        int a = 0;
        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == 'a') a++;
        }
        return a;
    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        Map<Integer, Integer> map = new HashMap();
        int result = 0;
        int count = 0;
        for (int i : ar) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        for (int key : map.keySet()) {
            result += map.get(key) / 2;
        }
        return result;
    }


    public static void main(String[] args) {
       /* int[] a = {1, 2, 3, 4, 5};
        rotLeft(a, 4);*/
        /*final Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);
        scanner.close();*/

        /*int[] a = {1, 3, 5, 2, 4, 6, 7};
        minimumSwaps(a);*/
        // countTriplets(Arrays.asList(new Long[]{1L, 3L, 9L, 9L}), 3);

       /* int[] a = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        activityNotifications(a, 5);*/

        // makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");

        // isValid("aabbcd");
        substrCount(4, "aaaa");

    }
}
