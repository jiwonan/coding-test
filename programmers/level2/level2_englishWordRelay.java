// https://school.programmers.co.kr/learn/courses/30/lessons/12981?language=java
// 영어 끝말잇기

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};

        Stack<String> stack = new Stack<>();

        for(int i=0;i < words.length; i++) {
            if(i%n == 0) {
                answer[1]++;
            }

            answer[0] = i % n + 1;

            if(i == 0) {
                stack.push(words[i]);
                continue;
            }

            Object[] temp = stack.toArray();

            String[] prevWord = temp[i-1].toString().split("");
            String end = prevWord[prevWord.length - 1];

            String[] curWord = words[i].split("");
            String start = curWord[0];

            if(!end.equals(start) || (stack.contains(words[i]))) {
                break;
            }
            stack.push(words[i]);
        }

        if(stack.size() == words.length) {
            return new int[]{0,0};
        }

        return answer;
    }
}