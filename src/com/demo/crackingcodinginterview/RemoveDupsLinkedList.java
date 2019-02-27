package com.demo.crackingcodinginterview;

import java.util.HashSet;

public class RemoveDupsLinkedList {

    private void removeDuplicates(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode prev = null;
        while (n != null) {
            if (set.contains(n.data)) {
                prev.next = n.next;
            } else {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }

    private void removeDuplicates2(LinkedListNode n) {

        while (n != null) {
            LinkedListNode runner = n;
            while (runner.next != null) {
                if (runner.next.data == n.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            n = n.next;
        }
    }

    public static void main(String[] args) {
        RemoveDupsLinkedList dups = new RemoveDupsLinkedList();

        int[] a = new int[]{1, 2, 2, 1, 1, 3, 3, 3, 3, 4, 4, 5};

        LinkedListNode n = LinkedListNode.buildList(a);
        dups.removeDuplicates(n);

        LinkedListNode.printList(n);

        n = LinkedListNode.buildList(a);

        System.out.println();

        dups.removeDuplicates2(n);

        LinkedListNode.printList(n);
    }


}
