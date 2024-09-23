import java.io.*;
import java.util.*;

public class Main {
	
	static class Student implements Comparable<Student>{
		String name;
		int korean,english,math;
		
		Student(String name, int korean, int english, int math){
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
		
		@Override
		public int compareTo(Main.Student other) {
			if(this.korean != other.korean) {
				return other.korean - this.korean;
			}
			if(this.english != other.english) {
				return this.english - other.english;
			}
			if(this.math != other.math) {
				return other.math - this.math;
			}
			return this.name.compareTo(other.name);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		List<Student> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			list.add(new Student(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		for(Student student : list) {
			System.out.println(student.name);
		}
	}
}
