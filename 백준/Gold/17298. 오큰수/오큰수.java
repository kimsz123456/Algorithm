import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Stack<Integer> stack = new Stack<Integer>();

        int N = stoi(br.readLine());

        int[] arr = new int[N];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = stoi(st.nextToken());
            arr[i] = num;
        }

        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }

            stack.add(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()]=-1;
        }

        for(int i=0;i<N;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }

    public static Integer stoi(String str){
        return Integer.parseInt(str);
    }
}