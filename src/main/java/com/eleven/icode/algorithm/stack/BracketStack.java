package com.eleven.icode.algorithm.stack;

import java.util.Scanner;

/**
 * 四则运算就是通过栈来实现的
 * 遇到是数字 就直接入栈到数字栈里面去。
 * 遇到是符号 就把符号栈的栈顶拿出来做比较。若他比栈顶符号的优先级高就直接入栈，
 * 若比符号栈顶的优先级低或者相同，就从符号栈里面取栈顶进行计算（从数字栈中取栈顶的2个数）
 * 计算完的结果还要再放入到数字栈中。
 *
 * @author by Eleven on 2021/12/29
 */
public class BracketStack {
    public static boolean isOk(String s) { // s表示的就是待匹配的括号串 [}使用字符来表示 时间复杂度 O(n)
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
