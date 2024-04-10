// 방금그곡
// https://school.programmers.co.kr/learn/courses/30/lessons/17683

import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        m = convertSound(m);
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<musicinfos.length;i++) {
            String[] musicInfo = musicinfos[i].split(",");
            String sound = musicInfo[3];
            sound = convertSound(sound);
            
            int playTime = calcPlayTime(musicInfo[0], musicInfo[1]);
            
            int soundLength = sound.length();
            
            if(playTime / soundLength < 1) {
                sound = sound.substring(0, playTime + 1);
            } else {
                int length = (playTime / soundLength) + 1;
                String temp = sound;
                for(int j=0;j<length;j++) {
                    sound += temp;
                }
            }
            
            boolean result = false;
            for(int j=0;j<sound.length() - m.length();j++) {
                if(sound.charAt(j) == m.charAt(0)) {
                    for(int k=0;k<m.length();k++) {
                        if(sound.charAt(j+k) == m.charAt(k)) {
                            result = true;
                        } else {
                            result = false;
                            break;
                        }
                    }
                }
                if(result) {
                    break;
                }
            }
            
            if(result) {
                if(max < playTime) {
                    max = playTime;
                    answer = musicInfo[2];
                }
            }
        }
        
        return answer;
    }
    
    private int calcPlayTime(String st, String en) {
        int startHour = Integer.valueOf(st.split(":")[0]);
        int startMinute = Integer.valueOf(st.split(":")[1]);
        int endHour = Integer.valueOf(en.split(":")[0]);
        int endMinute = Integer.valueOf(en.split(":")[1]);
        
        return (endHour - startHour) * 60 + (endMinute - startMinute);
    }
    
    private String convertSound(String sound) {
        Stack<Character> st = new Stack<>();
        for(char c:sound.toCharArray()) {
            st.push(c);
        }
        
        String result = "";
        while(!st.isEmpty()) {
            char c = st.pop();
            if(c == '#') {
                String s = st.pop().toString().toLowerCase();
                result = s + result;
            } else {
                result = c + result;
            }
        }
        
        return result;
    }
}