// 스티커 모으기(2)
// https://school.programmers.co.kr/learn/courses/30/lessons/12971

import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int stickerLen = sticker.length;
        if(stickerLen == 1) return sticker[0];
        if(stickerLen == 2) return Math.max(sticker[0], sticker[1]);
        
        // 마지막 스티커를 떼는 경우
        int[] st1 = new int[stickerLen];
        for(int i=0;i<stickerLen;i++) {
            st1[i] = sticker[i];
        }
        st1[stickerLen-1]=0;
        
        // 첫 번째 스티커를 떼는 경우
        int[] st2 = new int[stickerLen];
        for(int i=0;i<stickerLen-1;i++) {
            st2[i] = sticker[i+1];
        }
        st2[stickerLen-1]=0;
        
        int st1Max = getMax(st1);
        int st2Max = getMax(st2);
        
        return Math.max(st1Max, st2Max);
    }
    
    private int getMax(int[] st) {
        int[] dp = new int[st.length];
        dp[0] = st[0];
        dp[1] = Math.max(dp[0], st[1]);
        
        for(int i=0;i<st.length - 2;i++) {
            dp[i+2] = Math.max(dp[i] + st[i+2], dp[i+1]);
        }
        
        return dp[st.length-1];
    }
}