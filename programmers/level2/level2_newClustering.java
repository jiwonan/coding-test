// 뉴스 클러스터링
// https://school.programmers.co.kr/learn/courses/30/lessons/17677

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> str1List = getArray(str1);
        List<String> str2List = getArray(str2);
        
        // 합집합: A + B - A ∩ B
        List<String> intersaction = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        for(String word : str1List) {
            if(str2List.contains(word)) {
                intersaction.add(word);
                str2List.remove(word);
            }
            union.add(word);
        }
        
        for(String word : str2List) {
            union.add(word);
        }
        
        if(union.size() == 0) {
            return 65536;
        }
        
        return (int)(((double)intersaction.size() / union.size()) * 65536);
    }
    
    private List<String> getArray(String s) {
        List<String> list = new ArrayList<>();
        for(int i=0; i < s.length() - 1; i++) {
            String value = s.substring(i, i+2).toUpperCase();
            if(value.matches("^[a-zA-Z]*$")) {
                list.add(value);
            }
        }
        return list;
    }
}