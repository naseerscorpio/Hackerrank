package com.demo.crackingcodinginterview;

public class LinkedListNode {

    public int data;
    public LinkedListNode next;

    public LinkedListNode(int x) {
        this.data = x;
        next = null;
    }

    public static LinkedListNode buildList(int[] a) {
        if (a == null || a.length == 0) return null;
        LinkedListNode n = new LinkedListNode(a[0]);
        LinkedListNode head = n;

        for (int i = 1; i < a.length; i++) {
            n.next = new LinkedListNode(a[i]);
            n = n.next;
        }
        return head;
    }

    public static void printList(LinkedListNode n) {
        int i = 0;
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
    }
}
