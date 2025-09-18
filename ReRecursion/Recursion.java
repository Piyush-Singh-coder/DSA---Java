package ReRecursion;

import java.util.*;
public class Recursion{
    public static void insert(ArrayList<Integer>list, int element){
        if (list.size() == 0 || list.get(list.size()-1) <= element){
            list.add(element);
            return;
        }
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        insert(list, element);
        list.add(temp);
        return;
    }
    public static void sorting(ArrayList<Integer> list){
        if (list.size() == 1){
            return;
        }
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        sorting(list);
        insert(list,temp);
        return;
    }
    public static void removeMiddle(Stack<Integer> s){
        if (s.isEmpty()){
            return;
        }
        int k = (s.size()/2) +1;
        remove(s, k);
    }
    public static void remove(Stack<Integer> s, int k){
        if (k == 1){
            s.pop();
            return;
        }
        int temp = s.pop();
        remove(s, k-1);
        s.push(temp);
    }
    public static void insertElement(Stack<Integer> stack, int top){
        if (stack.isEmpty()){
            stack.push(top);
            return;
        }
        int temp = stack.pop();
        insertElement(stack, top);
        stack.push(temp);
    }
    public static void reverseStack(Stack<Integer> stack){
        if (stack.size() ==1){
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        insertElement(stack, top);
    }

    public static void subset(StringBuilder str, StringBuilder ans) {
    if (str.length() == 0) {
        System.out.println(ans);
        return;
    }

    // Make copies so changes don't affect other branches
    StringBuilder op1 = new StringBuilder(ans);
    StringBuilder op2 = new StringBuilder(ans);

    // Include current character in op2
    op2.append(str.charAt(0));

    // Make copy of str for safe removal
    StringBuilder remaining = new StringBuilder(str);
    remaining.deleteCharAt(0);

    // Call recursively
    subset(new StringBuilder(remaining), op1); // without current char
    subset(new StringBuilder(remaining), op2); // with current char
}
    public static void main(String[] args) {

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(5);
        // list.add(4);
        // list.add(3);
        // list.add(2);
        // list.add(1);
        // System.out.println(list);
        // sorting(list);
        // System.out.println(list);

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // s.push(5);
        // reverseStack(s);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        StringBuilder str = new StringBuilder("abc");
        StringBuilder ans = new StringBuilder("");
        subset(str, ans);
    }
}