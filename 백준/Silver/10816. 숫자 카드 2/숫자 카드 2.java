import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine() );
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num,map.getOrDefault(num, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			System.out.print(map.getOrDefault(Integer.parseInt(st.nextToken()),0)+" ");
		}
	}
}