package StacknQueue;

import java.util.Stack;

public class StackReverse {

    public static String StringReverse(String word){
        Stack<Character> stk = new Stack();
        char[] chars = word.toCharArray();

        for(char c : chars){
            stk.push(c);
        }
        for(int i = 0 ; i < word.length() ; i++){
            chars[i] = stk.pop();
        }
        return new String(chars);
    }
    public static void main(String[] args){
        String word = "tacocat";
        System.out.println("reversed = "  + StringReverse(word));
    }
}
