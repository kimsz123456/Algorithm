import java.util.*;
import java.io.*;

public class Main {
    static int N,Q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        Q = stoi(st.nextToken());

        int r1,c1,r2,c2;
        for(int i=1;i<=Q;i++){
            st = new StringTokenizer(br.readLine());
            r1 = stoi(st.nextToken());
            r1 = stoi(st.nextToken());
            simulate();
        }

    }

    static void simulate(){
        
    }

    static int stoi(String str){
        return Integer.parseInt(str);
    }
}