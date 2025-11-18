import java.io.*;

public class Main {
    static final long MOD = 100000;
    static char[] s;
    static int n;
    static Long[][] dp;
    static char[] open = {'(', '{', '['};
    static char[] close = {')', '}', ']'};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = br.readLine().toCharArray();
        
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }
        
        dp = new Long[n][n];
        long ans = solve(0, n - 1);
        
        String result = String.valueOf(ans);
        if (result.length() <= 5) {
            System.out.println(result);
        } else {
            System.out.println(result.substring(result.length() - 5));
        }
    }
    
    static long solve(int l, int r) {
        if (l > r) return 1;
        if ((r - l + 1) % 2 == 1) return 0;
        if (dp[l][r] != null) return dp[l][r];
        
        long res = 0;
        for (int k = l + 1; k <= r; k += 2) {
            for (int type = 0; type < 3; type++) {
                if ((s[l] == open[type] || s[l] == '?') && 
                    (s[k] == close[type] || s[k] == '?')) {
                    long left = solve(l + 1, k - 1);
                    long right = solve(k + 1, r);
                    res += left * right;
                    
                    if (res > MOD) {
                        res %= MOD;
                        res += MOD;
                    }
                }
            }
        }
        
        dp[l][r] = res;
        return res;
    }
}