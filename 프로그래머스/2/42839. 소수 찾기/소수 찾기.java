import java.util.*;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        comb(numbers, "", visited);
        int answer = 0;
        for(int number : numberSet) {
            if(isPrime(number)) answer++;
        }
        return answer;
    }
    
    private void comb(String numbers, String current, boolean[] visited) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}