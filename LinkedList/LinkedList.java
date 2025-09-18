package LinkedList;

public class LinkedList {
    public  class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void insertAtBeg(int data){
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void insert(int idx,int data){
        if (idx == 0){
            insertAtBeg(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        int i =0;
        Node temp = head;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if (size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1 ){
           int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast (){
        if (size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i<size - 2; i++){
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int iterativeSearching(int key){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if (temp.data == key){
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }
    public int helper (Node head, int key){
        if (head == null){
            return -1;
        }
        if (head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recursiveSearching (int key){
        return helper(head,key);
    }
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void findNRemoveFromEnd(int n){
        //alternate way to find size
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if (n == sz){
            head = head.next;
            return;
        }
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //slow-fast or turtle-hare approach
    public Node findMid (Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(){
        if (head == null || head.next == null){
            return true;
        }
        //mid 
        Node midNode = findMid(head);

        //reverse
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        //check left and right half
        while(right != null){
            if (right.data != left.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                isCycle = true;
                break;
            }
        }
        if (!isCycle){
            return;
        }
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }
    public void traverse(){
        if (head == null){
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public Node getMid (Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node mergeSort(Node head){
        if (head  == null || head.next == null){
            return head;
        }
        
        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }
    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node (-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null){
            if (head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public void zigZag (){
        // mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    public static void main(String[] args) {
        // LinkedList ll = new LinkedList(); 
        // ll.insertAtBeg(4);
        // ll.insertAtBeg(3);
        // ll.insertAtEnd(5);
        // ll.insertAtBeg(1);
        // ll.insertAtEnd(6);
        // ll.insert(1, 2);
        // ll.insert(0,0);
        // ll.traverse();
        // ll.findNRemoveFromEnd(3);
        // ll.traverse();
        // ll.insertAtBeg(1);
        // ll.insertAtEnd(2);
        // ll.insertAtEnd(2);
        // ll.insertAtEnd(1);
        // ll.traverse();
        // System.out.println(ll.isPalindrome());
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        LinkedList ll = new LinkedList();
        ll.insertAtBeg(6);
        ll.insertAtEnd(5);
        ll.insertAtEnd(4);
        ll.insertAtEnd(3);
        ll.insertAtEnd(2);
        ll.insertAtEnd(1);
        ll.traverse();
        ll.head = ll.mergeSort(ll.head);
        ll.traverse();
        ll.zigZag();
        ll.traverse();
    }
}