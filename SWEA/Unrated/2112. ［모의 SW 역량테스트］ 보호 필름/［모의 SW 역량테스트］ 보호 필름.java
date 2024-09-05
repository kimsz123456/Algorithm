import java.io.*;
import java.util.*;
 
public class Solution {
    static int D, W, K,result;
    static int[][] arr,copyarr;
    static int[] selected;
    static boolean resume;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
 
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
 
            arr = new int[D][W];
            copyarr = new int[D][W];
            selected = new int[D];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            resume = false;
            result=K;
            for(int num=0;num<K;num++) {
                if(resume) {
                    break;
                }
                comb(0,0,num);
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
 
    public static void comb(int idx, int count, int num) {
        if (count == num) {
            for(int i=0 ; i<D ; i++) {
                for(int j=0 ; j<W ; j++) {
                    if(selected[i]==0) {
                        copyarr[i][j] = arr[i][j];
                    } else if (selected[i] == 1) {
                        copyarr[i][j] = 1;
                    } else {
                        copyarr[i][j] = 0;
                    }
                }
            }
            if(test(copyarr)) {
                result=num;
                resume=true;
            }
            return;
        }
        if(idx>=D) return;
         
        for(int i=0 ; i<3 ; i++) {
            selected[idx] = i;
            if(i!=0) comb(idx+1,count+1,num);
            else comb(idx+1,count,num);
            selected[idx] = 0;
        }
    }
 
    public static boolean test(int[][] arr) {
        boolean result=false;
         
        for(int j=0;j<W;j++) {
            for(int i=0;i<D-K+1;i++) {
                int check = arr[i][j];
                for(int k=0;k<K;k++) {
                    if(arr[i+k][j]==check) {
                        result=true;
                    }
                    else {
                        result=false;
                        break;
                    }
                }
                if(result) {
                    break;
                }
            }
            if(!result) {
                return false;
            }
        }
        if (result) {
            return true;
        }
        return false;
    }
 
}