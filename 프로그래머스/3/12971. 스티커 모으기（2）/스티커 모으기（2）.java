class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;

        if (len == 1) return sticker[0];

        int [][] dp = new int[len][2];
        
        
        dp[0][0] = sticker[0];
        dp[1][0] = dp[0][0];
        
        dp[0][1] = 0;
        dp[1][1] = sticker[1];
        for (int i = 2; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 2][0] + sticker[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][1] + sticker[i], dp[i - 1][1]);
        }
        
        answer = Math.max(dp[len - 2][0], dp[len - 1][1]);
        return answer;
    }
}