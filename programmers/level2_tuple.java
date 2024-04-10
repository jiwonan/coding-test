// 튜플
// https://school.programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        String[] numbers = parseData(s);

        String[][] sortedTuple = new String[numbers.length][];
        for(int i=0;i<numbers.length;i++) {
            String[] temp = numbers[i].split(",");
            sortedTuple[temp.length - 1] = temp;
        }

        HashSet<String> hash = new HashSet<>();
        int[] answer = new int[numbers.length];
        for(int i=0; i < sortedTuple.length;i++) {
            for(int j=0; j < sortedTuple[i].length; j++) {
                if(!hash.contains(sortedTuple[i][j])) {
                    answer[i] = Integer.parseInt(sortedTuple[i][j]);
                    hash.add(sortedTuple[i][j]);
                }
            }
        }

        return answer;
    }

    private String[] parseData(String s) {
        String[] groups = s.substring(1, s.length() - 1).split("\\},\\{");

        String[] numbers = new String[groups.length];
        for(int i=0; i < groups.length; i++) {
            numbers[i] = groups[i].replace("}","").replace("{","");
        }

        return numbers;
    }
}