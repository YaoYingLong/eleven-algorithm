package com.eleven.icode.algorithm.stack;

import java.util.Scanner;

/**
 * @author by Eleven on 2021/12/29
 */
public class BracketStack {
    public static boolean isOk(String s) {        //s表示的就是待匹配的括号串 [}使用字符来表示 时间复杂度 O(n)
        MyStack<Character> brackets = new ArrayStack<Character>(20);
        char c[] = s.toCharArray();
        Character top;
        for (char x : c) {
            switch (x) {
                case '{':
                case '(':
                case '[':
                    brackets.push(x);//O(1)
                    break;
                case '}':
                    top = brackets.pop();//O(1)
                    if (top == null) return false;
                    if (top == '{') {
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    top = brackets.pop();//O(1)
                    if (top == null) return false;
                    if (top == '(') {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    top = brackets.pop();//O(1)
                    if (top == null) return false;
                    if (top == '[') {
                        break;
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }
        return brackets.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            System.out.println("s的匹配结果:" + isOk(s));
        }
    }
}
