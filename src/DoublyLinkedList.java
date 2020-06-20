package com.training.LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    class Node{
        int data;
        Node next;
        Node prev;
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int length(){
        return length;
    }
    public void insertFirst(int data){
        Node n = new Node();
        n.data = data;

        if(isEmpty()){
            tail = n;
        }else{
            head.prev = n;
        }
        n.next = head;
        head = n;
    }
    public void insertLast(int data){
        Node n = new Node();
        n.data = data;

        if(isEmpty()){
            head = n;
        }else{
            tail.next = n;
            n.prev = tail;
        }
        tail = n;
    }
    public void deleteFirst(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Node n = head;
        if(head == tail){
            tail = null;
        }else{
            head.next.prev = null;
        }
        head = head.next;
        n.next = null;
    }
    public void deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node n = tail;
        if(head == tail){
            head = null;
        }else{
            tail.prev.next = null;
        }
        tail = tail.prev;
        n.prev = null;
    }
    public void show(){
        Node n = head;

        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }
}
