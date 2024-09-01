import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static boolean[] selected;
    static int N, result;
    static List<Integer> xlist, ylist, selectedx, selectedy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            xlist = new ArrayList<>();
            ylist = new ArrayList<>();
            selectedx = new ArrayList<>();
            selectedy = new ArrayList<>();
            selected = new boolean[N + 2];
            selected[0] = true;  // 시작점
            selected[1] = true;  // 끝점

            // 시작점 좌표
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            xlist.add(startX);
            ylist.add(startY);

            // 끝점 좌표
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            xlist.add(endX);
            ylist.add(endY);

            // 고객 좌표들
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                xlist.add(x);
                ylist.add(y);
            }

            result = Integer.MAX_VALUE;
            perm(0);
            System.out.println("#" + tc + " " + result);
        }
    }

    static void perm(int count) {
        if (count == N) {
            int length = calc(selectedx, selectedy);
            result = Math.min(length, result);
            return;
        }

        for (int i = 2; i < xlist.size(); i++) { // 2부터 시작해 시작점과 끝점 제외
            if (!selected[i]) {
                selected[i] = true;
                selectedx.add(xlist.get(i));
                selectedy.add(ylist.get(i));
                perm(count + 1);

                // 백트래킹
                selected[i] = false;
                selectedx.remove(selectedx.size() - 1);
                selectedy.remove(selectedy.size() - 1);
            }
        }
    }
    
    static int calc(List<Integer> x, List<Integer> y) {
        int length = 0;

        // 시작점에서 첫 번째 좌표까지의 거리
        length += Math.abs(xlist.get(0) - x.get(0)) + Math.abs(ylist.get(0) - y.get(0));

        // 순차적인 좌표 간의 거리
        for (int i = 0; i < x.size() - 1; i++) {
            length += Math.abs(x.get(i) - x.get(i + 1)) + Math.abs(y.get(i) - y.get(i + 1));
        }

        // 마지막 좌표에서 끝점까지의 거리
        length += Math.abs(x.get(x.size() - 1) - xlist.get(1)) + Math.abs(y.get(y.size() - 1) - ylist.get(1));

        return length;
    }
}