import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            Long num = sc.nextLong();
            pq.add(reverse(num));
        }
        
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        
        sc.close();
    }
    
    static Long reverse(Long num) {
        Long reversedNum = 0L;
        while (num > 0) {
            reversedNum = reversedNum * 10 + num % 10;
            num /= 10;
        }
        return reversedNum;
    }
}