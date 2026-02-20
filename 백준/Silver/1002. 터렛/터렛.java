import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = stoi(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());

            int x1 = stoi(st.nextToken());
            int y1 = stoi(st.nextToken());
            int r1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());
            int r2 = stoi(st.nextToken());

            int answer = calculate(x1,y1,r1,x2,y2,r2);
            System.out.println(answer);
        }

    }

    public static int calculate(int x1,int y1, int r1, int x2,int y2, int r2) {
        if(x1==x2 && y1==y2 && r1==r2) return -1;

        int dx = x2 - x1;
        int dy = y2 - y1;
        int dist = dx*dx + dy*dy;

        int plus = (r1+r2)*(r1+r2);
        int minus = (r1-r2)*(r1-r2);

        if(dist > plus) return 0;
        if(dist < minus) return 0;
        if(dist == plus) return 1;
        if(dist == minus) return 1;
        return 2;
    }

    public static Integer stoi(String str) {
        return Integer.parseInt(str);
    }
}
