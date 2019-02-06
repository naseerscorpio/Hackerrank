package com.demo.hackerrank;

import java.util.LinkedList;

public class ActivityNotifications {

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

}
