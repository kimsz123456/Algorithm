import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static Map<String, String[]> tree;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N =Integer.parseInt(br.readLine());
		
		tree = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			tree.put(root,new String[] {left,right});
		}
		preOrder("A");
		sb.append("\n");
		inOrder("A");
		sb.append("\n");
		postOrder("A");
		sb.append("\n");
		System.out.println(sb);
	}
	
	static void preOrder(String node) {
        if (node.equals("."))
            return;

        sb.append(node);
        preOrder(tree.get(node)[0]);
        preOrder(tree.get(node)[1]);
    }
	static void inOrder(String node) {
        if (node.equals("."))
            return;

        inOrder(tree.get(node)[0]);
        sb.append(node);
        inOrder(tree.get(node)[1]);
    }
	static void postOrder(String node) {
        if (node.equals("."))
            return;

        postOrder(tree.get(node)[0]);
        postOrder(tree.get(node)[1]);
        sb.append(node);
    }
}