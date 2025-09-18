package Stack;
import java.util.*;
public class NewStack {
    public static void pushAtBottom(Stack<Integer> s, int data){
            if (s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString (String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i< str.length(); i++){
            s.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void reverseStack (Stack<Integer> s){
        if (s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    
    public static void printStack (Stack<Integer> s){
        while(!s.empty()){
            System.out.println(s.peek());
            s.pop();
        }
    }

    public static void stockSpan (int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i<stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                    span[i] = i+1;
                }else{
                    int prevHigh = s.peek();
                    span[i] = i - prevHigh;
                }
                s.push(i);
        }
    }

    public static void nextGreater (int arr[], int nxtGrt[]){
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length -1; i>=0; i--){
            int currElement = arr[i];
            while(!s.isEmpty() && currElement >= arr[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                nxtGrt[i] = -1;
            }else{
                nxtGrt[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }
    public static boolean isValidParenthesis(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else{
                if (s.isEmpty()){
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isDuplicateParenthesis(String str){
        Stack<Character> s = new Stack<>();

        for (int i = 0; i<str.length(); i++ ){
            char ch = str.charAt(i);
            if (ch == ')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if (count <1){
                    return true;
                }

            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void greatestRectangleArea (int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // Next smaller right 
        Stack<Integer> s = new Stack<>();

        for(int i= arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // Next smaller
        s = new Stack<>();
        for(int i= 0; i< arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //current Area 
        for(int i = 0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width; 
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
    }
    public static void main (String [] args){
        int height[] = {2,1,5,6,2,3};
        greatestRectangleArea(height);

        // String str = "(((a+b)+(c)))";
        // System.out.println(isDuplicateParenthesis(str));

        // int arr[] = {6,8,0,1,3};
        // int nxtGrt[] = new int[arr.length];
        // nextGreater(arr, nxtGrt);
        // for (int i = 0; i<arr.length;i++){
        //     System.out.print(nxtGrt[i] + " ");
        // }

        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);
        // for (int i = 0; i<span.length; i++){
        //     System.out.print(span[i] + " ");
        // }

    }
}
