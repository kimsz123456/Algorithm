public class Solution {
    public int solution(String s) {
        int answer = 0;

        // 1. 단순 방식
        // - 모든 단어를 숫자로 변경한다
        if (s.contains("zero")) {
            s = s.replace("zero", "0");
        }
        
        s = s.replace("one", "1");
        s = s.replace("two", "2");
        s = s.replace("three", "3");
        s = s.replace("four", "4");
        s = s.replace("five", "5");
        s = s.replace("six", "6");
        s = s.replace("seven", "7");
        s = s.replace("eight", "8");
        s = s.replace("nine", "9");


        answer = Integer.parseInt(s);  // 문자열을 숫자로 변환
        return answer;
    }
}