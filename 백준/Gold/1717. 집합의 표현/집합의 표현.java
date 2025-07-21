import java.util.*;
import java.io.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        set = new int[N+1];
        for(int i=0;i<=N;i++){
            set[i] = i;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int operation = stoi(st.nextToken());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            if(operation==0){
                union(a,b);
            }
            else{
                check(a,b);
            }
        }
        System.out.print(sb);
    }
    public static void union(int a,int b){
        set[find(b)] = find(a);
    }

    public static int find(int a){
        if(set[a]==a) {
            return a;
        }
        else {
            return find(set[a]);
        }
    }

    public static void check(int a,int b){
        if(find(a)==find(b)) sb.append("YES\n");
        else sb.append("NO\n");
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}