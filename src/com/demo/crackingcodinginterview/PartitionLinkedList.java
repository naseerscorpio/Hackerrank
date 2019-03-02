package com.demo.crackingcodinginterview;

public class PartitionLinkedList {


    private LinkedListNode partition(LinkedListNode node, int x) {

        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;
        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }
        if (beforeStart == null) return afterStart;
        //merge 2 lists
        beforeEnd.next = afterStart;

        return beforeStart;
    }

    private LinkedListNode partition2(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 8, 5, 10, 2, 1};
        LinkedListNode n = LinkedListNode.buildList(a);

        PartitionLinkedList partitionLinkedList = new PartitionLinkedList();
        /*LinkedListNode node = partitionLinkedList.partition(n, 5);

        LinkedListNode.printList(node);*/

        System.out.println();

        LinkedListNode.printList(partitionLinkedList.partition2(n, 5));
    }
}
