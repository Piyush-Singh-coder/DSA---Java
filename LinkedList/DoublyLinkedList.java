package LinkedList;

public class DoublyLinkedList {
    public class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = prev;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public int removeFirst(){
        if (head == null){
            size = 0;
            System.out.println("The linked List is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1){
            int val = head.data;
            head = tail = null;
            size --;
            return val ;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size --;
        return val;
    }
    
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void traverse(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(0);
        dll.traverse();
        System.out.println(size);
        dll.reverse();
        dll.traverse();

    }
}
