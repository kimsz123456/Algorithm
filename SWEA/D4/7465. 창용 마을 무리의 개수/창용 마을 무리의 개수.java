import java.io.*;
import java.util.*;

public class Solution {
    static int[] sets, size;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            size = new int[n + 1];
            sets = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sets[i] = i;
                size[i] = 1; // 각 원소의 크기를 1로 초기화
            }
            for (int i = 0; i < m; i++) {

                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }
            Set<Integer> set = new HashSet<>();
            for(int i=1;i<=n;i++) {
            	set.add(sets[i]);
            }
            sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb);
    }

    public static int find(int x) {
        if (x != sets[x])
            sets[x] = find(sets[x]); // 경로 압축
        return sets[x];
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if (pa != pb) {
            // 작은 트리를 큰 트리 아래에 붙인다.
            if (size[pa] < size[pb]) {
                sets[pa] = pb;
                size[pb] += size[pa];
            } else {
                sets[pb] = pa;
                size[pa] += size[pb];
            }
            
            // 자식들 업데이트
            for (int i = 1; i <= n; i++) {
                find(i); // 모든 요소의 부모를 최신화
            }
        }
    }
}