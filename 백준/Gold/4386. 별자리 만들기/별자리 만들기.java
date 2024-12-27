import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int w;
        float cost;

        Edge(int w, float cost) {
            this.w = w;
            this.cost = cost;
        }
    }
    
	static int N;
    static float answer;
    static float[][] points;
    static ArrayList<Edge>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        points = new float[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Float.parseFloat(st.nextToken());
            points[i][1] = Float.parseFloat(st.nextToken());
        }

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    graph[i].add(new Edge(j, getDistance(points[i], points[j])));
                }
            }
        }

        System.out.printf("%.2f\n", prim(0));
    }

    static float prim(int start) {
        boolean[] visited = new boolean[N];

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> (int)(o1.cost - o2.cost));
        pq.offer(new Edge(start, 0));

        float result = 0.0f;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.w;
            float cost = edge.cost;

            if(visited[v]) continue;

            visited[v] = true;
            result += cost;

            for (Edge e : graph[v]) {
                if (!visited[e.w]) {
                    pq.add(e);
                }
            }
        }

        return result;
    }

    static float getDistance(float[] point1, float[] point2) {
        return (float)(Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2)));
    }
}