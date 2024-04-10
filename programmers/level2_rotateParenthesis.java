// https://school.programmers.co.kr/learn/courses/30/lessons/76502
// 괄호 회전하기

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(isCorrect(s)) {
                answer++;
            }
            s = shift(s);
        }
        
        
        return answer;
    }
    
    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> open = Arrays.asList('[', '{', '(');
        List<Character> close = Arrays.asList(']', '}', ')');

        for(int i = 0; i<s.length(); i++) {
            char target = s.charAt(i);
            // 여는 괄호는 무조건 push
            if(open.contains(target)) {
                stack.push(target);
                continue;
            }
            // 닫는 괄호부터 있으면 올바르지 않은 괄호 문자열
            if(stack.isEmpty()) {
                return false;
            }
            
            // 여는 괄호 종류와 닫는 괄호 종류 일치하지 않으면 올바르지 않는 괄호 문자열
            char poped = stack.pop();
            
            int openIdx = open.indexOf(poped);
            int closeIdx = close.indexOf(target);
            
            if(openIdx != closeIdx) return false;
        }
        // 스택이 비어있다면 올바른 괄호 문자열
        return stack.isEmpty() ? true : false;
    }
    
    private String shift(String s) {
        return s.substring(1, s.length()) + s.charAt(0);
    }
}