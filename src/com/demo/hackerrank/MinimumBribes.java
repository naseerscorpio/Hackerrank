package com.demo.hackerrank;

public class MinimumBribes {


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
}
