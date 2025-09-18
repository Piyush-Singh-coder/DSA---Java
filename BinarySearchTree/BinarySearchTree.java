package BinarySearchTree;

import java.util.*;
public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insertion(Node root, int data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        if (data > root.data){
            root.right = insertion(root.right, data);
        }
        else if(data <root.data){
            root.left = insertion (root.left, data);
        }
        return root;
    }

    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if (root.data == key){
            return true;
        }
        if (root.data < key){
            return search(root.right, key);
        }
        else if(root.data > key){
            return search(root.left, key);
        }
        return false;
    }

    // Deletion 
    public static Node deletion (Node root, int val){
        if (root.data > val){
            root.left = deletion(root.left, val);
        }
        else if(root.data < val){
            root.right = deletion(root.right, val);
        }else{
            // leaf node
            if (root.left == null && root.right == null){
                return null;
            }
            // one child node
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }

            // No two child 
            Node inOrderSuccessor = findInOrderSuccessor(root.right);
            root.data = inOrderSuccessor.data;
            root.right = deletion(root.right, inOrderSuccessor.data );
        }
        return root;
    }
    public static Node findInOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }


    public static void printInRange(Node root, int k1, int k2){
        if (root == null){
            return;
        }
        if (root.data >= k1 && root.data <= k2 ){
            printInRange(root.left, k1, k2);
            System.out.print(root.data +" ");
            printInRange(root.right, k1, k2);
        }
        else if (root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }

    // Print root to path
    public static void printPath(ArrayList<Integer> path){
        for (int i = 0; i<path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean validateBST(Node root, Node min, Node max){
        if (root == null){
            return true;
        }
        
        if (min != null && root.data <= min.data ){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }

    public static Node createMirror(Node root){
        if (root == null){
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }
    public static void preOrder (Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node (5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node (11);
        root = createMirror(root);
        preOrder(root);
    }  
}
