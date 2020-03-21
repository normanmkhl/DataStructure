package StacknQueue;

import java.util.NoSuchElementException;

public class Stack {
    Node top;
    int length;

    class Node{
        public int data;
        public Node next;
    }
    public int getLength(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public void push(int data){
        Node node = new Node();
        node.data = data;

        if(top == null){
            top = node;
        }else{
            node.next = top;
            top = node;
            length++;
        }
    }

    public void pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }else{
            top = top.next;
            length--;
        }
    }

    public void peek(){
        System.out.println(top.data);
    }

    public void show(){
        Node n = top;
        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }

    public static void main(String[] args){
        Stack list = new Stack();

        list.push(4);
        list.push(9);
        list.push(1);
        list.push(10);

        list.pop();

        list.peek();
    }
}
