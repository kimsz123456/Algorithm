import java.io.*;
import java.util.*;

public class Main {
	static class Person{
		int x, y,rank;
		
		Person(int x,int y,int rank){
			this.x=x;
			this.y=y;
			this.rank=rank;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Person> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Person(x,y,1));
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				Person a = list.get(i);
				Person b = list.get(j);
				if(a.x<b.x&&a.y<b.y) {
					a.rank++;
				}
			}
		}
		
		for(Person p : list) {
			System.out.print(p.rank+" ");
		}
	}
}