// 기지국 설치
// https://school.programmers.co.kr/learn/courses/30/lessons/12979

import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int left=1;
        int sigLength = w * 2 + 1;
        for(int station : stations) {
            if(station - w > left) {
                int noInternet = (station - w) - left;

                // 나머지가 없는 경우 (소수점 아래로 가지 않는 경우)
                if(noInternet % sigLength == 0) {
                    answer += noInternet / sigLength;
                }
                // 나머지가 있는 경우 올림 처리
                else {
                    answer += (noInternet / sigLength) + 1;
                }
            }
            left = station + w + 1;
        }
        
        // 우측에 아파트가 남은 경우
        if(left <= n) {
            int noInternet = n - left + 1;
            if(noInternet % sigLength == 0) {
                answer += noInternet / sigLength;
            } else {
                answer += (noInternet / sigLength) + 1;
            }
        }

        return answer;
    }
}