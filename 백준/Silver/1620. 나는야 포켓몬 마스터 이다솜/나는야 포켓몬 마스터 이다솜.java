import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<Integer,String> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(int i=1;i<=N;i++) {
        	String str = br.readLine();
            map1.put(i, str);
            map2.put(str, i);
        }
        
        for(int i=0;i<M;i++) {
            String str = br.readLine();
            // 숫자임
            if(str.charAt(0)-'A'<0) {
                int num = Integer.parseInt(str);
                sb.append(map1.get(num)).append("\n");
            }
            // 문자임
            else {
            	sb.append(map2.get(str)).append("\n");
            }
        }
        System.out.println(sb);
    }
}