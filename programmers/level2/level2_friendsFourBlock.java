// 프렌즈4블록
// https://school.programmers.co.kr/learn/courses/30/lessons/17679

import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] score = new int[m][n];
        String[][] gameBoard = initBoard(m,n,board);       
        while(true) {
            // 제거 대상 블록 체크
            for(int row=0;row < m-1; row++) {
                for(int col=0;col < n-1; col++) {
                    String a = gameBoard[row][col];
                    if(a.equals("-")) {
                        score[row][col] = -1;
                        continue;
                    }
                    String b = gameBoard[row+1][col];
                    String c = gameBoard[row][col+1];
                    String d = gameBoard[row+1][col+1];
                    if(a.equals(b) && a.equals(c) && a.equals(d)) {
                        score[row][col] = 1;
                        score[row+1][col] = 1;
                        score[row][col+1] = 1;
                        score[row+1][col+1] = 1;
                    }
                }
            }
            
            // 점수 체크
            long scoreCnt = Arrays.stream(score)
                .flatMapToInt(Arrays::stream)
                .filter(s -> s == 1)
                .count();
            
            if(scoreCnt <= 0) {
                break;
            }
            
            answer += (int)scoreCnt;
            
            // 블록 제거
            for(int col=n-1;col>=0;col--) {
                for(int row=m-1;row>=0;row--) {
                    // 블록이 이미 존재함, 혹은 더 이상 블록이 있을 수 없음.
                    if(score[row][col] == 0 || score[row][col] == -1) continue;
                    
                    score[row][col] = 0; // 스코어 초기화
                    
                    // 남은 블록 찾기
                    int existingRowIdx = row;
                    for(int r=row-1;r>=0;r--){
                        if(score[r][col] == 0 && !gameBoard[r][col].equals("-")) {
                            existingRowIdx = r;
                            score[r][col] = 1;
                            break;
                        }
                    }
                    // 위에 더 이상 남은 블록 없음
                    if(existingRowIdx == row) {
                        gameBoard[row][col] = "-"; // 게임판 빈 배열 처리
                    } else {
                        gameBoard[row][col] = gameBoard[existingRowIdx][col];
                    }
                }
            }
        }
        
        return answer;
    }
    
    private String[][] initBoard(int m, int n, String[] data) {
        String[][] board = new String[m][n];
        for(int i=0;i<m;i++) {
            String[] dataRow = data[i].split("");
            for(int j=0;j<n;j++) {
                board[i][j]= dataRow[j];
            }
        }
        
        return board;
    }
}