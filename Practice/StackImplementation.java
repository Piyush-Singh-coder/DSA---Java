package Practice;

import java.awt.List;
import java.util.ArrayList;

public class StackImplementation {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class LinkedListB{
        static Node head = null;
        public static boolean isEmpty(){
            return head == null;
        }
        public static void push(int data){
            Node newNode = new Node(data);
            if (head == null){
                head = newNode;
                return; 
            }
            newNode.next = head;
            head = newNode;
        }
        public static int pop (){
            if (head == null){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        public static int top(){
            if (head == null){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        LinkedListB s = new LinkedListB();
        s.push(4);
        s.push(6);
        s.push(8);
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
