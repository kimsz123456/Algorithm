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
        
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<N;i++) {
        	set.add(br.readLine());
        }
        
        List<String> list = new ArrayList<>();
        for(int i=0;i<M;i++) {
        	String str = br.readLine();
        	if(set.contains(str)) {
        		list.add(str);
        	}
        }
        Collections.sort(list);
        
        sb.append(list.size()).append("\n");
        for(String word : list) {
        	sb.append(word).append("\n");
        }
        
        System.out.println(sb);
    }
}