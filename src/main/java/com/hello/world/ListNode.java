package com.hello.world;

public class ListNode {
    public int value;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.value = val;
    }

    ListNode(int val, ListNode next) {
        this.value = val;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public ListNode getNext() {
        return next;
    }
}