public class Solution {
    static int N;
    public long solution(int[][] land, int P, int Q) {
        N = land.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i=0;i<N;i++) {
            for (int j=0; j<N; j++) {
                min = Math.min(min, land[i][j]);
                max = Math.max(max, land[i][j]);
            }
        }

        long answer = Long.MAX_VALUE;

        while (min <= max) {
            int mid = (min + max) / 2;

            long before = calculate(land, P, Q, mid);
            long next = calculate(land, P, Q, mid + 1);

            answer = Math.min(answer, Math.min(before, next));

            if (before < next) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }

    private long calculate(int[][] land, int P, int Q, int height) {
        long cost = 0;
        for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(height < land[r][c]) {
					cost +=  ( (long) (land[r][c] - height) * Q);
				}else {
					cost +=  ( (long) (height - land[r][c]) * P);
				}
			}
		}
        return cost;
    }
}
