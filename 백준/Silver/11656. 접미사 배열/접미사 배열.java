import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		List<String> list = new ArrayList<>();
		
		for(int i=0;i<str.length();i++) {
			list.add(str.substring(i));
		}
		
		Collections.sort(list);
		
		for(String word : list) {
			System.out.println(word);
		}
	}
}
