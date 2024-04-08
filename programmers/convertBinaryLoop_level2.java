// https://school.programmers.co.kr/learn/courses/30/lessons/70129
// 이진 변환 반복하기

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int removedZeroCnt = 0;
        int curLength = Integer.MAX_VALUE;
        String curString = s;
        int executeCnt = 0;

        while(curLength > 1) {
            executeCnt++;

            int beforeLength = curString.length();
            int calcLength = removeZero(curString);
            
            removedZeroCnt += (beforeLength - calcLength);
            
            int[] digits = lengthToBinary(calcLength);
            
            curString = digitsToString(digits);
            curLength = curString.length();
        }
        
        answer = new int[]{executeCnt, removedZeroCnt};
        
        return answer;
    }
    
    public int removeZero(String inputStr) {
        String onlyOne = inputStr.replaceAll("0","");
        return onlyOne.length();
    }
    
    public int[] lengthToBinary(int length) {
        String binaryStr = Integer.toBinaryString(length);
        int[] digits = new int[binaryStr.length()];
        for(int i=0;i<binaryStr.length();i++) {
            digits[i] = binaryStr.charAt(i) - '0'; 
        }
        return digits;
    }
    
    public String digitsToString(int[] digits) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i < digits.length; i++) {
            sb.append(digits[i]);
        }
        
        return sb.toString();
    }
}