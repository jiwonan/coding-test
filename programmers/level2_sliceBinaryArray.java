// https://school.programmers.co.kr/learn/courses/30/lessons/87390
// n^2 배열 자르기

import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        
        for(int i=0; i < answer.length; i++) {
            int row = (int)(left / n + 1);
            int col = (int)(left % n + 1);
            left++;
            answer[i] = Math.max(row,col);
        }
        
        return answer;
    }
}