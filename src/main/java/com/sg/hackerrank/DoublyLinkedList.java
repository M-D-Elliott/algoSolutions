package com.sg.hackerrank;

public class DoublyLinkedList<T> {

    private Node head, tail = null;

    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void append(T data) {

        Node curr = new Node(null, null, data);

        if (this.head == null) {

            this.head = this.tail = curr;

        } else {
            this.tail.next = curr;
            curr.prev = this.tail;
            this.tail = curr;
        }

        this.size++;
    }

    public void prepend(T data) {
        Node curr = new Node(this.head, null, data);
        this.head = curr;

        if (curr.next != null) {
            curr.next.prev = curr;
        }

        this.size++;
    }

    public void printForward() {

        Node curr = this.head;

        if (curr == null) {
            System.out.println("Empty doubly linked list.");
            return;
        }

        System.out.println("");

        System.out.print(this.head + " ");

        while (curr.next != null) {
            curr = curr.next;
            System.out.print(curr + " ");
        }
    }

    public void printBackward() {

        Node curr = this.tail;

        if (curr == null) {
            System.out.print("Empty doubly linked list.");
            return;
        }

        System.out.println("");

        System.out.print(this.tail + " ");

        while (curr.prev != null) {
            curr = curr.prev;
            System.out.print(curr + " ");
        }
    }

    public Node deleteByDataForward(T data) {
        Node curr = head;

        if (head == null) {
            return null;
        }

        if (head.getData().equals(data)) {
            Node ret = this.head;

            this.head = this.head.next;
            this.size--;

            this.head.prev = null;

            return ret;
        }

        if (tail.getData().equals(data)) {
            Node ret = this.tail;

            this.tail = this.tail.prev;
            this.size--;

            this.tail.next = null;

            return ret;
        }

        while (curr.next != null) {
            if (curr.next.getData().equals(data)) {

                Node ret = curr.next;

                curr.next = curr.next.next;

                if (curr.next != null) {
                    curr.next.prev = curr;
                }

                this.size--;

                return ret;
            }
            curr = curr.next;
        }

        return null;
    }
    
    public Node iterateForward(int position){
        
        Node curr = this.head;
        
        while(curr.next != null && position > 0){
            curr = curr.next;
            position--;
        }
        
        return (position > 0) ? null : curr;
    }
    
    public void createLoopWithTail(){
        createLoopWithTail(0);
    }

    public void createLoopWithTail(int position) {
        Node curr = iterateForward(position);
        
        if(curr == null){
            System.out.println("Position not on list.");
        }
        
        this.tail.next = curr;
    }
    
    public void clearTail(){
        this.tail.next = null;
    }

    public boolean detectLoop() {
        boolean ret = false;

        Node p = this.head;
        Node q = this.head;

        int requiredIters = 0;

        while (p != null && q != null && q.next != null) {

            p = p.next;
            q = q.next.next;

            if (p == q) {
                ret = true;
                break;
            }

            requiredIters++;
        }

        if (ret) {
            System.out.println("Detected loop in " + requiredIters + " iterations.");
        } else {
            System.out.println("No loop.");
        }

        return ret;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    
}

class Node<T> {

    public Node next;
    public Node prev;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node(Node next, Node prev, T data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{data=" + this.data + '}';
    }
}
