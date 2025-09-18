package Stack;

import java.util.ArrayList;

public class StackB {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }

        // Push
        public static void push(int data){
            list.add(data);
        }

        // Pop
        public static int pop(){
            if (isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        // Peek
        public static int peek(){
            if (isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class StackLinkedList {
        static Node head = null;

        public static boolean isEmpty(){
            return head == null;
        }

        // Push
        public static void push(int data){
            Node newNode = new Node(data);
            if (isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        //pop
        public static int pop(){
            if (isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        //peel
        public static int peek(){
            if (isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        StackLinkedList sl = new StackLinkedList();
        sl.push(1);
        sl.push(2);
        sl.push(3);

        while(!sl.isEmpty()){
            System.out.println(sl.peek());
            sl.pop();
        }
    }
}
