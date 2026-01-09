import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        boolean[] init = new boolean[N];
        boolean[] target = new boolean[N];
        String s1 = br.readLine();
        String s2 = br.readLine();
        for(int i=0;i<N;i++) {
            init[i] = (s1.charAt(i)=='1')?true:false;
            target[i] = (s2.charAt(i)=='1')?true:false;
        }

        int first = solve(0,Arrays.copyOf(init,N),target);
        init[0] = !init[0];
        init[1] = !init[1];
        int second = solve(1,init,target);
        int answer = Math.min(first,second);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static Integer solve(int count,boolean[] init, boolean[] target) {
        int n = init.length;
        for(int i=0;i<n-2;i++) {
            if(init[i]!=target[i]) {
                count++;
                for(int j=i;j<i+3;j++) {
                    init[j]=!init[j];
                }
            }
        }
        if(init[n-2]==target[n-2] && init[n-1]==target[n-1]) {
            return count;
        }
        else if(init[n-2]!=target[n-2] && init[n-1]!=target[n-1]) {
            return count+1;
        }
        else return Integer.MAX_VALUE;
    }

    public static Integer stoi(String str) {
        return Integer.parseInt(str);
    }
}
