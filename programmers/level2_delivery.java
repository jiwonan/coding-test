// 배달
// https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.*;

class Solution {
    int N;
    int K;
    boolean[] visit;
    public int solution(int N, int[][] road, int K) {
        this.N = N;
        this.K = K;
        
        int answer = 0;
        
        List<List<Node>> nodes = init(road, N);
        
        visit = new boolean[N+1];
        visit[1] = true;
        
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        dfs(nodes, visited, 1, 0);
        
        for(int i=0;i < this.visit.length;i++) {
            if(this.visit[i]) answer++;
        }
        

        return answer;
    }
    
    private void dfs(List<List<Node>> nodes, boolean[] visited, int start, int dist) {
        for(int i=0;i<nodes.get(start).size();i++) {
            Node node = nodes.get(start).get(i);
            int end = node.end;
            int length = node.length;
            if(!visited[end] && dist+length <= K) {
                visited[end] = true;
                visit[end] = true;
                dfs(nodes, visited, end, dist+length);
                visited[end]=false;
            }
        }
    }
    
    private List<List<Node>> init(int[][] road, int n) {
        List<List<Node>> init = new ArrayList<>();
        
        for(int i=0;i<=n;i++) {
            init.add(new ArrayList<>());
        }
        
        for(int i=0;i<road.length;i++) {
            int[] data = road[i];
            
            init.get(data[0]).add(new Node(data[1],data[2]));
            init.get(data[1]).add(new Node(data[0],data[2]));
        }
        
        return init;
    }
}

class Node {
    public int end;
    public int length;
    
    public Node(int end, int length) {
        this.end = end;
        this.length = length;
    }
}