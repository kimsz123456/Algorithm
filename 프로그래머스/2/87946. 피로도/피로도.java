class Solution {
    static int[][] dungeons;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        for(int[] dungeon:dungeons) {
            min = Math.min(dungeon[0],min);
        }
        play(k,0);
        return answer;
    }
    
    public static void play(int stamina,int count) {
        boolean possible = false;
        
        for(int i=0;i<dungeons.length;i++) {
            if(!visited[i] && stamina>=dungeons[i][0]) {
                visited[i]=true;
                play(stamina-dungeons[i][1],count+1);
                visited[i]=false;
                possible=true;
            }
        }
        if(!possible) answer = Math.max(answer, count);
    }
}