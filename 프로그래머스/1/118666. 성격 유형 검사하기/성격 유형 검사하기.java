import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";  // 최종적으로 반환할 성격 유형 결과를 저장할 변수
        
        // 1. 4개의 성격 지표로 성격 유형을 나눕니다.
        // 성격 유형별 점수를 저장할 HashMap 초기화 
        // 각 성격 유형에 대한 점수를 저장할 HashMap
        HashMap<Character, Integer> map = new HashMap<>(); 
        map.put('R', 0); map.put('T', 0);
        map.put('C', 0); map.put('F', 0);
        map.put('J', 0); map.put('M', 0);
        map.put('A', 0); map.put('N', 0);

        // 2. 각 질문에 대해 선택지를 선택하고 점수를 계산합니다.
        // 설문 조사와 선택지를 함께 처리
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0); // 비동의 성격 유형
            char agree = survey[i].charAt(1);    // 동의 성격 유형
            int choice = choices[i];

            // 선택 : 1, 2, 3, 4, 5, 6, 7
            // 점수 : 3, 2, 1, 0, 1, 2, 3
            if (choice < 4) {  // 비동의 쪽을 선택한 경우
                map.put(disagree, map.get(disagree) + (4 - choice));  // 비동의한 성격 유형에 점수 추가
            } else if (choice > 4) {  // 동의 쪽을 선택한 경우
                map.put(agree, map.get(agree) + (choice - 4));  // 동의한 성격 유형에 점수 추가
            }
        }

        // 3. 각 지표에서 더 높은 점수를 받은 성격 유형을 선택하여
        //    점수가 같다면 사전 순으로 빠른 성격 유형을 선택합니다.
        // R-T 지표 비교
        if (map.get('R') >= map.get('T'))
            answer = "R";  // R이 점수가 높거나 같으면 R을 선택
        else
            answer = "T";  // T가 점수가 더 높으면 T를 선택

        // C-F 지표 비교
        answer += (map.get('C') >= map.get('F')) ? "C" : "F";

        // J-M 지표 비교
        answer += (map.get('J') >= map.get('M')) ? "J" : "M";

        // A-N 지표 비교
        answer += (map.get('A') >= map.get('N')) ? "A" : "N";

        // 3. 최종적으로 선택된 성격 유형 결과를 반환
        return answer;
    }
}