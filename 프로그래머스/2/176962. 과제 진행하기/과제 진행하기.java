import java.util.*;

class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        // 1. 시간을 분으로 변환하고, 정렬
        for (String[] plan : plans) {
            String[] time = plan[1].split(":");
            int h = Integer.parseInt(time[0]);  // 시간을 hh:mm에서 분으로 변환
            int m = Integer.parseInt(time[1]);
            plan[1] = String.valueOf(h * 60 + m);  // 시작 시간을 분으로 저장
            plan[2] = String.valueOf(Integer.parseInt(plan[2]));  // 소요 시간을 정수로 변환
        }
        
        // 시작 시간 기준으로 과제 정렬 (오름차순)
        Arrays.sort(plans, Comparator.comparingInt(plan -> Integer.parseInt(plan[1])));

        // 멈춘 과제를 저장할 스택
        Stack<String[]> stack = new Stack<>();
        
        // 2. 모든 과제 처리
        for (int i = 0; i < plans.length - 1; i++) {
            // 현재 과제 정보
            String subject = plans[i][0];
            int startTime = Integer.parseInt(plans[i][1]);
            int duration = Integer.parseInt(plans[i][2]);
            // 다음 과제의 시작 시간
            int nextStart = Integer.parseInt(plans[i + 1][1]);
            
            // 2.1 다음 과제 시간까지 끝낼 수 있는지?
            // 현재 과제를 끝낼 수 있는 경우
            if (startTime + duration <= nextStart) {
                // 현재 과제 완료
                answer.add(subject);
                // 남은 시간 계산
                int remainingTime = nextStart - (startTime + duration);
                
                // 남은 시간을 활용해 스택에 있는 멈춘 과제 처리
                // 2.1.1 있으면 남은 시간으로 남은 과제 처리
                while (remainingTime > 0 && !stack.isEmpty()) {
                    String[] pausedTask = stack.pop();
                    String pausedSubject = pausedTask[0];
                    int pausedDuration = Integer.parseInt(pausedTask[1]);
                    
                    // 남은 시간이 멈춘 과제 시간보다 크면
                    if (remainingTime >= pausedDuration) {
                        // 과제 완료
                        answer.add(pausedSubject);
                        // 남은 시간을 과제 시간으로 차감
                        remainingTime -= pausedDuration;
                    } else {
                        // 일부만 끝내고 다시 저장
                        stack.push(new String[]{pausedSubject, String.valueOf(pausedDuration - remainingTime)});
                        break;
                    }
                }
            } else {
                // 2.2 없으면 밀린 과제로 넘김
                // 현재 과제를 다 끝내지 못하면 스택에 남은 시간을 저장
                stack.push(new String[]{subject, String.valueOf(duration - (nextStart - startTime))});
            }
        }
        
        // 3. 마지막 과제는 밀린 과제 뒤로 넘김
        stack.push(new String[]{plans[plans.length - 1][0], plans[plans.length - 1][2]});
        
        // 4. 남은 과제 모두 가장 최근 멈춘 것부터 해결
        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }

        return answer;  // 최종 완료된 과제 순서 반환
    }
}