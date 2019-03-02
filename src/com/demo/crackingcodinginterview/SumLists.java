package com.demo.crackingcodinginterview;

public class SumLists {

    class PartialSum {
        int carry = 0;
        LinkedListNode sum = null;
    }

    private LinkedListNode sumLists(LinkedListNode l1, LinkedListNode l2) {
        int len1 = len(l1);
        int len2 = len(l2);
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        PartialSum sum = addListsHelper(l1, l2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            return insertBefore(sum.sum, sum.carry);
        }
    }

    private PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        PartialSum sum = addListsHelper(l1.next, l2.next);

        int val = sum.carry + l1.data + l2.data;

        LinkedListNode result = insertBefore(sum.sum, val % 10);
        sum.sum = result;
        sum.carry = val / 10;

        return sum;
    }

    private LinkedListNode padList(LinkedListNode l, int n) {
        for (int i = 0; i < n; i++) {
            l = insertBefore(l, 0);
        }
        return l;
    }

    private LinkedListNode insertBefore(LinkedListNode l, int val) {
        LinkedListNode node = new LinkedListNode(val);
        node.next = l;
        return node;
    }

    private int len(LinkedListNode l) {
        int counter = 0;
        while (l != null) {
            l = l.next;
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        SumLists sumLists = new SumLists();
        int a[] = new int[]{1, 2, 3, 4};
        int b[] = new int[]{5, 6, 7};
        // 1234 + 0567 = 1801

        LinkedListNode.printList(sumLists.sumLists(LinkedListNode.buildList(a), LinkedListNode.buildList(b)));
    }
}
