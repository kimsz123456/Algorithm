import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = nextInt();
        int C = nextInt();

        int[] router = new int[N];
        for(int i=0;i<N;i++) {
            router[i] = nextInt();
        }
        Arrays.sort(router);

        int left = 1;
        int right = router[N-1]-router[0]+1;
        int mid,count;
        while(left<=right) {
            mid = (left+right)/2;
            count = 1;
            int now = router[0];
            for(int i=1;i<N;i++) {
                if(router[i]-now<mid) continue;
                count++;
                now = router[i];
            }
            if(count>=C) left = mid+1;
            else right = mid-1;
        }
        System.out.println(right);
    }
    static int nextInt() throws IOException {
        int c;
        while (!Character.isDigit(c = System.in.read()));
        int value = c & 15;
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }
}
