import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = stoi(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = stoi(st.nextToken());
        }

        mountain(arr);
        System.out.print(sb);
    }
    public static void mountain(int[] arr) {
        boolean flag = false;

        for(int i=1;i<arr.length;i++){
            int before = arr[i-1];
            int now = arr[i];
            if(!flag){
                if(before<now) continue;
                else flag=true;
            }
            else {
                if(before>now) continue;
                else {
                    sb.append("NO");
                    return;
                }
            }
        }
        sb.append("YES");
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}