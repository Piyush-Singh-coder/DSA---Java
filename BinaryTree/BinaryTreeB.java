package BinaryTree;

import java.util.*;

public class BinaryTreeB{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class BinaryTree{
        static int idx = -1;
        public static Node BuildTree(int nodes[]){
            idx++;
            if (nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;
        }
        public static void preOrder(Node root){
            if (root == null){
                //System.out.print(-1 +" ");
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static void inOrder(Node root){
            if (root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
        public static void postOrder(Node root){
            if (root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        } 
        public static void levelOrder(Node root){
            if (root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if (currNode == null){
                    System.out.println();
                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null){
                        q.add(currNode.left);
                    }
                    if (currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static int height(Node root){
        if (root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) +1;
    }

    public static int nodeCount(Node root){
        if (root == null){
            return 0;
        }
        int leftCount = nodeCount(root.left);
        int rightCount = nodeCount(root.right);
        return leftCount + rightCount + 1;
    }

    public static int nodeSum(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = nodeSum(root.left);
        int rightSum = nodeSum(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int diameter(Node root){
        if (root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int rightDiam = diameter(root.right);
        int leftDiam = diameter(root.left);
        int selfDiam = lh+rh+1;

        return Math.max(Math.max(leftDiam, rightDiam), selfDiam);
    }

    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diamHtInfo(Node root){
        if (root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diamHtInfo(root.left);
        Info rightInfo = diamHtInfo(root.right);
        int diameter = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht +1);
        int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diameter, height);
    }

    public static boolean isIdentical(Node node, Node subroot){
        if (node == null && subroot == null){
            return true;
        }else if(node == null || subroot == null || node.data != subroot.data){
            return false;
        }
        if (!isIdentical(node.left, subroot.left)){
            return false;
        }
        if (!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root, Node subroot){
        if (root == null){
            return false;
        }
        if (root.data == subroot.data){
            if (isIdentical(root, subroot)){
                return true;
            }
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    static class Info2{
        Node node;
        int hd;

        public Info2(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info2(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info2 curr = q.remove();
            if (curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if (!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }

                if (curr.node.left != null){
                    q.add(new Info2(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if (curr.node.right != null){
                    q.add(new Info2(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }
        for (int i = min; i<= max; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    public static void kLevel(Node root, int level, int k){
        if (root == null){
            return;
        }
        if (level == k){
            System.out.print(root.data +" ");
            return;
        }
        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
    }

    //Lowest common Ancestor - Approach 1 - time complexity = O(n) and space = O(n^2)

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if (root == null){
            return false;
        }
        path.add(root);

        if (root.data == n){
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i<path1.size() && i<path2.size(); i++){
            if (path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    public static Node lca2(Node root, int n1, int n2){
        if (root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);
    
        if (rightLca == null){
            return leftLca;
        }
        if (leftLca == null){
            return rightLca;
        }
        return root;
    }

    // Min distance between two nodes
    public static int lcaDist(Node root, int n){
        if (root == null){
            return -1;
        }
        if (root.data == n){
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }
    public static int minDistance(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);
        return dist1+dist2;
    }

    public static int kAncestor(Node root, int n, int k){
        if (root == null){
            return -1;
        }
        if (root.data == n){
            return 0;
        }

        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1){
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }

    // Sum Tree
    public static int sumTree(Node root){
        if (root == null){
            return 0;
        }

        int leftChild = sumTree(root.left);
        int rightChild = sumTree(root.right);
        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = leftChild + newLeft + rightChild + newRight;

        return data;
    }
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String [] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subroot = new Node(4);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        // System.out.println(height(root));
        // System.out.println(nodeCount(root));
        // System.out.println(nodeSum(root));
        // System.out.println(diameter(root));
        // System.out.println(diamHtInfo(root).diam);
        // System.out.println(diamHtInfo(root).ht);
        // System.out.println(isSubtree(root, subroot));
        // topView(root);
        // kLevel(root, 1, 3);\
        // System.out.println(lca2(root, 4, 5).data);
        // System.out.println(minDistance(root, 4, 6));
        kAncestor(root, 5, 2);
        sumTree(root);
        preOrder(root);
    }
}