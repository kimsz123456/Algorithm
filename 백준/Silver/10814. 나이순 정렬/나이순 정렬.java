import java.io.*;
import java.util.*;

public class Main {
	static class Member {
	    int age;
	    String name;

	    Member(int age, String name) {
	        this.age = age;
	        this.name = name;
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Member> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st  = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Member(age, name));
		}
		
		
		Collections.sort(list, (m1, m2) -> Integer.compare(m1.age, m2.age));
		
		for (Member member : list) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
		
		System.out.println(sb);
	}
}