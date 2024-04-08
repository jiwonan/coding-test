// https://school.programmers.co.kr/learn/courses/30/lessons/12973
// 짝지어 제거하기

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            if(stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}