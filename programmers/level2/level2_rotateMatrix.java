// 행렬 테두리 회전화기
// https://school.programmers.co.kr/learn/courses/30/lessons/77485

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] rotate = init(rows, columns);
        
        for(int i=0; i<queries.length;i++) {
            answer[i] = rotate(queries[i], rotate);
            // for(int j=0; j<rows; j++) {
            //     System.out.println(Arrays.toString(rotate[j]));
            // }
            // System.out.println("=====================");
        }
        
        return answer;
    }
    
    private int rotate(int[] coords, int[][] rotate) {
        int min = Integer.MAX_VALUE;
        int x1 = coords[0] - 1;
        int y1 = coords[1] - 1;
        int x2 = coords[2] - 1;
        int y2 = coords[3] - 1;
        
        // (x2 - x1 - 1) * 2 + (y2 - y1) * 2 -> 회전 개수
        int x = x1;
        int y = y1 + 1;
        int cur = rotate[x1][y1];
        int prev = -1;
        int dir = 1; // 1: 우, 2: 하, -1: 좌, 0: 상
        while(true) {
            prev = rotate[x][y];
            rotate[x][y] = cur;
            cur = prev;
            
            // System.out.print("("+rotate[x][y]+")");
            // if(rotate[x][y] != (x * rotate[x].length + y) + 1) {
            if(min > rotate[x][y]) {
                min = rotate[x][y];
            }
            // }
            
            // System.out.println(" - x, y " + x +", "+y);
            
            if(dir == 1 && y + 1 > y2) {
                dir = 2;
            } else if(dir == 2 && x + 1 > x2) {
                dir = -1;
            } else if(dir == -1 && y - 1 < y1) {
                dir = 0;
            } else if(dir == 0 && x - 1 < x1) {
                break;
            }
            
            if(dir == 1 || dir == -1) {
                y += dir;
            } else if(dir == 2 || dir == 0) {
                x += (dir - 1);
            }
        }
        
        return min;
    }
    
    private int[][] init(int r, int c) {
        int[][] arr = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j=0; j<c; j++) {
                arr[i][j] = (i * c + j) + 1;
            }
        }
        
        return arr;
    }
}