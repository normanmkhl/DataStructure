package StacknQueue;

import java.util.NoSuchElementException;

public class Queue {
    Node front;
    Node rear;
    int length;

    class Node{
        public int data;
        public Node next;
    }

    public boolean isEmpty(){
        return length == 0;
    }
    public int getLength(){
        return length;
    }
    public void enqueue(int data){
        Node node = new Node();
        node.data = data;

        if(isEmpty()){
            front = node;
        }else{
            rear.next = node;
        }
        rear = node;
        length++;
    }
    public void dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }else{
            front = front.next;
            if(front == null){
                rear = null;
            }
            length--;
        }
    }
    public void peek(){
        System.out.println(front.data);
    }
    public void show(){
        Node n = front;
        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }
    public static void main(String[] args){
        Queue list = new Queue();

        list.enqueue(9);
        list.enqueue(10);
        list.enqueue(1);
        list.enqueue(4);

        list.show();


    }
}
