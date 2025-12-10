class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        int gcdA = arrayA[0];
        for(int i=1;i<arrayA.length;i++) {
            gcdA = gcd(gcdA,arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for(int i=1; i<arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }
        int answerA = check(gcdA,arrayB);
        int answerB = check(gcdB,arrayA);
        return Math.max(answerA, answerB);

    }
    public int check(int gcd, int[] array) {
        if (gcd == 1) return 0;
        for (int value : array) {
            if (value % gcd == 0) return 0;
        }
        return gcd;
    }
    public int gcd(int A, int B) {
        if(A%B==0) {
            return B;
        }
        return gcd(B,A%B);
    }
}