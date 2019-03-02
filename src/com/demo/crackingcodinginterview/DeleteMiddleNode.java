package com.demo.crackingcodinginterview;

public class DeleteMiddleNode {

    void deleteMiddleNode(LinkedListNode n) {
        if (n == null || n.next == null) return;

        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};

        LinkedListNode n = LinkedListNode.buildList(a);
        LinkedListNode p1 = n;
        LinkedListNode p2 = n;

        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        DeleteMiddleNode middleNode = new DeleteMiddleNode();
        middleNode.deleteMiddleNode(p2);

        LinkedListNode.printList(n);
    }
}
