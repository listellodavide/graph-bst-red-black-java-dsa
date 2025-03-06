package com.hello.world;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }


    public void append(int value) {
        Node newNode = new Node(value);

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

        Node temp = head;

        while(temp != null) {
            System.out.print("{"+temp.value+"}->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node removeLast() {
        if(length == 0 && head == null) {
            return null;
        }
        Node temp = head;
        Node pre = head;

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
        Node newNode = new Node(value);
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

    public Node getHead() {
        System.out.println("Head:" + head.value);
        return head;
    }

    public Node getTail() {
        System.out.println("Tail:" + tail.next);
        return tail;
    }

    public int getLength() {
        System.out.println("Length:"+length);
        return length;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

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
