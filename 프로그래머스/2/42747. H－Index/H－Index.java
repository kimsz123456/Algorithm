import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int n = citations.length;
        int left = 0;
        int right = n-1;
        Arrays.sort(citations);
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int overH = n - mid;
            if (citations[mid] >= overH) {
                answer = Math.max(answer, overH);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}