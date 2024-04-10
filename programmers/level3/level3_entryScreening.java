// 입국심사
// https://school.programmers.co.kr/learn/courses/30/lessons/43238

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int len = times.length;
        Arrays.sort(times);
        
        long min = 1;
        long max = (long) times[len - 1] * n;
        
        long answer = max;
        
        while(min <= max) {
            long avg = (min + max) / 2;
            long temp = 0;
            
            for(int i=0;i<len;i++) {
                temp += avg / times[i];
                if(temp > n) break;
            }
            
            if(temp < n) {
                min = avg + 1;
            } else {
                answer = Math.min(answer, avg);
                max = avg - 1;
            }
            
        }
        
        return answer;
    }
}