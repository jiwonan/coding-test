// 오픈채팅방
// https://school.programmers.co.kr/learn/courses/30/lessons/42888

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        List<String> behaviors = new ArrayList<>();
        HashMap<String, String> userNickName = new HashMap<>();
        
        for(String r : record) {
            String[] data = r.split(" ");
            // 가장 최근 닉네임 저장
            if(!data[0].equals("Leave")) {
                userNickName.put(data[1], data[2]);
            }
            
            // 행동 저장(결과 출력용)
            behaviors.add(data[1]+" "+data[0]);
        }
        
        for(String be : behaviors) {
            String[] data = be.split(" ");
            String behaviorKor = convertBehaviorToKor(data[1]);
            if(behaviorKor == null) continue;
            
            String nickName = userNickName.get(data[0]);
            answer.add(nickName + "님이 " + behaviorKor);
            
        }
        
        return answer.toArray(new String[answer.size()]);
    }
    
    private String convertBehaviorToKor(String behavior) {
        switch(behavior) {
            case "Enter":
                return "들어왔습니다.";
            case "Leave":
                return "나갔습니다.";
        }
        return null;
    }
}