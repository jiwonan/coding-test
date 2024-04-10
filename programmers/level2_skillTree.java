// 스킬트리
// https://school.programmers.co.kr/learn/courses/30/lessons/49993

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String st : skill_trees) {
            String[] sk = st.split("");
            if(isValidSkillTree(skill, sk)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isValidSkillTree(String skill, String[] userSkillTree) {
        Queue<String> queue = initSkillQueue(skill);
        for(String s : userSkillTree) {
            if(!queue.contains(s)) {
                continue;
            }
            if(queue.peek().equals(s)) {
                queue.poll();
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    private Queue<String> initSkillQueue(String skill) {
        Queue<String> queue = new LinkedList<>();
        
        String[] skills = skill.split("");
        for(String s : skills) {
            queue.offer(s);
        }
        
        return queue;
    }
}