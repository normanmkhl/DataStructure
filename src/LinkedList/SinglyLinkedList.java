package com.training.LinkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList {
    Node head;

    class Node{
        int data;
        Node next;
    }
    public void insert(int data) {
        Node node = new Node(); // value
        node.next = null;
        node.data = data;

        if (head == null) {
            head = node;
        }else {
            Node n = head; // iterator
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }
    public void insertBeginning(int data){
        Node node = new Node(); // value
        node.data = data;

        node.next = head;
        head = node;

    }
    public void insertAt(int index, int data){
        Node node = new Node(); //value
        node.data = data;

        if(index == 0){
            insertBeginning(data);
        }else {
            Node n = head; //iterator
            for (int i = 0; i < index - 1; i++){
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }
    public void delete(){
        Node prevToLast = null; // iterator to delete

       if(head == null){
           return;
       }else {
           Node n = head; //iterator
           while (n.next != null) {
               prevToLast = n;
               n = n.next;
           }
           prevToLast.next = null;
       }
    }
    public void deleteBeginning(){
        if(head != null) {
            head = head.next;
        }
    }
    public void deleteAt(int index){
        Node prevToLast = null; //iterator to delete

        if(index == 0){
            deleteBeginning();
        }else {
            Node n = head;  //iterator
            for (int i = -1; i < index - 1; i++) {
                prevToLast = n;
                n = n.next;
            }
            prevToLast.next = n.next;
        }
    }
    public void deleteNum(int num){
        if(head.data == num){
            head = head.next;
        }else{
            Node n = head;
            while(n.next != null){
                if(n.next.data == num){
                    n.next = n.next.next;
                    break;
                }else{
                    n = n.next;
                }
            }
        }
    }
    public void show(){
        Node n = head; // iterator

        while(n.next != null){
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }
    public boolean search(int search){
        Node n = head;

        while(n.next != null){
            if(search == n.data){
                return true;
            }
            n = n.next;
        }
        if(search == n.data){
            return true;
        }
        return false;
    }
   public void reverse(){
        Node n = head;
        Node prev = null;

        while(n != null){
            n = n.next;
            n.next = prev;
        }
   }
   public void middle(){
        if(head == null){
            return;
        }

        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
       System.out.println("The middle is : " + slowPtr.data);
   }
   public void nthLinkEnd(int n){
        if(head == null){
            return;
        }

        Node mainPtr = head;
        Node refPtr = head;
        int current = 0;

        while(current < n){
            refPtr = refPtr.next;
            current++;
        }
        while(refPtr != null && refPtr.next != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
       System.out.println("the " + n + " node from end is " +
               mainPtr.data);
   }
   public void duplicateinSorted(){
        if (head == null){
            return;
        }
        Node node = head;
        while(node.next != null){
            if(node.data == node.next.data){
                node.next = node.next.next;
            }else{
                node = node.next;
            }
       }
   }
   public void insertonSorted(int data){
        if(head == null) {
            return;
        }
        Node n = head;
        Node temp = null;
        Node x = new Node();
        x.data = data;

        while(n != null && n.data < x.data) {
            temp = n;
            n = n.next;
        }
       x.next = n;
        temp.next = x;
   }
   public void deleteatKey(int key){
        Node n = head;
        Node temp = null;
        Node x = new Node();
        x.data = key;

        while(n != null && n.data == x.data){
            temp = n;
            n = n.next;
        }
        if(n == null){
            return;
        }
        temp.next = n.next;
   }
   public boolean detectLoop(){
        if(head == null){
            throw new NoSuchElementException();
        }
        Node fastPtr = head;
        Node slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return true;
            }
        }
        return false;
   }
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(3);
        list.insert(9);
        list.insert(10);

        list.show();

        System.out.println();

        list.insertAt(0,80);
        list.show();

        System.out.println();
        list.delete();
        list.show();


        System.out.println();
        list.insert(10);
        list.show();

        System.out.println();
        System.out.println(list.search(10));

        list.deleteAt(0);
        list.show();

        System.out.println();
        list.insertAt(1,50);
        list.show();

        System.out.println();
        list.insert(10);
        list.insert(1);
        list.insert(45);

        System.out.println();
        list.deleteAt(3);

        System.out.println();
        list.deleteNum(50);
        list.show();

        list.middle();

        list.nthLinkEnd(3);

    }
}
