package com.hello.world.leet;

import com.hello.world.LinkedList;
import com.hello.world.ListNode;

public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode previous = current;
        int i = 0;
        while (current != null) {
            previous = current;
            current = current.next;
            if (current == null && i == 0) {
                head = null;
            }
            if (i == n && current != null) {
                previous.next = current.next;
            }
            if (i == 1 && i == n && current == null) {
                head.next = null;
            }
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList listOne= new LinkedList(1);
        listOne.append(2);
        listOne.append(3);
        listOne.append(4);
        listOne.append(5);
        int n = 2;

        Solution19 s = new Solution19();

        listOne.printList();
        s.removeNthFromEnd(listOne.getHead(), n);
        listOne.printList();

        LinkedList listTwo= new LinkedList(1);

        listTwo.printList();
        s.removeNthFromEnd(listTwo.getHead(), 1);
        listTwo.printList();

        LinkedList listThree= new LinkedList(1);
        listThree.append(2);

        listThree.printList();
        s.removeNthFromEnd(listThree.getHead(), 1);
        listThree.printList();

        LinkedList listFour= new LinkedList(1);
        listThree.append(2);

        listThree.printList();
        s.removeNthFromEnd(listThree.getHead(), 2);
        listThree.printList();

    }
}