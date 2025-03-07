package com.hello.world;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    public LinkedList(int value) {
        ListNode node = new ListNode(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    public void append(int value) {
        ListNode newNode = new ListNode(value);

        if(this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    public void printList() {

        ListNode temp = head;

        while(temp != null) {
            System.out.print("{"+temp.value+"}->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public ListNode removeLast() {
        if(length == 0 && head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode pre = head;

        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;

        length--;
        if(length == 0) {
            tail = null;
            head = null;
        }
        return temp;
    }

    public void prepend(int value) {
        ListNode newNode = new ListNode(value);
        if(length == 0 || head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public ListNode getHead() {
        System.out.println("Head:" + head.value);
        return head;
    }

    public ListNode getTail() {
        System.out.println("Tail:" + tail.next);
        return tail;
    }

    public int getLength() {
        System.out.println("Length:"+length);
        return length;
    }

    public void reverse() {
        ListNode temp = head;
        head = tail;
        tail = temp;

        ListNode after = temp.next;
        ListNode before = null;

        for(int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(4);
        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        myLinkedList.append(2);

        myLinkedList.printList();

        System.out.println(myLinkedList.removeLast().value);
        System.out.println(myLinkedList.removeLast().value);
        myLinkedList.prepend(23);
        myLinkedList.prepend(7);
        //System.out.println(myLinkedList.removeLast());
        myLinkedList.printList();


        LinkedList secondList= new LinkedList(1);
        secondList.append(2);
        secondList.append(3);
        secondList.append(4);
        secondList.append(5);
        secondList.append(6);
        secondList.append(7);
        secondList.append(23);

        secondList.printList();

        secondList.reverse();

        secondList.printList();
    }

}
