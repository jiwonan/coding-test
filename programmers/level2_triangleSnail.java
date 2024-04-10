// 삼각 달팽이
// https://school.programmers.co.kr/learn/courses/30/lessons/68645

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int maxNum = 0;
        for(int i=1;i<=n;i++) {
            maxNum = maxNum + i;
        }
        
        int[] answer = new int[maxNum];
        
        int dir = 0; // 0: 아래, 1: 오른쪽, 2: 위
        int num = 1;
        
        int row=0;
        int col=0;
        while(true) {
            arr[row][col] = num;

            if(dir == 0 && (row == n - 1 || (row < n-1 && arr[row+1][col] != 0))) {
                dir = 1;
            } else if(dir == 1 && (col == n - 1 || (col < n-1 && arr[row][col + 1] != 0))) {
                dir = 2;
            } else if(dir == 2 && (row > 0 && arr[row-1][col-1] != 0)) {
                dir = 0;
            }

            if(dir == 0) {
                row++;
            } else if(dir == 1) {
                col++;
            } else if(dir == 2) {
                row--;
                col--;
            }


            if(num == maxNum) break;
            num++;
        }
        
        int idx = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(arr[i][j] != 0) {
                    answer[idx++] = arr[i][j];
                }
            }
        }
        
        return answer;
    }
}