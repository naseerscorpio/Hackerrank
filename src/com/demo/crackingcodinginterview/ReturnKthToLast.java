package com.demo.crackingcodinginterview;

public class ReturnKthToLast {

    int printKthToLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }

    LinkedListNode kthElementToLast(LinkedListNode head, int k) {

        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        System.out.println(k + "th to last node is " + p2.data);
        return p2;
    }

    public static void main(String[] args) {
        ReturnKthToLast returnKthToLast = new ReturnKthToLast();

        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};

        LinkedListNode n = LinkedListNode.buildList(a);

        returnKthToLast.printKthToLast(n, 3);

        returnKthToLast.kthElementToLast(n,3);
    }
}
