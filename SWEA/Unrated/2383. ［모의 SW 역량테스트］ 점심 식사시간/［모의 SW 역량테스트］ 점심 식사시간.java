import java.io.*;
import java.util.*;

class Person {
    int r, c; // 사람의 위치
    int[] dist; // 각 계단까지의 거리

    Person(int r, int c, int stairCount) {
        this.r = r;
        this.c = c;
        this.dist = new int[stairCount];
    }
}

class Stair {
    int r, c, length;

    Stair(int r, int c, int length) {
        this.r = r;
        this.c = c;
        this.length = length;
    }
}

public class Solution {
    static int N, minTime;
    static List<Person> person;
    static List<Stair> stair;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            person = new ArrayList<>();
            stair = new ArrayList<>();
            minTime = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        person.add(new Person(i, j, 2));
                    } else if (num > 1) {
                        stair.add(new Stair(i, j, num));
                    }
                }
            }

            // 각 사람의 위치에서 각 계단까지의 거리 계산
            for (Person p : person) {
                for (int i = 0; i < 2; i++) {
                    p.dist[i] = Math.abs(p.r - stair.get(i).r) + Math.abs(p.c - stair.get(i).c);
                }
            }

            // DFS를 통해 각 사람이 어느 계단을 사용할지 결정
            dfs(0, new int[person.size()]);

            sb.append("#").append(tc).append(" ").append(minTime).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int[] selections) {
        if (depth == person.size()) {
            // 모든 사람이 계단을 선택했으면 시간을 계산
            minTime = Math.min(minTime, calculateTime(selections));
            return;
        }

        // 현재 사람에게 각 계단을 선택하게 함
        for (int i = 0; i < 2; i++) {
            selections[depth] = i;
            dfs(depth + 1, selections);
        }
    }

    public static int calculateTime(int[] selections) {
        List<Integer>[] arrivalTimes = new ArrayList[2];
        arrivalTimes[0] = new ArrayList<>();
        arrivalTimes[1] = new ArrayList<>();

        // 각 사람의 계단 도착 시간을 리스트에 추가
        for (int i = 0; i < person.size(); i++) {
            int stairIndex = selections[i];
            int arrivalTime = person.get(i).dist[stairIndex] + 1; // 도착 시간 (계단까지의 거리 + 1분)
            arrivalTimes[stairIndex].add(arrivalTime);
        }

        // 각 계단의 도착 시간을 오름차순으로 정렬
        for (int i = 0; i < 2; i++) {
            Collections.sort(arrivalTimes[i]);
        }

        int[] stairTimes = new int[2]; // 각 계단의 최종 시간을 저장

        // 각 계단에 대해 시간 계산
        for (int i = 0; i < 2; i++) {
            int currentTime = 0; // 현재 시간
            Queue<Integer> stairQueue = new LinkedList<>(); // 계단을 내려가는 사람들의 리스트

            for (int arrivalTime : arrivalTimes[i]) {
                // 현재 시간이 도착 시간보다 작다면 도착 시간으로 업데이트
                if (stairQueue.size() >= 3) {
                    currentTime = stairQueue.poll(); // 이전 사람들 제거
                }
                currentTime = Math.max(currentTime, arrivalTime);

                // 계단에 있는 사람들이 내려갈 수 있는지 체크
                while (!stairQueue.isEmpty() && stairQueue.peek() <= currentTime) {
                    stairQueue.poll(); // 내려간 사람 제거
                }

                // 현재 사람이 계단을 내려가기 시작
                stairQueue.offer(currentTime + stair.get(i).length);

                // 대기 시간 처리: 4명 이상일 때 대기 1분
                if (stairQueue.size() > 3) {
                    currentTime = stairQueue.peek() + 1;
                }
            }

            // 마지막 사람이 계단을 다 내려간 시간을 저장
            while (!stairQueue.isEmpty()) {
                currentTime = stairQueue.poll();
            }
            stairTimes[i] = currentTime;
        }

        // 두 계단의 최대 시간을 반환 (모든 사람이 내려가야 끝이므로)
        return Math.max(stairTimes[0], stairTimes[1]);
    }
}
