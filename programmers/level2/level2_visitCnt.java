// 방문 길이
// https://school.programmers.co.kr/learn/courses/30/lessons/49994

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        HashSet<String> log = new HashSet<>();
        int curX=0;
        int curY=0;
        
        String[] dirArr = dirs.split("");
        HashMap<String, String> dirValue = initDir();
        
        for(String dir:dirArr) {
            String value = dirValue.get(dir);
            
            int moveX = Integer.valueOf(value.split(",")[0]);
            int moveY = Integer.valueOf(value.split(",")[1]);
            
            if(!isOutOfBounds(curX, curY, moveX, moveY)) {
                int nextX = curX + moveX;
                int nextY = curY + moveY;
                
                String path = "";
                if(nextX == curX) {
                    if(nextY > curY) {
                        path = "" + nextX + nextY + curX + curY;
                    } else {
                        path = "" + curX + curY + nextX + nextY;
                    }
                } else {
                    if(nextX > curX) {
                        path = "" + nextX + nextY + curX + curY;
                    } else {
                        path = "" + curX + curY + nextX + nextY;
                    }
                }
                
                curX += moveX;
                curY += moveY;
                
                log.add(path);
            }
        }
        
        System.out.println(log);
        
        return log.size();
    }
    
    private boolean isOutOfBounds(int curX, int curY, int moveX, int moveY) {
        curX += moveX;
        curY += moveY;
        return curX > 5 || curX < -5 || curY > 5 || curY < -5;
    }
    
    private HashMap<String, String> initDir() {
        HashMap<String, String> map = new HashMap<>();
        map.put("U", "0,1");
        map.put("D", "0,-1");
        map.put("R", "1,0");
        map.put("L", "-1,0");
        
        return map;
    }
}