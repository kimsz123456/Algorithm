import java.util.*;

class Solution {
    static class Log {
        double start, end;

        Log(double start, double end) {
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String[] lines) {
        List<Log> logs = new ArrayList<>();

        for (String line : lines) {
            int h = Integer.parseInt(line.substring(11, 13));
            int m = Integer.parseInt(line.substring(14, 16));
            double s = Double.parseDouble(line.substring(17, 23));
            double length = Double.parseDouble(line.substring(24, line.length() - 1));

            double end = h * 3600 + m * 60 + s;
            double start = end - length + 0.001;

            logs.add(new Log(start, end));
        }

        
        logs.sort((a, b) -> Double.compare(a.end, b.end));

        int answer = 0;

        
        for (int i = 0; i < logs.size(); i++) {
            double start = logs.get(i).end;
            double end = start + 1.0;
            int count = 0;

            
            for (Log log : logs) {
                if (log.start < end && log.end >= start) {
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}
