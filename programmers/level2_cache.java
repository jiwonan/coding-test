// 캐시
// https://school.programmers.co.kr/learn/courses/30/lessons/17680

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> queue = new LinkedList<>();
        
        for(String city : cities) {
            String lowerCity = city.toLowerCase();    
            
            // cache hit
            if(queue.contains(lowerCity)) {
                queue.remove(lowerCity);
                queue.offer(lowerCity);
                
                answer+=1;
                continue;
            }
            
            // cache miss
            queue.offer(lowerCity);
            answer+=5;
            
            if(queue.size() > cacheSize) {
                queue.poll();
            }
         }
        
        return answer;
    }
}