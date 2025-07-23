import java.util.*;

class Solution {
    
    static class Node {
        int x,y,t;
        
        Node(int x, int y, int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
        
        public boolean equals(Node other) {
            return this.x==other.x && this.y == other.y && this.t==other.t;
        }
        
        @Override
        public String toString() {
            return this.x+" "+this.y+" "+this.t;
        }
    }
    static List<Node>[] traces;
        
    public int solution(int[][] points, int[][] routes) {
        int N = points.length;
        int x = routes.length;
        
        traces = new ArrayList[x+1];
        for(int i=1;i<=x;i++) {
            traces[i] = new ArrayList<>();
        }
        
        
        for(int i=0;i<x;i++){
            int num = i+1;
            int startR = points[routes[i][0]-1][0], startC=points[routes[i][0]-1][1];
            int time=0;
            
            traces[num].add(new Node(startR,startC,0));
            for(int j=1;j<routes[i].length;j++){
                int targetR = points[routes[i][j]-1][0];
                int targetC = points[routes[i][j]-1][1];
                while(startR!=targetR) {
                    time++;
                    if(startR<targetR) startR++;
                    else startR--;
                    traces[num].add(new Node(startR,startC,time));
                }
                while(startC!=targetC) {
                    time++;
                    if(startC<targetC) startC++;
                    else startC--;
                    traces[num].add(new Node(startR,startC,time));
                }
            }
        }
        
        Map<Integer, Map<String, Integer>> timeMap = new HashMap<>();
        for (int i = 1; i <= x; i++) {
            for (Node trace : traces[i]) {
                timeMap.putIfAbsent(trace.t, new HashMap<>());
                String key = trace.x + "," + trace.y;
                Map<String, Integer> positionMap = timeMap.get(trace.t);
                positionMap.put(key, positionMap.getOrDefault(key, 0) + 1);
            }
        }

        int answer = 0;
        for (Map<String, Integer> posMap : timeMap.values()) {
            for (int cnt : posMap.values()) {
                if (cnt >= 2) answer++;
            }
        }
        return answer;
    }
}